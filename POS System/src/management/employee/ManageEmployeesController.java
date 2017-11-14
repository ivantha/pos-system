/*
 * Copyright © 02.10.2015 by O.I.Mudannayake. All Rights Reserved.
 */
package management.employee;

import cache.EmployeeCache;
import java.awt.event.ActionEvent;
import javax.swing.table.DefaultTableModel;
import controller.Controller;
import ui.support.Frame;
import controller.ControllerFactory;
import controller.Interface;
import database.sql.SQLFactory;
import database.sql.SQLStatement;
import database.sql.type.EmployeeManagementSQL;
import entity.Employee;
import entity.job.JobFactory;
import exception.JobRoleNotFoundException;
import exception.ValueNotSelectedException;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.event.InternalFrameAdapter;
import javax.swing.event.InternalFrameEvent;
import ui.support.Info;

/**
 *
 * @author Ivantha
 */
public class ManageEmployeesController implements Controller {

    private final ManageEmployees view = new ManageEmployees();
    private final EmployeeManagementSQL employeeManagementSQL = (EmployeeManagementSQL) SQLFactory.getSQLStatement(SQLStatement.EMPLOYEE_MANAGEMENT);
    private final DefaultTableModel dtm;

    private String employeeIDSearchPhrase = "";
    private String nationalIDSearchPhrase = "";
    private String nameSearchPhrase = "";
    private String telephoneSearchPhrase = "";
    private String addressSearchPhrase = "";

    public ManageEmployeesController() {
        dtm = (DefaultTableModel) view.employeeTable.getModel();

        //Update view
        view.updateViewInternalFrameListener(new InternalFrameAdapter() {
            @Override
            public void internalFrameActivated(InternalFrameEvent e) {
                ManageEmployeesController.this.updateView();
            }
        });

        //Clear button
        view.addClearButtonActionListener((ActionEvent ae) -> {
            ManageEmployeesController.this.clearView();
            ManageEmployeesController.this.updateView();
        });

        //Add button
        view.addNewButtonActionListener((ActionEvent e) -> {
            NewEmployeeController controller = new NewEmployeeController();
            controller.showView();
        });

        //Edit button
        view.addEditButtonActionListener((ActionEvent e) -> {
            EditEmployeeController controller = (EditEmployeeController) ControllerFactory.getController(Interface.EDIT_EMPLOYEE);
            try {
                controller.showView(ManageEmployeesController.this.getEmployee());
            } catch (ValueNotSelectedException ex) {
                Info.error("Incorrect selection", "Please select an employee to edit");
                Logger.getLogger(ManageEmployeesController.class.getName()).log(Level.SEVERE, null, ex);
            }
        });

        //Remove button
        view.addRemoveButtonActionListener((ActionEvent e) -> {
            Info.error("Invalid function", "This feature is not yet implemented");
        });

        //History button
        view.addHistoryButtonActionListener((ActionEvent ae) -> {
            EmployeeHistoryController controller = (EmployeeHistoryController) ControllerFactory.getController(Interface.EMPLOYEE_HISTORY);
            try {
                controller.showView(ManageEmployeesController.this.getEmployee());
            } catch (ValueNotSelectedException ex) {
                Info.error("Incorrect selection", "Please select an employee to view history");
                Logger.getLogger(ManageEmployeesController.class.getName()).log(Level.SEVERE, null, ex);
            }
        });

        //Search
        view.addSearchKeyListener(new KeyAdapter() {
            @Override
            public void keyReleased(KeyEvent e) {
                employeeIDSearchPhrase = view.employeeIDTextField.getText().trim();
                nationalIDSearchPhrase = view.nationalIDTextField.getText().trim();
                nameSearchPhrase = view.nameTextField.getText().trim();
                telephoneSearchPhrase = view.telephoneTextField.getText().trim();
                addressSearchPhrase = view.addressTextField.getText().trim();

                ManageEmployeesController.this.updateView();
            }
        });
        view.addJobComboBoxActionListener((ActionEvent e) -> {
            ManageEmployeesController.this.updateView();
        });
    }

    @Override
    public void showView() {
        this.clearView();
        this.updateView();
        Frame.showInternalFrame(view);
    }

    @Override
    public void updateView() {
        DefaultTableModel dtm = (DefaultTableModel) view.employeeTable.getModel();
        dtm.setRowCount(0);

        for (String employeeName : EmployeeCache.getEmployeeList()) {
            EmployeeCache.updateEmployeeDetail();
            String employeeID = EmployeeCache.getEmployeeIDMap().get(employeeName);
            String nationalID = EmployeeCache.getNationalIDMap().get(employeeName);
            String telephone = EmployeeCache.getEmployeeTelephoneMap().get(employeeName);
            String address = EmployeeCache.getEmployeeAddressMap().get(employeeName);
            String job;
            try {
                job = JobFactory.getJobRole(EmployeeCache.getEmployeeJobMap().get(employeeName)).getJobTitle();

                if (view.jobComboBox.getSelectedItem().equals("All")) {
                    if (employeeID.toLowerCase().contains(employeeIDSearchPhrase) && nationalID.toLowerCase().contains(nationalIDSearchPhrase)
                            && employeeName.toLowerCase().contains(nameSearchPhrase) && telephone.toLowerCase().contains(telephoneSearchPhrase)
                            && address.toLowerCase().contains(addressSearchPhrase)) {
                        dtm.addRow(new Object[]{employeeID, nationalID, employeeName, address, telephone, job});
                    }
                } else if (employeeID.toLowerCase().contains(employeeIDSearchPhrase) && nationalID.toLowerCase().contains(nationalIDSearchPhrase)
                        && employeeName.toLowerCase().contains(nameSearchPhrase) && telephone.toLowerCase().contains(telephoneSearchPhrase)
                        && address.toLowerCase().contains(addressSearchPhrase) && job.equals(view.jobComboBox.getSelectedItem())) {
                    dtm.addRow(new Object[]{employeeID, nationalID, employeeName, address, telephone, job});
                }
            } catch (JobRoleNotFoundException ex) {
                Logger.getLogger(ManageEmployeesController.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }

    @Override
    public void clearView() {
        view.employeeIDTextField.setText(null);
        view.nationalIDTextField.setText(null);
        view.nameTextField.setText(null);
        view.telephoneTextField.setText(null);
        view.addressTextField.setText(null);
        view.jobComboBox.setSelectedIndex(0);

        employeeIDSearchPhrase = "";
        nationalIDSearchPhrase = "";
        nameSearchPhrase = "";
        telephoneSearchPhrase = "";
        addressSearchPhrase = "";
    }

    public Employee getEmployee() throws ValueNotSelectedException {
        if (view.employeeTable.getSelectedRow() != -1) {
            return employeeManagementSQL.getEmployee(dtm.getValueAt(view.employeeTable.getSelectedRow(), 0).toString());
        } else {
            throw new ValueNotSelectedException();
        }
    }
}
