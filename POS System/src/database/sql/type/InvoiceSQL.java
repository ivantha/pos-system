/*
 * Copyright © 02.10.2015 by O.I.Mudannayake. All Rights Reserved.
 */
package database.sql.type;

import database.sql.SQL;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.table.DefaultTableModel;
import entity.item.type.InvoiceItem;
import entity.note.type.Invoice;

/**
 *
 * @author Ivantha
 */
public class InvoiceSQL extends SQL {

    public String generateNewID() {
        String preID = this.getLastValue("invoice", "invoice_no");
        String idX = String.format("%07d", Integer.parseInt(preID.substring(3, 10)) + 1);

        result = "in." + idX;
        return result;
    }

    public void newInvoice(Invoice invoice) {
        query = "INSERT INTO invoice(invoice_no, date, payment, customer, employee) VALUES ("
                + "'" + invoice.getInvoiceNo() + "',"
                + "'" + invoice.getDate() + "',"
                + "'" + invoice.getPayment().getId() + "',"
                + "'" + invoice.getCustomer().getCustomerID() + "',"
                + "'" + invoice.getEmployee().getEmployeeID() + "')";

        c.setQuery(query);
    }

    public void newInvoiceItemList(String invoiceNo, InvoiceItem invoiceItem) {
        query = "INSERT INTO invoice_item_list(invoice_no, item_no, unit_price, qty, discount) VALUES ("
                + "'" + invoiceNo + "',"
                + "'" + invoiceItem.getItemNo() + "',"
                + "'" + invoiceItem.getUnitPrice() + "',"
                + "'" + invoiceItem.getQty() + "',"
                + "'" + invoiceItem.getDiscount() + "')";
        c.setQuery(query);
    }

    public void showInvoice(DefaultTableModel dtm) {
        query = "SELECT invoice.invoice_no, invoice.date, payment.amount, customer.name, employee.name FROM invoice "
                + "LEFT JOIN payment ON invoice.payment = payment.payment_id "
                + "LEFT JOIN customer ON invoice.customer = customer.customer_id "
                + "LEFT JOIN employee ON invoice.employee = employee.employee_id";
        rs = c.getQuery(query);

        try {
            while (rs.next()) {
                String invoiceNo = rs.getString("invoice.invoice_no");
                String date = rs.getString("invoice.date");
                String payment = rs.getString("payment.amount");
                String customer = rs.getString("customer.name");
                String employee = rs.getString("employee.name");
                dtm.addRow(new Object[]{invoiceNo, date, payment, customer, employee});
            }
        } catch (SQLException ex) {
            Logger.getLogger(EmployeeManagementSQL.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
