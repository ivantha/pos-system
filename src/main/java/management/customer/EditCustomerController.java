/*
 * Copyright © 02.10.2015 by O.I.Mudannayake. All Rights Reserved.
 */
package management.customer;

import entity.Customer;
import database.sql.type.CustomerManagementSQL;
import java.awt.event.ActionEvent;
import controller.Controller;
import main.support.Input;
import ui.support.Frame;
import database.sql.SQLStatement;
import database.sql.SQLFactory;
import exception.EmptyStringException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.event.InternalFrameAdapter;
import javax.swing.event.InternalFrameEvent;
import ui.support.Info;

/**
 *
 * @author Ivantha
 */
public class EditCustomerController implements Controller {

    private final EditCustomer view = new EditCustomer();
    private final CustomerManagementSQL customerManagementSQL = (CustomerManagementSQL) SQLFactory.getSQLStatement(SQLStatement.CUSTOMER_MANAGEMENT);
    private Customer customer;

    public EditCustomerController() {
        //Update view
        view.updateViewInternalFrameListener(new InternalFrameAdapter() {
            @Override
            public void internalFrameActivated(InternalFrameEvent e) {
                EditCustomerController.this.updateView();
            }
        });

        //OK button
        view.addOKButtonActionListener((ActionEvent e) -> {
            try {
                String name = Input.checkIfEmptyString(view.nameTextField.getText(), "Please enter a valid customer name");
                String address = Input.checkIfEmptyString(view.addressTextField.getText(), "Please enter a valid customer address");
                String telephone = Input.checkIfEmptyString(view.telephoneTextField.getText(), "Please enter a valid customer telephone number");

                Customer newCustomer = new Customer(customer.getCustomerID(), name, telephone, address);
                customerManagementSQL.updateCustomer(newCustomer);

                Info.information("Customer successfully updated", "Customer ID: " + customer.getCustomerID() + "<br>Customer name: " + name + "</br>");
                view.dispose();
            } catch (EmptyStringException ex) {
                Logger.getLogger(EditCustomerController.class.getName()).log(Level.SEVERE, null, ex);
            }
        });

        //Clear button
        view.addClearButtonActionListener((ActionEvent e) -> {
            EditCustomerController.this.clearView();
        });
    }

    @Override
    public void showView() {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    public void showView(Customer customer) {
        this.customer = customer;
        view.nameTextField.setText(customer.getName());
        view.addressTextField.setText(customer.getAddress());
        view.telephoneTextField.setText(customer.getTelephone());

        Frame.showInternalFrame(view);
    }

    @Override
    public void updateView() {
    }

    @Override
    public void clearView() {
        view.nameTextField.setText(null);
        view.telephoneTextField.setText(null);
        view.addressTextField.setText(null);
    }
}
