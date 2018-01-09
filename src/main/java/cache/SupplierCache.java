/*
 * Copyright © 02.10.2015 by O.I.Mudannayake. All Rights Reserved.
 */
package cache;

import database.sql.SQLStatement;
import database.sql.SQLFactory;
import database.sql.type.SupplierManagementSQL;
import java.util.ArrayList;
import java.util.HashMap;

/**
 *
 * @author Ivantha
 */
public class SupplierCache {
    private static final SupplierManagementSQL supplierManagementSQL =(SupplierManagementSQL) SQLFactory.getSQLStatement(SQLStatement.SUPPLIER_MANAGEMENT);
    
    private static boolean supplierListChanged = true;
    private static boolean supplierDetailsChanged = true;
    
    private static final ArrayList<String> supplierList = new ArrayList<>();
    private static HashMap<String, String> supplierIDMap;
    private static HashMap<String, String> supplierTelephoneMap;
    private static HashMap<String, String> supplierAddressMap;
    
    public static void setSupplierListChanged(){
        supplierListChanged = true;
    }
    
    public static void setSupplierDetailsChanged(){
        supplierDetailsChanged = true;
    }
    
    public static ArrayList<String> getSupplierList(){
        SupplierCache.updateSupplierList();
        return supplierList;
    }
    
    public static HashMap<String, String> getSupplierIDMap(){
        return supplierIDMap;
    }
    
    public static HashMap<String, String> getSupplierTelephoneMap(){
        return supplierTelephoneMap;
    }
    
    public static HashMap<String, String> getSupplierAddressMap(){
        return supplierAddressMap;
    }
    
    public static void updateSupplierList(){
        if (supplierListChanged){
            supplierList.clear();
            supplierManagementSQL.getSupplierList(supplierList);
            
            supplierListChanged = false;
        }
    }
    
    public static void updateSupplierDetail(){
        if (supplierDetailsChanged){
            supplierIDMap = new HashMap<>();
            supplierTelephoneMap = new HashMap<>();
            supplierAddressMap = new HashMap<>();
            supplierManagementSQL.getSupplierDetail(supplierIDMap, supplierTelephoneMap, supplierAddressMap);
            
            supplierDetailsChanged = false;
        }
    }
}
