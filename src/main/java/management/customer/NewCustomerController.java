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
import exception.InvalidPhoneNumberException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.event.InternalFrameAdapter;
import javax.swing.event.InternalFrameEvent;
import ui.support.Info;

/**
 *
 * @author Ivantha
 */
public class NewCustomerController implements Controller {

    private final NewCustomer view = new NewCustomer();
    private final CustomerManagementSQL customerManagementSQL = (CustomerManagementSQL) SQLFactory.getSQLStatement(SQLStatement.CUSTOMER_MANAGEMENT);

    public NewCustomerController() {
        //Update view
        view.updateViewInternalFrameListener(new InternalFrameAdapter() {
            @Override
            public void internalFrameActivated(InternalFrameEvent e) {
                NewCustomerController.this.updateView();
            }
        });

        //OK button
        view.addOKButtonActionListener((ActionEvent e) -> {
            try {
                String customerID = customerManagementSQL.generateNewID();
                String name = Input.checkIfEmptyString(view.nameTextField.getText(), "Please enter a valid customer name");
                String address = Input.checkIfEmptyString(view.addressTextField.getText(), "Please enter a valid customer address");
                String telephone = Input.checkIfValidTelephone(view.telephoneTextField.getText(), "Please enter a valid customer telephone number in the form of xxxxxxxxxx");

                Customer customer = new Customer(customerID, name, telephone, address);
                customerManagementSQL.newCustomer(customer);

                Info.information("Customer successfully added", "Customer ID: " + customerID + "<br>Customer name: " + name + "</br>");
                view.dispose();
            } catch (EmptyStringException | InvalidPhoneNumberException ex) {
                Logger.getLogger(NewCustomerController.class.getName()).log(Level.SEVERE, null, ex);
            }
        });

        //Clear button
        view.addClearButtonActionListener((ActionEvent e) -> {
            NewCustomerController.this.clearView();
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
        view.nameTextField.setText(null);
        view.telephoneTextField.setText(null);
        view.addressTextField.setText(null);
    }
}
