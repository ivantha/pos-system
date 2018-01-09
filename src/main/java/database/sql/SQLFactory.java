/*
 * Copyright © 02.10.2015 by O.I.Mudannayake. All Rights Reserved.
 */
package database.sql;

import database.sql.SQLStatement;
import database.sql.SQL;
import database.sql.type.CustomerManagementSQL;
import database.sql.type.EmployeeManagementSQL;
import database.sql.type.GoodReceiveSQL;
import database.sql.type.InventorySQL;
import database.sql.type.InvoiceSQL;
import database.sql.type.ItemListManagementSQL;
import database.sql.type.ItemManagementSQL;
import database.sql.type.PaymentSQL;
import database.sql.type.PurchaseOrderSQL;
import database.sql.type.PurchaseReturnSQL;
import database.sql.type.SalesReturnSQL;
import database.sql.type.SupplierManagementSQL;
import java.util.HashMap;

/**
 *
 * @author Ivantha
 */
public class SQLFactory {
    private static final HashMap<SQLStatement, SQL> sqlMap = new HashMap<>();
    
    public static SQL getSQLStatement(SQLStatement s){
        SQL sqlStatement = sqlMap.get(s);
        
        if(sqlStatement == null){
            switch(s){
                case CUSTOMER_MANAGEMENT:
                    sqlStatement = new CustomerManagementSQL();
                    break;
                case EMPLOYEE_MANAGEMENT:
                    sqlStatement = new EmployeeManagementSQL();
                    break;
                case GOOD_RECEIVE:
                    sqlStatement = new GoodReceiveSQL();
                    break;
                case INVENTORY:
                    sqlStatement = new InventorySQL();
                    break;
                case INVOICE:
                    sqlStatement = new InvoiceSQL();
                    break;
                case ITEM_LIST_MANAGEMENT:
                    sqlStatement = new ItemListManagementSQL();
                    break;
                case ITEM_MANAGEMENT:
                    sqlStatement = new ItemManagementSQL();
                    break;
                case PAYMENT:
                    sqlStatement = new PaymentSQL();
                    break;
                case PURCHASE_ORDER:
                    sqlStatement = new PurchaseOrderSQL();
                    break;
                case PURCHASE_RETURN:
                    sqlStatement = new PurchaseReturnSQL();
                    break;
                case SALES_RETURN:
                    sqlStatement = new SalesReturnSQL();
                    break;
                case SUPPLIER_MANAGEMENT:
                    sqlStatement = new SupplierManagementSQL();
                    break;
                
            }
            
            sqlMap.put(s, sqlStatement);
        }
        
        return sqlStatement;
    }
}
