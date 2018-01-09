/*
 * Copyright © 02.10.2015 by O.I.Mudannayake. All Rights Reserved.
 */
package entity.note.type;

import entity.Employee;
import entity.payment.type.PRNPayment;

/**
 *
 * @author Ivantha
 */
public class PRNx {
    private String prnNo;
    private String date;
    private String poNo;
    private String description;
    private PRNPayment payment;
    private Employee employee;

    public PRNx(String prnNo, String date, String poNo, String description, PRNPayment payment, Employee employee) {
        this.prnNo = prnNo;
        this.date = date;
        this.poNo = poNo;
        this.description = description;
        this.payment = payment;
        this.employee = employee;
    }

    public String getPrnNo() {
        return prnNo;
    }

    public void setPrnNo(String prnNo) {
        this.prnNo = prnNo;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getPoNo() {
        return poNo;
    }

    public void setPoNo(String poNo) {
        this.poNo = poNo;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public PRNPayment getPayment() {
        return payment;
    }

    public void setPayment(PRNPayment payment) {
        this.payment = payment;
    }

    public Employee getEmployee() {
        return employee;
    }

    public void setEmployee(Employee employee) {
        this.employee = employee;
    }
    
}
