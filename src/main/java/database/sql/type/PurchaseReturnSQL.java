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
import entity.item.type.PRNItem;
import entity.note.type.PRNx;

/**
 *
 * @author Ivantha
 */
public class PurchaseReturnSQL extends SQL {

    public String generateNewID() {
        String preID = this.getLastValue("prnx", "prn_no");
        String idX = String.format("%07d", Integer.parseInt(preID.substring(3, 10)) + 1);

        result = "pn." + idX;
        return result;
    }

    public void newPRN(PRNx prn) {
        query = "INSERT INTO prnx(prn_no, date, po_no, description, payment, employee) VALUES ("
                + "'" + prn.getPrnNo() + "',"
                + "'" + prn.getDate() + "',"
                + "'" + prn.getPoNo() + "',"
                + "'" + prn.getDescription() + "',"
                + "'" + prn.getPayment().getId() + "',"
                + "'" + prn.getEmployee().getEmployeeID() + "')";

        c.setQuery(query);
    }

    public void newPRNItemList(String prnNo, PRNItem prnItem) {
        query = "INSERT INTO prn_item_list(prn_no, item_no, unit_price, qty) VALUES ("
                + "'" + prnNo + "',"
                + "'" + prnItem.getItemNo() + "',"
                + "'" + prnItem.getUnitPrice() + "',"
                + "'" + prnItem.getQty() + "')";
        c.setQuery(query);
    }

    public void getPODetail(String poNo, DefaultTableModel dtm) {
        query = "SELECT item.item_no, item.name, po_item_list.qty, po_item_list.unit_price FROM item, po_item_list WHERE item.item_no = po_item_list.item_no AND po_item_list.po_no = '" + poNo + "'";
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

    public void getPOList(ArrayList<String> poList) {
        query = "SELECT po_no FROM po ORDER BY row ASC";
        rs = c.getQuery(query);
        try {
            while (rs.next()) {
                String poNo = rs.getString("po_no");
                poList.add(poNo);
            }
        } catch (SQLException ex) {
            Logger.getLogger(GoodReceiveSQL.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void showPRN(DefaultTableModel dtm) {
        query = "SELECT prnx.prn_no, prnx.date, prnx.po_no, payment.amount, employee.name FROM prnx "
                + "LEFT JOIN payment ON prnx.payment = payment.payment_id "
                + "LEFT JOIN employee ON prnx.employee = employee.employee_id";
        rs = c.getQuery(query);

        try {
            while (rs.next()) {
                String prnNo = rs.getString("prnx.prn_no");
                String date = rs.getString("prnx.date");
                String poNo = rs.getString("prnx.po_no");
                String payment = rs.getString("payment.amount");
                String employee = rs.getString("employee.name");
                dtm.addRow(new Object[]{prnNo, date, poNo, payment, employee});
            }
        } catch (SQLException ex) {
            Logger.getLogger(EmployeeManagementSQL.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
