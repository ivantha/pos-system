/*
 * Copyright © 02.10.2015 by O.I.Mudannayake. All Rights Reserved.
 */
package database.sql.type;

import database.sql.SQL;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.table.DefaultTableModel;
import entity.note.type.GRN;
import entity.item.type.GRNItem;

/**
 *
 * @author Ivantha
 */
public class GoodReceiveSQL extends SQL {

    public String generateNewID() {
        String preID = this.getLastValue("grn", "grn_no");
        String idX = String.format("%07d", Integer.parseInt(preID.substring(3, 10)) + 1);

        result = "gn." + idX;
        return result;
    }

    public void newGRN(GRN grn) {
        query = "INSERT INTO grn(grn_no, date, supplier, supplier_invoice_number, supplier_invoice_date, po_no, employee, payment, description) VALUES ("
                + "'" + grn.getGrnNo() + "',"
                + "'" + grn.getDate() + "',"
                + "'" + grn.getSupplier().getSupplierID() + "',"
                + "'" + grn.getSupplierInvoiceNo() + "',"
                + "'" + grn.getSupplierInvoiceDate() + "',"
                + "'" + grn.getPoNo() + "',"
                + "'" + grn.getEmployee().getEmployeeID() + "',"
                + "'" + grn.getPayment().getId() + "',"
                + "'" + grn.getDescription() + "')";

        c.setQuery(query);
    }

    public void newGRNItemList(String grnNo, GRNItem grnItem) {
        query = "INSERT INTO grn_item_list(grn_no, item_no, qty, unit_price, discount) VALUES ("
                + "'" + grnNo + "',"
                + "'" + grnItem.getItemNo() + "',"
                + "'" + grnItem.getQty() + "',"
                + "'" + grnItem.getUnitPrice() + "',"
                + "'" + grnItem.getDiscount() + "')";
        c.setQuery(query);
    }

    public String getPODetail(String poNo, DefaultTableModel dtm, ArrayList<String> addedItem) {
        query = "SELECT item.item_no, item.name, po_item_list.qty, po_item_list.unit_price FROM item, po_item_list WHERE item.item_no = po_item_list.item_no AND po_item_list.po_no = '" + poNo + "'";
        rs = c.getQuery(query);
        try {
            while (rs.next()) {
                String itemNo = rs.getString("item_no");
                String itemName = rs.getString("name");
                String itemQty = rs.getString("qty");
                String unitPrice = rs.getString("unit_price");

                dtm.addRow(new Object[]{itemNo, itemName, itemQty, unitPrice, 0.0});
                addedItem.add(itemName);
            }
        } catch (SQLException ex) {
            Logger.getLogger(ItemManagementSQL.class.getName()).log(Level.SEVERE, null, ex);
        }

        query = "SELECT supplier.name FROM po, supplier WHERE po.supplier = supplier.supplier_id AND po.po_no = '" + poNo + "'";
        rs = c.getQuery(query);
        String supplier = null;
        try {
            while (rs.next()) {
                supplier = rs.getString("name");
            }
        } catch (SQLException ex) {
            Logger.getLogger(GoodReceiveSQL.class.getName()).log(Level.SEVERE, null, ex);
        }
        return supplier;
    }

    public void showGRN(DefaultTableModel dtm) {
        query = "SELECT grn.grn_no, grn.date, supplier.name, grn.supplier_invoice_number, "
                + "grn.supplier_invoice_date, grn.po_no, employee.name, payment.amount FROM grn "
                + "LEFT JOIN supplier ON grn.supplier = supplier.supplier_id "
                + "LEFT JOIN employee ON grn.employee = employee.employee_id "
                + "LEFT JOIN payment ON grn.payment = payment.payment_id";
        rs = c.getQuery(query);

        try {
            while (rs.next()) {
                String grnNo = rs.getString("grn.grn_no");
                String date = rs.getString("grn.date");
                String supplier = rs.getString("supplier.name");
                String invoiceNo = rs.getString("grn.supplier_invoice_number");
                String invoiceDate = rs.getString("grn.supplier_invoice_date");
                String poNo = rs.getString("grn.po_no");
                String payment = rs.getString("payment.amount");
                String employee = rs.getString("employee.name");

                dtm.addRow(new Object[]{grnNo, date, supplier, invoiceNo, invoiceDate, poNo, payment, employee});
            }
        } catch (SQLException ex) {
            Logger.getLogger(EmployeeManagementSQL.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
