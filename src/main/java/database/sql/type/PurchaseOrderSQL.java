/*
 * Copyright © 02.10.2015 by O.I.Mudannayake. All Rights Reserved.
 */
package database.sql.type;

import entity.note.type.PO;
import database.sql.SQL;
import entity.item.type.POItem;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.table.DefaultTableModel;
import entity.payment.Payment;

/**
 *
 * @author Ivantha
 */
public class PurchaseOrderSQL extends SQL {

    public String generateNewID() {
        String preID = this.getLastValue("po", "po_no");
        String idX = String.format("%07d", Integer.parseInt(preID.substring(3, 10)) + 1);

        result = "po." + idX;
        return result;
    }

    public void addItemToList(String poNo, POItem item) {
        query = "INSERT INTO po_item_list(po_no, item_no, qty, unit_price) VALUES ("
                + "'" + poNo + "',"
                + "'" + item.getItemNo() + "',"
                + "'" + item.getQty() + "',"
                + "'" + item.getUnitPrice() + "')";
        c.setQuery(query);
    }

    public void newPO(PO po) {
        query = "INSERT INTO po(po_no, date, supplier, employee) VALUES ("
                + "'" + po.getPoNo() + "',"
                + "'" + po.getDate() + "',"
                + "'" + po.getSupplier().getSupplierID() + "',"
                + "'" + po.getEmployee().getEmployeeID() + "')";
        c.setQuery(query);
    }

    public void newPO(PO po, Payment payment) {
        query = "INSERT INTO po(po_no, date, supplier, payment, employee) VALUES ("
                + "'" + po.getPoNo() + "',"
                + "'" + po.getDate() + "',"
                + "'" + po.getSupplier().getSupplierID() + "',"
                + "'" + payment.getId() + "',"
                + "'" + po.getEmployee().getEmployeeID() + "')";
        c.setQuery(query);
    }

    public void showPO(DefaultTableModel dtm) {
        query = "SELECT po.po_no, po.date, supplier.name, payment.amount, employee.name FROM po "
                + "LEFT JOIN supplier ON po.supplier = supplier.supplier_id "
                + "LEFT JOIN payment ON po.payment = payment.payment_id "
                + "LEFT JOIN employee ON po.employee = employee.employee_id";
        rs = c.getQuery(query);

        try {
            while (rs.next()) {
                String poNo = rs.getString("po.po_no");
                String date = rs.getString("po.date");
                String supplier = rs.getString("supplier.name");
                String payment = rs.getString("payment.amount");
                String employee = rs.getString("employee.name");

                dtm.addRow(new Object[]{poNo, date, supplier, payment, employee});
            }
        } catch (SQLException ex) {
            Logger.getLogger(EmployeeManagementSQL.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
