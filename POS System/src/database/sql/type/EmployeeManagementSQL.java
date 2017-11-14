/*
 * Copyright © 02.10.2015 by O.I.Mudannayake. All Rights Reserved.
 */
package database.sql.type;

import cache.EmployeeCache;
import entity.Employee;
import database.sql.SQL;
import exception.JobRoleNotFoundException;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import entity.job.Job;
import entity.job.JobFactory;
import java.util.ArrayList;
import java.util.HashMap;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Ivantha
 */
public class EmployeeManagementSQL extends SQL {

    public String generateNewID() {
        String preID = this.getLastValue("employee", "employee_id");
        String idX = String.format("%07d", Integer.parseInt(preID.substring(3, 10)) + 1);
        result = "em." + idX;
        return result;
    }

    public void newEmployee(Employee employee) {
        query = "INSERT INTO employee(employee_id, national_id, name, address, telephone, job, password) VALUES ("
                + "'" + employee.getEmployeeID() + "',"
                + "'" + employee.getNationalID() + "',"
                + "'" + employee.getName() + "',"
                + "'" + employee.getAddress() + "',"
                + "'" + employee.getTelephone() + "',"
                + "'" + employee.getJob().getJobID() + "',"
                + "'" + employee.getPassword() + "')";

        c.setQuery(query);
        EmployeeCache.setEmployeeListChanged();
        EmployeeCache.setEmployeeDetailsChanged();
    }

    public void updateEmployee(Employee employee) {
        query = "UPDATE employee SET "
                + "national_id = '" + employee.getNationalID() + "', "
                + "name = '" + employee.getName() + "', "
                + "address = '" + employee.getAddress() + "', "
                + "telephone = '" + employee.getTelephone() + "', "
                + "job = '" + employee.getJob().getJobID() + "', "
                + "password = '" + employee.getPassword() + "' "
                + "WHERE employee_id = '" + employee.getEmployeeID() + "'";

        c.setQuery(query);
        EmployeeCache.setEmployeeListChanged();
        EmployeeCache.setEmployeeDetailsChanged();
    }

    public Employee getEmployee(String employeeID) {
        query = "SELECT national_id, name, address, telephone, job, password FROM employee Where employee_id = " + "'" + employeeID + "'";
        rs = c.getQuery(query);

        try {
            while (rs.next()) {
                String nationalID = rs.getString("national_id");
                String name = rs.getString("name");
                String address = rs.getString("address");
                String telephone = rs.getString("telephone");
                int jobRoleID = Integer.parseInt(rs.getString("job"));
                String password = rs.getString("password");
                Job job;
                try {
                    job = JobFactory.getJobRole(jobRoleID);
                    return new Employee(employeeID, nationalID, name, address, telephone, job, password);
                } catch (JobRoleNotFoundException ex) {
                    Logger.getLogger(EmployeeManagementSQL.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        } catch (SQLException ex) {
            Logger.getLogger(EmployeeManagementSQL.class.getName()).log(Level.SEVERE, null, ex);
        }

        return null;
    }

    public Employee getEmployee(String employeeID, String password) {
        query = "SELECT national_id, name, address, telephone, job FROM employee Where employee_id = " + "'" + employeeID + "' AND password = '" + password + "'";
        rs = c.getQuery(query);

        try {
            while (rs.next()) {
                String nationalID = rs.getString("national_id");
                String name = rs.getString("name");
                String address = rs.getString("address");
                String telephone = rs.getString("telephone");
                int jobRoleID = Integer.parseInt(rs.getString("job"));
                Job job;
                try {
                    job = JobFactory.getJobRole(jobRoleID);
                    return new Employee(employeeID, nationalID, name, address, telephone, job, password);
                } catch (JobRoleNotFoundException ex) {
                    Logger.getLogger(EmployeeManagementSQL.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        } catch (SQLException ex) {
            Logger.getLogger(EmployeeManagementSQL.class.getName()).log(Level.SEVERE, null, ex);
        }

        return null;
    }

    public void showEmployeeHistory(Employee employee, DefaultTableModel dtm) {
        query = "SELECT po.po_no, po.date, grn.grn_no, grn.date, prnx.prn_no, prnx.date "
                + "FROM po "
                + "LEFT JOIN grn ON po.po_no = grn.po_no "
                + "LEFT JOIN prnx ON po.po_no = prnx.po_no "
                + "WHERE po.employee = " + "'" + employee.getEmployeeID() + "' "
                + "ORDER BY po.row ASC";
        rs = c.getQuery(query);

        try {
            while (rs.next()) {
                String poNo = rs.getString("po_no");
                String poDate = rs.getString("po.date");
                String grnNo = rs.getString("grn_no");
                String grnDate = rs.getString("grn.date");
                String prnNo = rs.getString("prn_no");
                String prnDate = rs.getString("prnx.date");

                dtm.addRow(new Object[]{poNo, poDate, grnNo, grnDate, prnNo, prnDate});
            }
        } catch (SQLException ex) {
            Logger.getLogger(EmployeeManagementSQL.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void getEmployeeList(ArrayList<String> employeeList) {
        query = "SELECT name FROM employee ORDER BY row ASC";
        rs = c.getQuery(query);
        try {
            while (rs.next()) {
                String employeeName = rs.getString("name");
                employeeList.add(employeeName);
            }
        } catch (SQLException ex) {
            Logger.getLogger(EmployeeManagementSQL.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void getEmployeeDetail(HashMap<String, String> employeeIDMap, HashMap<String, String> nationalIDMap, HashMap<String, String> employeeTelephoneMap,
            HashMap<String, String> employeeAddressMap, HashMap<String, Integer> employeeJobMap) {
        query = "SELECT employee_id, national_id, name, address, telephone, job FROM employee ORDER BY row ASC";
        rs = c.getQuery(query);
        try {
            while (rs.next()) {
                String employeeID = rs.getString("employee_id");
                String nationalID = rs.getString("national_id");
                String name = rs.getString("name");
                String address = rs.getString("address");
                String telephone = rs.getString("telephone");
                Integer job = Integer.parseInt(rs.getString("job"));

                employeeIDMap.put(name, employeeID);
                nationalIDMap.put(name, nationalID);
                employeeTelephoneMap.put(name, telephone);
                employeeAddressMap.put(name, address);
                employeeJobMap.put(name, job);
            }
        } catch (SQLException ex) {
            Logger.getLogger(EmployeeManagementSQL.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
