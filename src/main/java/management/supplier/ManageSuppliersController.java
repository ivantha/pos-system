/*
 * Copyright © 02.10.2015 by O.I.Mudannayake. All Rights Reserved.
 */
package management.supplier;

import entity.Supplier;
import cache.SupplierCache;
import java.awt.event.ActionEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.table.DefaultTableModel;
import controller.Controller;
import ui.support.Frame;
import controller.ControllerFactory;
import controller.Interface;
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
public class ManageSuppliersController implements Controller {

    private final ManageSuppliers view = new ManageSuppliers();
    private final DefaultTableModel dtm;
    private String supplierIDSearchPhrase = "";
    private String nameSearchPhrase = "";
    private String telephoneSearchPhrase = "";
    private String addressSearchPhrase = "";

    public ManageSuppliersController() {
        dtm = (DefaultTableModel) view.supplierTable.getModel();

        //Update view
        view.updateViewInternalFrameListener(new InternalFrameAdapter() {
            @Override
            public void internalFrameActivated(InternalFrameEvent e) {
                ManageSuppliersController.this.updateView();
            }
        });

        //Clear button
        view.addClearButtonActionListener((ActionEvent e) -> {
            ManageSuppliersController.this.clearView();
            ManageSuppliersController.this.updateView();
        });

        //Add button
        view.addNewButtonActionListener((ActionEvent e) -> {
            NewSupplierController nsc = (NewSupplierController) ControllerFactory.getController(Interface.NEW_SUPPLIER);
            nsc.showView();
        });

        //Edit button
        view.addEditButtonActionListener((ActionEvent e) -> {
            EditSupplierController esc = (EditSupplierController) ControllerFactory.getController(Interface.EDIT_SUPPLIER);
            try {
                esc.showView(ManageSuppliersController.this.getSupplier());
            } catch (ValueNotSelectedException ex) {
                Info.error("Incorrect selection", "Please select a supplier to edit");
                Logger.getLogger(ManageSuppliersController.class.getName()).log(Level.SEVERE, null, ex);
            }
        });

        //Remove button
        view.addRemoveButtonActionListener((ActionEvent e) -> {
            Info.error("Invalid function", "This feature is not yet implemented");
        });

        //History button
        view.addHistorybuttonActionListener((ActionEvent e) -> {
            SupplierHistoryController controller = (SupplierHistoryController) ControllerFactory.getController(Interface.SUPPLIER_HISTORY);
            try {
                controller.showView(ManageSuppliersController.this.getSupplier());
            } catch (ValueNotSelectedException ex) {
                Info.error("Incorrect selection", "Please select a supplier to view history");
                Logger.getLogger(ManageSuppliersController.class.getName()).log(Level.SEVERE, null, ex);
            }
        });

        //Mouse double click
        view.addSupplierTableMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                if (e.getClickCount() == 2) {
                    EditSupplierController esc = (EditSupplierController) ControllerFactory.getController(Interface.EDIT_SUPPLIER);
                    try {
                        esc.showView(ManageSuppliersController.this.getSupplier());
                    } catch (ValueNotSelectedException ex) {
                        Info.error("Incorrect selection", "Please select a supplier to edit");
                        Logger.getLogger(ManageSuppliersController.class.getName()).log(Level.SEVERE, null, ex);
                    }
                }
            }
        });

        //Search
        view.addSearchKeyListener(new KeyAdapter() {
            @Override
            public void keyReleased(KeyEvent e) {
                supplierIDSearchPhrase = view.supplierIDTextField.getText().trim();
                nameSearchPhrase = view.nameTextField.getText().trim();
                telephoneSearchPhrase = view.telephoneTextField.getText().trim();
                addressSearchPhrase = view.addressTextField.getText().trim();

                ManageSuppliersController.this.updateView();
            }
        });
    }

    @Override
    public void showView() {
        Frame.showInternalFrame(view);
    }

    @Override
    public void updateView() {
        dtm.setRowCount(0);

        for (String supplierName : SupplierCache.getSupplierList()) {
            SupplierCache.updateSupplierDetail();
            String supplierID = SupplierCache.getSupplierIDMap().get(supplierName);
            String telephone = SupplierCache.getSupplierTelephoneMap().get(supplierName);
            String address = SupplierCache.getSupplierAddressMap().get(supplierName);

            if (supplierID.toLowerCase().contains(supplierIDSearchPhrase) && supplierName.toLowerCase().contains(nameSearchPhrase)
                    && telephone.toLowerCase().contains(telephoneSearchPhrase) && address.toLowerCase().contains(addressSearchPhrase)) {
                dtm.addRow(new Object[]{supplierID, supplierName, address, telephone});
            }
        }
    }

    @Override
    public void clearView() {
        view.supplierIDTextField.setText(null);
        view.nameTextField.setText(null);
        view.telephoneTextField.setText(null);
        view.addressTextField.setText(null);

        supplierIDSearchPhrase = "";
        nameSearchPhrase = "";
        telephoneSearchPhrase = "";
        addressSearchPhrase = "";
    }

    public Supplier getSupplier() throws ValueNotSelectedException {
        Supplier supplier = new Supplier();
        if (view.supplierTable.getSelectedRow() != -1) {
            supplier.setSupplierID((String) dtm.getValueAt(view.supplierTable.getSelectedRow(), 0));
            supplier.setName((String) dtm.getValueAt(view.supplierTable.getSelectedRow(), 1));
            supplier.setAddress((String) dtm.getValueAt(view.supplierTable.getSelectedRow(), 2));
            supplier.setTelephone((String) dtm.getValueAt(view.supplierTable.getSelectedRow(), 3));
        } else {
            throw new ValueNotSelectedException();
        }
        return supplier;
    }
}
