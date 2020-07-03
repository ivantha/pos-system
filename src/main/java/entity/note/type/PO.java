/*
 * Copyright © 02.10.2015 by O.I.Mudannayake. All Rights Reserved.
 */
package entity.note.type;

import entity.Employee;
import entity.item.type.POItem;
import java.util.ArrayList;
import entity.payment.type.POPayment;
import entity.Supplier;

/**
 *
 * @author Ivantha
 */
public class PO {
    private String poNo;
    private String date;
    private Supplier supplier;
    private ArrayList<POItem> itemList;
    private POPayment advancePayment;
    private Employee employee;

    public PO(String poNo, String date, Supplier supplier, Employee employee) {
        this.poNo = poNo;
        this.date = date;
        this.supplier = supplier;
        this.employee = employee;
    }
    
    public String getPoNo() {
        return poNo;
    }

    public void setPoNo(String poNo) {
        this.poNo = poNo;
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

    public ArrayList<POItem> getItemList() {
        return itemList;
    }

    public void setItemList(ArrayList<POItem> itemList) {
        this.itemList = itemList;
    }

    public POPayment getAdvancePayment() {
        return advancePayment;
    }

    public void setAdvancePayment(POPayment advancePayment) {
        this.advancePayment = advancePayment;
    }

    public Employee getEmployee() {
        return employee;
    }

    public void setEmployee(Employee employee) {
        this.employee = employee;
    }
}
