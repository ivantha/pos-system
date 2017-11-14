/*
 * Copyright © 02.10.2015 by O.I.Mudannayake. All Rights Reserved.
 */
package database.sql.type;

import cache.CustomerCache;
import entity.Customer;
import database.sql.SQL;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Ivantha
 */
public class CustomerManagementSQL extends SQL {

    public String generateNewID() {
        String preID = this.getLastValue("customer", "customer_id");
        String idX = String.format("%07d", Integer.parseInt(preID.substring(3, 10)) + 1);
        result = "cu." + idX;
        return result;
    }

    public void newCustomer(Customer customer) {
        query = "INSERT INTO customer(customer_id, name, telephone, address) VALUES ("
                + "'" + customer.getCustomerID() + "',"
                + "'" + customer.getName() + "',"
                + "'" + customer.getTelephone() + "',"
                + "'" + customer.getAddress() + "')";

        c.setQuery(query);
        CustomerCache.setCustomerListChanged();
        CustomerCache.setCustomerDetailsChanged();
    }

    public void updateCustomer(Customer customer) {
        query = "UPDATE customer SET "
                + "name = '" + customer.getName() + "', "
                + "telephone = '" + customer.getTelephone() + "', "
                + "address = '" + customer.getAddress() + "' "
                + "WHERE customer_id = '" + customer.getCustomerID() + "'";

        c.setQuery(query);
        CustomerCache.setCustomerListChanged();
        CustomerCache.setCustomerDetailsChanged();
    }

    public void removeCustomer(String customerID) {
        query = "DELETE FROM customer WHERE customer_id = '" + customerID + "'";

        c.setQuery(query);
        CustomerCache.setCustomerListChanged();
        CustomerCache.setCustomerDetailsChanged();
    }

    public void getCustomers(ArrayList<String> customerList) {
        query = "SELECT name FROM customer ORDER BY row ASC";
        rs = c.getQuery(query);
        try {
            while (rs.next()) {
                String customerName = rs.getString("name");
                customerList.add(customerName);
            }
        } catch (SQLException ex) {
            Logger.getLogger(CustomerManagementSQL.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void getCustomerDetail(HashMap<String, String> customerIDMap, HashMap<String, String> customerTelephoneMap, HashMap<String, String> customerAddressMap) {
        query = "SELECT customer_id, name, address, telephone FROM customer ORDER BY row ASC";
        rs = c.getQuery(query);
        try {
            while (rs.next()) {
                String customerID = rs.getString("customer_id");
                String name = rs.getString("name");
                String address = rs.getString("address");
                String telephone = rs.getString("telephone");

                customerIDMap.put(name, customerID);
                customerTelephoneMap.put(name, telephone);
                customerAddressMap.put(name, address);
            }
        } catch (SQLException ex) {
            Logger.getLogger(CustomerManagementSQL.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void showCustomers(DefaultTableModel dtm) {
        query = "SELECT customer_id, name, telephone, address FROM customer ORDER BY row ASC";
        rs = c.getQuery(query);

        try {
            while (rs.next()) {
                String customerID = rs.getString("customer_id");
                String name = rs.getString("name");
                String telephone = rs.getString("telephone");
                String address = rs.getString("address");

                dtm.addRow(new Object[]{customerID, name, telephone, address});
            }
        } catch (SQLException ex) {
            Logger.getLogger(EmployeeManagementSQL.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void showCustomerHistory(Customer customer, DefaultTableModel dtm) {
        query = "SELECT invoice.invoice_no, invoice.date, srn.srn_no, srn.date "
                + "FROM invoice "
                + "LEFT JOIN srn ON invoice.invoice_no = srn.invoice_no "
                + "WHERE invoice.customer = " + "'" + customer.getCustomerID() + "'";
        rs = c.getQuery(query);
        try {
            while (rs.next()) {
                String invoiceNo = rs.getString("invoice.invoice_no");
                String invoiceDate = rs.getString("invoice.date");
                String srnNo = rs.getString("srn.srn_no");
                String srnDate = rs.getString("srn.date");

                dtm.addRow(new Object[]{invoiceNo, invoiceDate, srnNo, srnDate});
            }
        } catch (SQLException ex) {
            Logger.getLogger(CustomerManagementSQL.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
