/*
 * Copyright © 02.10.2015 by O.I.Mudannayake. All Rights Reserved.
 */
package cache;

import database.sql.SQLStatement;
import database.sql.SQLFactory;
import database.sql.type.EmployeeManagementSQL;
import java.util.ArrayList;
import java.util.HashMap;
import entity.Employee;

/**
 *
 * @author Ivantha
 */
public class EmployeeCache {
    private static final EmployeeManagementSQL employeeManagementSQL = (EmployeeManagementSQL) SQLFactory.getSQLStatement(SQLStatement.EMPLOYEE_MANAGEMENT);
    
    private static boolean employeeListChanged = true;
    private static boolean employeeDetailsChanged = true;
    
    private static Employee employee;
    
    private static final ArrayList<String> employeeList = new ArrayList<>();
    private static HashMap<String, String> employeeIDMap;
    private static HashMap<String, String> nationalIDMap;
    private static HashMap<String, String> employeeTelephoneMap;
    private static HashMap<String, String> employeeAddressMap;
    private static HashMap<String, Integer> employeeJobMap;

    public static void setEmployeeListChanged(){
        employeeListChanged = true;
    }
    
    public static void setEmployeeDetailsChanged(){
        employeeDetailsChanged = true;
    }
    
    public static Employee getEmployee() {
        return employee;
    }

    public static void setEmployee(Employee employee) {
        EmployeeCache.employee = employee;
    }  

    public static ArrayList<String> getEmployeeList() {
        EmployeeCache.updateEmployeeList();
        return employeeList;
    }

    public static HashMap<String, String> getEmployeeIDMap() {
        return employeeIDMap;
    }

    public static HashMap<String, String> getNationalIDMap() {
        return nationalIDMap;
    }

    public static HashMap<String, String> getEmployeeTelephoneMap() {
        return employeeTelephoneMap;
    }

    public static HashMap<String, String> getEmployeeAddressMap() {
        return employeeAddressMap;
    }

    public static HashMap<String, Integer> getEmployeeJobMap() {
        return employeeJobMap;
    }
    
    public static void updateEmployeeList(){
        if (employeeListChanged){
            employeeList.clear();
            employeeManagementSQL.getEmployeeList(employeeList);
            
            employeeListChanged = false;
        }
    }
    
    public static void updateEmployeeDetail(){
        if (employeeDetailsChanged){
            employeeIDMap = new HashMap<>();
            nationalIDMap = new HashMap<>();
            employeeTelephoneMap = new HashMap<>();
            employeeAddressMap = new HashMap<>();
            employeeJobMap = new HashMap<>();
            employeeManagementSQL.getEmployeeDetail(employeeIDMap, nationalIDMap, employeeTelephoneMap, employeeAddressMap, employeeJobMap);
            
            employeeDetailsChanged = false;
        }
    }
}
