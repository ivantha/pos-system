/*
 * Copyright © 02.10.2015 by O.I.Mudannayake. All Rights Reserved.
 */
package database.sql.type;

import cache.SupplierCache;
import database.sql.SQL;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import entity.Supplier;
import java.util.HashMap;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Ivantha
 */
public class SupplierManagementSQL extends SQL {

    public String generateNewID() {
        String preID = this.getLastValue("supplier", "supplier_id");
        String idX = String.format("%07d", Integer.parseInt(preID.substring(3, 10)) + 1);

        result = "su." + idX;
        return result;
    }

    public void newSupplier(Supplier supplier) {
        query = "INSERT INTO supplier(supplier_id, name, address, telephone) VALUES ("
                + "'" + supplier.getSupplierID() + "',"
                + "'" + supplier.getName() + "',"
                + "'" + supplier.getAddress() + "',"
                + "'" + supplier.getTelephone() + "')";

        c.setQuery(query);
        SupplierCache.setSupplierListChanged();
        SupplierCache.setSupplierDetailsChanged();
    }

    public void updateSupplier(Supplier supplier) {
        query = "UPDATE supplier SET "
                + "name = '" + supplier.getName() + "', "
                + "address = '" + supplier.getAddress() + "', "
                + "telephone = '" + supplier.getTelephone() + "' "
                + "WHERE supplier_id = '" + supplier.getSupplierID() + "'";

        c.setQuery(query);
        SupplierCache.setSupplierListChanged();
        SupplierCache.setSupplierDetailsChanged();
    }

    public void getSupplierDetail(HashMap<String, String> supplierIDMap, HashMap<String, String> supplierTelephoneMap, HashMap<String, String> supplierAddressMap) {
        query = "SELECT supplier_id, name, address, telephone FROM supplier ORDER BY row ASC";
        rs = c.getQuery(query);
        try {
            while (rs.next()) {
                String supplierID = rs.getString("supplier_id");
                String name = rs.getString("name");
                String address = rs.getString("address");
                String telephone = rs.getString("telephone");

                supplierIDMap.put(name, supplierID);
                supplierTelephoneMap.put(name, telephone);
                supplierAddressMap.put(name, address);
            }
        } catch (SQLException ex) {
            Logger.getLogger(SupplierManagementSQL.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void showSupplierHistory(Supplier supplier, DefaultTableModel dtm) {
        query = "SELECT po.po_no, po.date, prnx.prn_no, employee.name "
                + "FROM po "
                + "LEFT JOIN prnx ON po.po_no = prnx.po_no "
                + "INNER JOIN employee ON po.employee = employee.employee_id "
                + "WHERE po.supplier = " + "'" + supplier.getSupplierID() + "'";
        rs = c.getQuery(query);
        try {
            while (rs.next()) {
                String poNo = rs.getString("po_no");
                String date = rs.getString("date");
                String prnNo = rs.getString("prn_no");
                String employee = rs.getString("name");

                dtm.addRow(new Object[]{poNo, date, prnNo, employee});
            }
        } catch (SQLException ex) {
            Logger.getLogger(SupplierManagementSQL.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public Supplier getSupplier(String supplierName) {
        query = "SELECT supplier_id, name, address, telephone FROM supplier WHERE name = " + "'" + supplierName + "'";
        rs = c.getQuery(query);
        try {
            String supplierID;
            String name;
            String address;
            String telephone;
            while (rs.next()) {
                supplierID = rs.getString("supplier_id");
                name = rs.getString("name");
                address = rs.getString("address");
                telephone = rs.getString("telephone");
                return new Supplier(supplierID, name, address, telephone);
            }
        } catch (SQLException ex) {
            Logger.getLogger(SupplierManagementSQL.class.getName()).log(Level.SEVERE, null, ex);
            return null;
        }
        return null;
    }

    public void getSupplierList(ArrayList<String> supplierList) {
        query = "SELECT name FROM supplier ORDER BY row ASC";
        rs = c.getQuery(query);
        try {
            while (rs.next()) {
                String supplierName = rs.getString("name");
                supplierList.add(supplierName);
            }
        } catch (SQLException ex) {
            Logger.getLogger(SupplierManagementSQL.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
