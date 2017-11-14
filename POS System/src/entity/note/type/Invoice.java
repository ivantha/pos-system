/*
 * Copyright © 02.10.2015 by O.I.Mudannayake. All Rights Reserved.
 */
package entity.note.type;

import entity.Customer;
import entity.Employee;
import entity.item.type.InvoiceItem;
import java.util.ArrayList;
import entity.payment.type.InvoicePayment;

/**
 *
 * @author Ivantha
 */
public class Invoice {
    private String invoiceNo;
    private String date;
    private ArrayList<InvoiceItem> itemList;
    private InvoicePayment payment;
    private Customer customer;
    private Employee employee;

    public Invoice(String invoiceNo, String date, InvoicePayment payment, Customer customer, Employee employee) {
        this.invoiceNo = invoiceNo;
        this.date = date;
        this.payment = payment;
        this.customer = customer;
        this.employee = employee;
    }

    public String getInvoiceNo() {
        return invoiceNo;
    }

    public void setInvoiceNo(String invoiceNo) {
        this.invoiceNo = invoiceNo;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public ArrayList<InvoiceItem> getItemList() {
        return itemList;
    }

    public void setItemList(ArrayList<InvoiceItem> itemList) {
        this.itemList = itemList;
    }

    public InvoicePayment getPayment() {
        return payment;
    }

    public void setPayment(InvoicePayment payment) {
        this.payment = payment;
    }

    public Customer getCustomer() {
        return customer;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }

    public Employee getEmployee() {
        return employee;
    }

    public void setEmployee(Employee employee) {
        this.employee = employee;
    }
    
}
