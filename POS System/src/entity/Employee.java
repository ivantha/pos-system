/*
 * Copyright © 02.10.2015 by O.I.Mudannayake. All Rights Reserved.
 */
package entity;

import entity.job.Job;

/**
 *
 * @author Ivantha
 */
public class Employee {
    private String employeeID;
    private String nationalID;
    private String name;
    private String address;
    private String telephone;
    private Job job;
    private String password;

    public Employee(String employeeID, String nationalID, String name, String address, String telephone, Job job, String password) {
        this.employeeID = employeeID;
        this.nationalID = nationalID;
        this.name = name;
        this.address = address;
        this.telephone = telephone;
        this.job = job;
        this.password = password;
    }

    public String getEmployeeID() {
        return employeeID;
    }

    public void setEmployeeID(String employeeID) {
        this.employeeID = employeeID;
    }

    public String getNationalID() {
        return nationalID;
    }

    public void setNationalID(String nationalID) {
        this.nationalID = nationalID;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getTelephone() {
        return telephone;
    }

    public void setTelephone(String telephone) {
        this.telephone = telephone;
    }

    public Job getJob() {
        return job;
    }

    public void setJob(Job job) {
        this.job = job;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
    
}
