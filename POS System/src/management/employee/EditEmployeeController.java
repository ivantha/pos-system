/*
 * Copyright © 02.10.2015 by O.I.Mudannayake. All Rights Reserved.
 */
package management.employee;

import entity.Employee;
import database.sql.type.EmployeeManagementSQL;
import exception.JobRoleNotFoundException;
import java.awt.event.ActionEvent;
import java.util.logging.Level;
import java.util.logging.Logger;
import entity.job.Job;
import entity.job.JobFactory;
import controller.Controller;
import main.support.Input;
import ui.support.Frame;
import database.sql.SQLStatement;
import database.sql.SQLFactory;
import exception.EmptyStringException;
import exception.InvalidPhoneNumberException;
import javax.swing.event.InternalFrameAdapter;
import javax.swing.event.InternalFrameEvent;
import ui.support.Info;

/**
 *
 * @author Ivantha
 */
public class EditEmployeeController implements Controller {
    private final EditEmployee view = new EditEmployee();
    private final EmployeeManagementSQL employeeManagementSQL = (EmployeeManagementSQL) SQLFactory.getSQLStatement(SQLStatement.EMPLOYEE_MANAGEMENT);
    private Employee employee;

    public EditEmployeeController() {
        //Update view
        view.updateViewInternalFrameListener(new InternalFrameAdapter() {
            @Override
            public void internalFrameActivated(InternalFrameEvent e) {
                EditEmployeeController.this.updateView();
            }
        });

        //OK button
        view.addOKButtonActionListener((ActionEvent e) -> {
            try {
                String nationalID = Input.checkIfEmptyString(view.nationIDTextField.getText(), "Please enter a valid employee national ID");
                String name = Input.checkIfEmptyString(view.nameTextField.getText(), "Please enter a valid employee name");
                String address = Input.checkIfEmptyString(view.addressTextField.getText(), "Please enter a valid employee address");
                String telephone = Input.checkIfValidTelephone(view.telephoneTextField.getText(), "Please enter a valid telephone number in the form of xxxxxxxxxx");
                Job job;
                try {
                    job = JobFactory.getJobRole(view.jobComboBox.getSelectedItem().toString());
                } catch (JobRoleNotFoundException ex) {
                    Logger.getLogger(EditEmployeeController.class.getName()).log(Level.SEVERE, null, ex);
                    return;
                }

                Employee newEmployee = new Employee(employee.getEmployeeID(), nationalID, name, address, telephone, job, employee.getPassword());
                employeeManagementSQL.updateEmployee(newEmployee);

                Info.information("Employee successfully updated", "Employee ID: " + employee.getEmployeeID() + "<br>Employee name: " + name + "</br>");
                view.dispose();
            } catch (EmptyStringException | InvalidPhoneNumberException ex) {
                Logger.getLogger(EditEmployeeController.class.getName()).log(Level.SEVERE, null, ex);
            }

        });

        //Clear button
        view.addClearButtonActionListener((ActionEvent e) -> {
            EditEmployeeController.this.clearView();
        });
    }

    public EditEmployeeController(Object o) {
        throw new UnsupportedOperationException("Not supported yet.");
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
        view.jobComboBox.setSelectedItem(employee.getJob().getJobTitle());

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
        view.jobComboBox.setSelectedItem(null);
    }
}
