/*
 * Copyright © 02.10.2015 by O.I.Mudannayake. All Rights Reserved.
 */
package cache;

import database.sql.SQLStatement;
import database.sql.SQLFactory;
import database.sql.type.CustomerManagementSQL;
import java.util.ArrayList;
import java.util.HashMap;

/**
 *
 * @author Ivantha
 */
public class CustomerCache {
    private static final CustomerManagementSQL customerManagementSQL = (CustomerManagementSQL) SQLFactory.getSQLStatement(SQLStatement.CUSTOMER_MANAGEMENT);
    
    private static boolean customerListChanged = true;
    private static boolean customerDetailsChanged = true;
    
    public static final ArrayList<String> customerList = new ArrayList<>();
    private static HashMap<String, String> customerIDMap;
    private static HashMap<String, String> customerTelephoneMap;
    private static HashMap<String, String> customerAddressMap;
    
    public static void setCustomerListChanged(){
        customerListChanged = true;
    }
    
    public static void setCustomerDetailsChanged(){
        customerDetailsChanged = true;
    }
    
    public static ArrayList<String> getCustomerList(){
        CustomerCache.updateCustomerList();
        return customerList;
    }
    
    public static HashMap<String, String> getCustomerIDMap(){
        return customerIDMap;
    }
    
    public static HashMap<String, String> getCustomerTelephoneMap(){
        return customerTelephoneMap;
    }
    
    public static HashMap<String, String> getCustomerAddressMap(){
        return customerAddressMap;
    }
    
    public static void updateCustomerList(){
        if (customerListChanged){
            customerList.clear();
            customerManagementSQL.getCustomers(customerList);
            
            customerListChanged = false;
        }
    }
    
    public static void updateCustomerDetail(){
        if (customerDetailsChanged){
            customerIDMap = new HashMap<>();
            customerTelephoneMap = new HashMap<>();
            customerAddressMap = new HashMap<>();
            customerManagementSQL.getCustomerDetail(customerIDMap, customerTelephoneMap, customerAddressMap);
            
            customerDetailsChanged = false;
        }
    }
}
