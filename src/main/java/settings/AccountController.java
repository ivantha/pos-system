/*
 * Copyright © 02.10.2015 by O.I.Mudannayake. All Rights Reserved.
 */
package settings;

import cache.EmployeeCache;
import main.support.Input;
import ui.support.Frame;
import controller.Controller;
import entity.Employee;
import entity.job.Job;
import exception.JobRoleNotFoundException;
import entity.job.JobFactory;
import database.sql.SQLFactory;
import java.awt.event.ActionEvent;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.event.InternalFrameAdapter;
import javax.swing.event.InternalFrameEvent;
import management.employee.EditEmployeeController;
import database.sql.SQLStatement;
import database.sql.type.EmployeeManagementSQL;
import exception.EmptyStringException;
import exception.InvalidPhoneNumberException;
import ui.support.Info;

/**
 *
 * @author Ivantha
 */
public class AccountController implements Controller {

    private final Account view = new Account();
    private final EmployeeManagementSQL employeeManagementSQL = (EmployeeManagementSQL) SQLFactory.getSQLStatement(SQLStatement.EMPLOYEE_MANAGEMENT);
    private Employee employee;

    public AccountController() {
        //Update view
        view.updateViewInternalFrameListener(new InternalFrameAdapter() {
            @Override
            public void internalFrameActivated(InternalFrameEvent e) {
                AccountController.this.updateView();
            }
        });

        //Change button
        view.addChangeButtonActionListener((ActionEvent ae) -> {
            Info.error("Invalid function", "This feature is not yet implemented");
        });

        //OK button
        view.addOKButtonActionlistener((ActionEvent ae) -> {
            try {
                String nationalID = Input.checkIfEmptyString(view.nationIDTextField.getText(), "Please enter a valid employee national ID");
                String name = Input.checkIfEmptyString(view.nameTextField.getText(), "Please enter a valid employee name");
                String address = Input.checkIfEmptyString(view.addressTextField.getText(), "Please enter a valid employee address");
                String telephone = Input.checkIfValidTelephone(view.telephoneTextField.getText(), "Please enter a valid employee telephone number in the form of xxxxxxxxxx");
                Job job;
                try {
                    job = JobFactory.getJobRole(view.jobTextField.getText());
                } catch (JobRoleNotFoundException ex) {
                    Logger.getLogger(EditEmployeeController.class.getName()).log(Level.SEVERE, null, ex);
                    return;
                }
                String password = String.valueOf(view.passwordPasswordField.getPassword());

                Employee newEmployee = new Employee(employee.getEmployeeID(), nationalID, name, address, telephone, job, password);
                employeeManagementSQL.updateEmployee(newEmployee);
                EmployeeCache.setEmployee(newEmployee);

                Info.information("Account details successfully updated", "Employee ID: " + newEmployee.getEmployeeID() + "<br>Employee name: " + name + "</br>");
                view.dispose();
            } catch (EmptyStringException | InvalidPhoneNumberException ex) {
                Logger.getLogger(AccountController.class.getName()).log(Level.SEVERE, null, ex);
            }
        });

        //Clear button
        view.addClearButtonActionListener((ActionEvent ae) -> {
            AccountController.this.clearView();
        });
    }

    @Override
    public void showView() {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    public void showView(Employee employee) {
        this.employee = employee;

        view.employeeIDTextField.setText(employee.getEmployeeID());
        view.nationIDTextField.setText(employee.getNationalID());
        view.nameTextField.setText(employee.getName());
        view.addressTextField.setText(employee.getAddress());
        view.telephoneTextField.setText(employee.getTelephone());
        view.jobTextField.setText(employee.getJob().getJobTitle());
        view.passwordPasswordField.setText(employee.getPassword());

        Frame.showInternalFrame(view);
    }

    @Override
    public void updateView() {
    }

    @Override
    public void clearView() {
        view.nationIDTextField.setText(null);
        view.nameTextField.setText(null);
        view.addressTextField.setText(null);
        view.telephoneTextField.setText(null);
    }
}
