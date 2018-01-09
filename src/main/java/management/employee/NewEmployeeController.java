/*
 * Copyright © 02.10.2015 by O.I.Mudannayake. All Rights Reserved.
 */
package management.employee;

import entity.Employee;
import database.sql.type.EmployeeManagementSQL;
import ui.support.Info;
import exception.JobRoleNotFoundException;
import java.awt.event.ActionEvent;
import entity.job.Job;
import entity.job.JobFactory;
import controller.Controller;
import main.support.Input;
import ui.support.Frame;
import database.sql.SQLStatement;
import database.sql.SQLFactory;
import exception.EmptyStringException;
import exception.InvalidPhoneNumberException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.event.InternalFrameAdapter;
import javax.swing.event.InternalFrameEvent;

/**
 *
 * @author Ivantha
 */
public class NewEmployeeController implements Controller {

    private final NewEmployee view = new NewEmployee();
    private final EmployeeManagementSQL employeeManagementSQL = (EmployeeManagementSQL) SQLFactory.getSQLStatement(SQLStatement.EMPLOYEE_MANAGEMENT);

    public NewEmployeeController() {
        //Update view
        view.updateViewInternalFrameListener(new InternalFrameAdapter() {
            @Override
            public void internalFrameActivated(InternalFrameEvent e) {
                NewEmployeeController.this.updateView();
            }
        });

        //OK button
        view.addOKButtonActionListener((ActionEvent e) -> {
            try {
                String employeeID = employeeManagementSQL.generateNewID();
                String nationalID = Input.checkIfEmptyString(view.nationIDTextField.getText(), "Please enter a valid employee national ID");
                String name = Input.checkIfEmptyString(view.nameTextField.getText(), "Please enter a valid employee name");
                String address = Input.checkIfEmptyString(view.addressTextField.getText(), "Please enter a valid employee address");
                String telephone = Input.checkIfValidTelephone(view.telephoneTextField.getText(), "Please enter a valid telephone number in the form of xxxxxxxxxx");
                Job job;
                try {
                    job = JobFactory.getJobRole(view.jobComboBox.getSelectedItem().toString());
                } catch (JobRoleNotFoundException ex) {
                    Info.error("Invalid Input", "Job role is invalid");
                    return;
                }
                String password = Input.checkIfEmptyString(String.valueOf(view.passwordPasswordField.getText()), "Please enter a valid password");

                Employee employee = new Employee(employeeID, nationalID, name, address, telephone, job, password);
                employeeManagementSQL.newEmployee(employee);

                Info.information("Employee successfully added", "Employee ID: " + employeeID + "<br>Employee name: " + name + "</br>");
                view.dispose();
            } catch (EmptyStringException | InvalidPhoneNumberException ex) {
                Logger.getLogger(NewEmployeeController.class.getName()).log(Level.SEVERE, null, ex);
            }

        });

        //Clear button
        view.addClearButtonActionListener((ActionEvent e) -> {
            NewEmployeeController.this.clearView();
        });
    }

    @Override
    public void showView() {
        this.clearView();
        Frame.showInternalFrame(view);
    }

    @Override
    public void updateView() {
    }

    @Override
    public void clearView() {
        view.nationIDTextField.setText(null);
        view.nameTextField.setText(null);
        view.telephoneTextField.setText(null);
        view.addressTextField.setText(null);
        view.passwordPasswordField.setText(null);
    }
}
