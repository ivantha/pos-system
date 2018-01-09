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
import entity.item.type.SRNItem;
import entity.note.type.SRN;

/**
 *
 * @author Ivantha
 */
public class SalesReturnSQL extends SQL {

    public String generateNewID() {
        String preID = this.getLastValue("srn", "srn_no");
        String idX = String.format("%07d", Integer.parseInt(preID.substring(3, 10)) + 1);

        result = "sn." + idX;
        return result;
    }

    public void newSRN(SRN srn) {
        query = "INSERT INTO srn(srn_no, date, invoice_no, description, payment, employee) VALUES ("
                + "'" + srn.getSrnNo() + "',"
                + "'" + srn.getDate() + "',"
                + "'" + srn.getInvoiceNo() + "',"
                + "'" + srn.getDescription() + "',"
                + "'" + srn.getPayment().getId() + "',"
                + "'" + srn.getEmployee().getEmployeeID() + "')";

        c.setQuery(query);
    }

    public void newSRNItemList(String prnNo, SRNItem srnItem) {
        query = "INSERT INTO srn_item_list(srn_no, item_no, unit_price, qty) VALUES ("
                + "'" + prnNo + "',"
                + "'" + srnItem.getItemNo() + "',"
                + "'" + srnItem.getUnitPrice() + "',"
                + "'" + srnItem.getQty() + "')";

        c.setQuery(query);
    }

    public void getInvoiceDetail(String invoiceNo, DefaultTableModel dtm) {
        query = "SELECT item.item_no, item.name, invoice_item_list.qty, invoice_item_list.unit_price FROM item, invoice_item_list WHERE item.item_no = invoice_item_list.item_no AND invoice_item_list.invoice_no = '" + invoiceNo + "'";
        rs = c.getQuery(query);
        try {
            while (rs.next()) {
                String itemNo = rs.getString("item_no");
                String itemName = rs.getString("name");
                int itemQty = Integer.parseInt(rs.getString("qty"));
                double unitPrice = Double.parseDouble(rs.getString("unit_price"));

                dtm.addRow(new Object[]{itemNo, itemName, itemQty, unitPrice});
            }
        } catch (SQLException ex) {
            Logger.getLogger(ItemManagementSQL.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void getInvoiceList(ArrayList<String> invoiceList) {
        query = "SELECT invoice_no FROM invoice ORDER BY row ASC";
        rs = c.getQuery(query);
        try {
            while (rs.next()) {
                String invoiceNo = rs.getString("invoice_no");
                invoiceList.add(invoiceNo);
            }
        } catch (SQLException ex) {
            Logger.getLogger(GoodReceiveSQL.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void showSRN(DefaultTableModel dtm) {
        query = "SELECT srn.srn_no, srn.date, srn.invoice_no, payment.amount, employee.name FROM srn "
                + "LEFT JOIN payment ON srn.payment = payment.payment_id "
                + "LEFT JOIN employee ON srn.employee = employee.employee_id";
        rs = c.getQuery(query);

        try {
            while (rs.next()) {
                String srnNo = rs.getString("srn.srn_no");
                String date = rs.getString("srn.date");
                String invoiceNo = rs.getString("srn.invoice_no");
                String payment = rs.getString("payment.amount");
                String employee = rs.getString("employee.name");

                dtm.addRow(new Object[]{srnNo, date, invoiceNo, payment, employee});
            }
        } catch (SQLException ex) {
            Logger.getLogger(EmployeeManagementSQL.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
