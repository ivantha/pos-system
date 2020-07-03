/*
 * Copyright © 02.10.2015 by O.I.Mudannayake. All Rights Reserved.
 */
package management.customer;

import controller.Controller;
import database.sql.SQLFactory;
import database.sql.SQLStatement;
import database.sql.type.CustomerManagementSQL;
import entity.Customer;
import javax.swing.event.InternalFrameAdapter;
import javax.swing.event.InternalFrameEvent;
import javax.swing.table.DefaultTableModel;
import ui.support.Frame;

/**
 *
 * @author Ivantha
 */
public class CustomerHistoryController implements Controller {

    private final CustomerHistory view = new CustomerHistory();
    private final CustomerManagementSQL customerManagementSQL = (CustomerManagementSQL) SQLFactory.getSQLStatement(SQLStatement.CUSTOMER_MANAGEMENT);
    private final DefaultTableModel dtm;

    public CustomerHistoryController() {
        dtm = (DefaultTableModel) view.customerHistoryTable.getModel();

        //Update view
        view.updateViewInternalFrameListener(new InternalFrameAdapter() {
            @Override
            public void internalFrameActivated(InternalFrameEvent e) {
                CustomerHistoryController.this.updateView();
            }
        });
    }

    @Override
    public void showView() {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    public void showView(Customer customer) {
        this.clearView();
        view.customerIDTextField.setText(customer.getCustomerID());
        view.nameTextField.setText(customer.getName());
        customerManagementSQL.showCustomerHistory(customer, dtm);

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
