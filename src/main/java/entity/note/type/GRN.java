/*
 * Copyright © 02.10.2015 by O.I.Mudannayake. All Rights Reserved.
 */
package entity.note.type;

import entity.Employee;
import entity.item.type.GRNItem;
import java.util.ArrayList;
import entity.payment.Payment;
import entity.Supplier;

/**
 *
 * @author Ivantha
 */
public class GRN {
    private String grnNo;
    private String date;
    private Supplier supplier;
    private String supplierInvoiceNo;
    private String supplierInvoiceDate;
    private String poNo;
    private ArrayList<GRNItem> itemList;
    private String description;
    private Payment payment;
    private Employee employee;

    public GRN(String grnNo, String date, Supplier supplier, String supplierInvoiceNo, String supplierInvoiceDate, String poNo, String description, Payment payment, Employee employee) {
        this.grnNo = grnNo;
        this.date = date;
        this.supplier = supplier;
        this.supplierInvoiceNo = supplierInvoiceNo;
        this.supplierInvoiceDate = supplierInvoiceDate;
        this.poNo = poNo;
        this.description = description;
        this.payment = payment;
        this.employee = employee;
    }

    public String getGrnNo() {
        return grnNo;
    }

    public void setGrnNo(String grnNo) {
        this.grnNo = grnNo;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public Supplier getSupplier() {
        return supplier;
    }

    public void setSupplier(Supplier supplier) {
        this.supplier = supplier;
    }

    public String getSupplierInvoiceNo() {
        return supplierInvoiceNo;
    }

    public void setSupplierInvoiceNo(String supplierInvoiceNo) {
        this.supplierInvoiceNo = supplierInvoiceNo;
    }

    public String getSupplierInvoiceDate() {
        return supplierInvoiceDate;
    }

    public void setSupplierInvoiceDate(String supplierInvoiceDate) {
        this.supplierInvoiceDate = supplierInvoiceDate;
    }

    public String getPoNo() {
        return poNo;
    }

    public void setPoNo(String poNo) {
        this.poNo = poNo;
    }

    public ArrayList<GRNItem> getItemList() {
        return itemList;
    }

    public void setItemList(ArrayList<GRNItem> itemList) {
        this.itemList = itemList;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Payment getPayment() {
        return payment;
    }

    public void setPayment(Payment payment) {
        this.payment = payment;
    }

    public Employee getEmployee() {
        return employee;
    }

    public void setEmployee(Employee employee) {
        this.employee = employee;
    }  
}