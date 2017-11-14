/*
 * Copyright © 02.10.2015 by O.I.Mudannayake. All Rights Reserved.
 */
package management.customer;

import cache.CustomerCache;
import entity.Customer;
import database.sql.type.CustomerManagementSQL;
import java.awt.event.ActionEvent;
import javax.swing.table.DefaultTableModel;
import controller.Controller;
import ui.support.Frame;
import database.sql.SQLStatement;
import database.sql.SQLFactory;
import javax.swing.event.InternalFrameAdapter;
import javax.swing.event.InternalFrameEvent;
import controller.ControllerFactory;
import controller.Interface;
import exception.ValueNotSelectedException;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.util.logging.Level;
import java.util.logging.Logger;
import ui.support.Info;

/**
 *
 * @author Ivantha
 */
public class ManageCustomersController implements Controller {

    private final ManageCustomers view = new ManageCustomers();
    private final CustomerManagementSQL customerManagementSQL = (CustomerManagementSQL) SQLFactory.getSQLStatement(SQLStatement.CUSTOMER_MANAGEMENT);
    private final DefaultTableModel dtm;
    private String customerIDSearchPhrase = "";
    private String nameSearchPhrase = "";
    private String telephoneSearchPhrase = "";
    private String addressSearchPhrase = "";

    public ManageCustomersController() {
        dtm = (DefaultTableModel) view.customerTable.getModel();

        //Update view
        view.updateViewInternalFrameListener(new InternalFrameAdapter() {
            @Override
            public void internalFrameActivated(InternalFrameEvent e) {
                ManageCustomersController.this.updateView();
            }
        });

        //Clear button
        view.addClearButtonActionListener((ActionEvent e) -> {
            ManageCustomersController.this.clearView();
            ManageCustomersController.this.updateView();
        });

        //Add button
        view.addNewButtonActionListener((ActionEvent e) -> {
            NewCustomerController newCustomerController = (NewCustomerController) ControllerFactory.getController(Interface.NEW_CUSTOMER);
            newCustomerController.showView();
        });

        //Edit button
        view.addEditButtonActionListener((ActionEvent e) -> {
            EditCustomerController editCustomerController = (EditCustomerController) ControllerFactory.getController(Interface.EDIT_CUSTOMER);
            try {
                editCustomerController.showView(ManageCustomersController.this.getCustomer());
            } catch (ValueNotSelectedException ex) {
                Info.error("Incorrect selection", "Please select a customer to edit");
                Logger.getLogger(ManageCustomersController.class.getName()).log(Level.SEVERE, null, ex);
            }
        });

        //Remove button
        view.addRemoveButtonActionListener((ActionEvent e) -> {
            Info.error("Invalid function", "This feature is not yet implemented");
            /*customerManagementSQL.removeCustomer(ManageCustomersController.this.getCustomer().getCustomerID());
            dtm.removeRow(view.customerTable.getSelectedRow());*/
        });

        //History button
        view.addHistoryButtonActionListener((ActionEvent ae) -> {
            CustomerHistoryController controller = (CustomerHistoryController) ControllerFactory.getController(Interface.CUSTOMER_HISTORY);
            try {
                controller.showView(ManageCustomersController.this.getCustomer());
            } catch (ValueNotSelectedException ex) {
                Info.error("Incorrect selection", "Please select a customer to view history");
                Logger.getLogger(ManageCustomersController.class.getName()).log(Level.SEVERE, null, ex);
            }
        });

        //Search
        view.addSearchKeyListener(new KeyAdapter() {
            @Override
            public void keyReleased(KeyEvent e) {
                customerIDSearchPhrase = view.customerIDTextField.getText().trim();
                nameSearchPhrase = view.nameTextField.getText().trim();
                telephoneSearchPhrase = view.telephoneTextField.getText().trim();
                addressSearchPhrase = view.addressTextField.getText().trim();

                ManageCustomersController.this.updateView();
            }
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
        dtm.setRowCount(0);

        for (String customerName : CustomerCache.getCustomerList()) {
            CustomerCache.updateCustomerDetail();
            String customerID = CustomerCache.getCustomerIDMap().get(customerName);
            String telephone = CustomerCache.getCustomerTelephoneMap().get(customerName);
            String address = CustomerCache.getCustomerAddressMap().get(customerName);

            if (customerID.toLowerCase().contains(customerIDSearchPhrase) && customerName.toLowerCase().contains(nameSearchPhrase)
                    && telephone.toLowerCase().contains(telephoneSearchPhrase) && address.toLowerCase().contains(addressSearchPhrase)) {
                dtm.addRow(new Object[]{customerID, customerName, address, telephone});
            }
        }
    }

    @Override
    public void clearView() {
        view.customerIDTextField.setText(null);
        view.nameTextField.setText(null);
        view.telephoneTextField.setText(null);
        view.addressTextField.setText(null);

        customerIDSearchPhrase = "";
        nameSearchPhrase = "";
        telephoneSearchPhrase = "";
        addressSearchPhrase = "";
    }

    public Customer getCustomer() throws ValueNotSelectedException {
        if (view.customerTable.getSelectedRow() != -1) {
            String customerID = (String) dtm.getValueAt(view.customerTable.getSelectedRow(), 0);
            String name = (String) dtm.getValueAt(view.customerTable.getSelectedRow(), 1);
            String address = (String) dtm.getValueAt(view.customerTable.getSelectedRow(), 2);
            String telephone = (String) dtm.getValueAt(view.customerTable.getSelectedRow(), 3);

            return new Customer(customerID, name, telephone, address);
        } else {
            throw new ValueNotSelectedException();
        }
    }
}
