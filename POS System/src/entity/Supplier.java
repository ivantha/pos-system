/*
 * Copyright © 02.10.2015 by O.I.Mudannayake. All Rights Reserved.
 */
package entity;

/**
 *
 * @author Ivantha
 */
public class Supplier {
    private String supplierID;
    private String name;
    private String address;
    private String telephone;

    public Supplier() {
    }

    public Supplier(String supplierID, String name, String address, String telephone) {
        this.supplierID = supplierID;
        this.name = name;
        this.address = address;
        this.telephone = telephone;
    }

    public String getSupplierID() {
        return supplierID;
    }

    public void setSupplierID(String supplierID) {
        this.supplierID = supplierID;
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
    
    
}
