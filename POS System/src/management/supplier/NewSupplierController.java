/*
 * Copyright © 02.10.2015 by O.I.Mudannayake. All Rights Reserved.
 */
package management.supplier;

import database.sql.type.SupplierManagementSQL;
import java.awt.event.ActionEvent;
import controller.Controller;
import main.support.Input;
import ui.support.Frame;
import database.sql.SQLStatement;
import database.sql.SQLFactory;
import entity.Supplier;
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
public class NewSupplierController implements Controller {

    private final NewSupplier view = new NewSupplier();
    private final SupplierManagementSQL supplierManagementSQL = (SupplierManagementSQL) SQLFactory.getSQLStatement(SQLStatement.SUPPLIER_MANAGEMENT);

    public NewSupplierController() {
        //Update view
        view.updateViewInternalFrameListener(new InternalFrameAdapter() {
            @Override
            public void internalFrameActivated(InternalFrameEvent e) {
                NewSupplierController.this.updateView();
            }
        });

        //OK button
        view.addOKButtonActionListener((ActionEvent e) -> {
            try {
                String supplierID = supplierManagementSQL.generateNewID();
                String name = Input.checkIfEmptyString(view.nameTextField.getText(), "Please enter a valid supplier name");
                String address = Input.checkIfEmptyString(view.addressTextField.getText(), "Please enter a valid address");
                String telephone = Input.checkIfValidTelephone(view.telephoneTextField.getText(), "Please enter a valid telephone number in the form of xxxxxxxxxx");

                Supplier supplier = new Supplier(supplierID, name, address, telephone);
                supplierManagementSQL.newSupplier(supplier);
                
                Info.information("Supplier successfully added", "Supplier id: " + supplierID + "<br>Supplier name: " + name + "</br>");
                view.dispose();
            } catch (EmptyStringException | InvalidPhoneNumberException ex) {
                Logger.getLogger(NewSupplierController.class.getName()).log(Level.SEVERE, null, ex);
            }
        });

        //Clear button
        view.addClearButtonActionListener((ActionEvent e) -> {
            NewSupplierController.this.clearView();
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
