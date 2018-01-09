/*
 * Copyright © 02.10.2015 by O.I.Mudannayake. All Rights Reserved.
 */
package management.employee;

import controller.Controller;
import database.sql.SQLFactory;
import database.sql.SQLStatement;
import database.sql.type.EmployeeManagementSQL;
import entity.Employee;
import javax.swing.event.InternalFrameAdapter;
import javax.swing.event.InternalFrameEvent;
import javax.swing.table.DefaultTableModel;
import ui.support.Frame;

/**
 *
 * @author Ivantha
 */
public class EmployeeHistoryController implements Controller {

    private final EmployeeHistory view = new EmployeeHistory();
    private final EmployeeManagementSQL employeeManagementSQL = (EmployeeManagementSQL) SQLFactory.getSQLStatement(SQLStatement.EMPLOYEE_MANAGEMENT);
    private final DefaultTableModel dtm;

    public EmployeeHistoryController() {
        dtm = (DefaultTableModel) view.employeeHistoryTable.getModel();

        //Update view
        view.updateViewInternalFrameListener(new InternalFrameAdapter() {
            @Override
            public void internalFrameActivated(InternalFrameEvent e) {
                EmployeeHistoryController.this.updateView();
            }
        });
    }

    @Override
    public void showView() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    public void showView(Employee employee) {
        this.clearView();
        view.employeeIDTextField.setText(employee.getEmployeeID());
        view.nameTextField.setText(employee.getName());
        employeeManagementSQL.showEmployeeHistory(employee, dtm);
        
        Frame.showInternalFrame(view);
    }

    @Override
    public void updateView() {
    }

    @Override
    public void clearView() {
        dtm.setRowCount(0);
    }

}
