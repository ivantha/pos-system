/*
 * Copyright © 02.10.2015 by O.I.Mudannayake. All Rights Reserved.
 */
package entity;

/**
 *
 * @author Ivantha
 */
public class Customer {
    private String customerID;
    private String name;
    private String telephone;
    private String address;
    
    public static final Customer regularCustomer = new Customer("cu.0000001", "Regular customer");

    public Customer(String customerID, String name) {
        this.customerID = customerID;
        this.name = name;
    }

    public Customer(String customerID, String name, String telephone, String address) {
        this.customerID = customerID;
        this.name = name;
        this.telephone = telephone;
        this.address = address;
    }

    public String getCustomerID() {
        return customerID;
    }

    public void setCustomerID(String customerID) {
        this.customerID = customerID;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getTelephone() {
        return telephone;
    }

    public void setTelephone(String telephone) {
        this.telephone = telephone;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }  
}
