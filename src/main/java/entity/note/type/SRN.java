/*
 * Copyright © 02.10.2015 by O.I.Mudannayake. All Rights Reserved.
 */
package entity.note.type;

import entity.Employee;
import entity.item.type.SRNItem;
import java.util.ArrayList;
import entity.payment.type.SRNPayment;

/**
 *
 * @author Ivantha
 */
public class SRN {
    private String srnNo;
    private String date;
    private String invoiceNo;
    private ArrayList<SRNItem> itemList;
    private String description;
    private SRNPayment payment;
    private Employee employee;

    public SRN(String srnNo, String date, String invoiceNo, String description, SRNPayment payment, Employee employee) {
        this.srnNo = srnNo;
        this.date = date;
        this.invoiceNo = invoiceNo;
        this.description = description;
        this.payment = payment;
        this.employee = employee;
    }

    public String getSrnNo() {
        return srnNo;
    }

    public void setSrnNo(String srnNo) {
        this.srnNo = srnNo;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getInvoiceNo() {
        return invoiceNo;
    }

    public void setInvoiceNo(String invoiceNo) {
        this.invoiceNo = invoiceNo;
    }

    public ArrayList<SRNItem> getItemList() {
        return itemList;
    }

    public void setItemList(ArrayList<SRNItem> itemList) {
        this.itemList = itemList;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public SRNPayment getPayment() {
        return payment;
    }

    public void setPayment(SRNPayment payment) {
        this.payment = payment;
    }

    public Employee getEmployee() {
        return employee;
    }

    public void setEmployee(Employee employee) {
        this.employee = employee;
    }
}
