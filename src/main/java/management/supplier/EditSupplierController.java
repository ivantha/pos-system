/*
 * Copyright © 02.10.2015 by O.I.Mudannayake. All Rights Reserved.
 */
package management.supplier;

import entity.Supplier;
import database.sql.type.SupplierManagementSQL;
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
public class EditSupplierController implements Controller {

    private final EditSupplier view = new EditSupplier();
    private final SupplierManagementSQL supplierManagementSQL = (SupplierManagementSQL) SQLFactory.getSQLStatement(SQLStatement.SUPPLIER_MANAGEMENT);

    public EditSupplierController() {
        //Update view
        view.updateViewInternalFrameListener(new InternalFrameAdapter() {
            @Override
            public void internalFrameActivated(InternalFrameEvent e) {
                EditSupplierController.this.updateView();
            }
        });

        //OK button
        view.addOKButtonActionListener((ActionEvent e) -> {
            try {
                String supplierID = Input.checkIfEmptyString(view.supplierIDTextField.getText(), "Invalid supplier ID");
                String name = Input.checkIfEmptyString(view.nameTextField.getText(), "Please enter a valid name");
                String address = Input.checkIfEmptyString(view.addressTextField.getText(), "Please enter a valid address");
                String telephone = Input.checkIfValidTelephone(view.telephoneTextField.getText(), "Please enter a valid telephone number");

                Supplier supplier = new Supplier(supplierID, name, address, telephone);
                supplierManagementSQL.updateSupplier(supplier);

                Info.information("Supplier successfully updated", "Supplier ID: " + supplierID + "<br>Supplier name: " + name + "</br>");
                view.dispose();
            } catch (EmptyStringException | InvalidPhoneNumberException ex) {
                Logger.getLogger(EditSupplierController.class.getName()).log(Level.SEVERE, null, ex);
            }
        });

        //Clear button
        view.addClearButtonActionListener((ActionEvent e) -> {
            EditSupplierController.this.clearView();
        });
    }

    @Override
    public void showView() {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    public void showView(Supplier supplier) {
        view.supplierIDTextField.setText(supplier.getSupplierID());
        view.nameTextField.setText(supplier.getName());
        view.addressTextField.setText(supplier.getAddress());
        view.telephoneTextField.setText(supplier.getTelephone());

        Frame.showInternalFrame(view);
    }

    @Override
    public void updateView() {
    }

    @Override
    public void clearView() {
        view.nameTextField.setText(null);
        view.addressTextField.setText(null);
        view.telephoneTextField.setText(null);
    }
}
