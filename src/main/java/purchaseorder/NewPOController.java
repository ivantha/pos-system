/*
 * Copyright © 02.10.2015 by O.I.Mudannayake. All Rights Reserved.
 */
package purchaseorder;

import entity.note.type.PO;
import database.sql.type.ItemListManagementSQL;
import database.sql.type.PaymentSQL;
import database.sql.type.PurchaseOrderSQL;
import database.sql.type.SupplierManagementSQL;
import report.type.PurchaseOrderReport;
import java.awt.event.ActionEvent;
import controller.Controller;
import entity.payment.Cash;
import entity.payment.Cheque;
import entity.payment.CreditCard;
import entity.payment.DebitCard;
import entity.payment.PaymentMethod;
import entity.payment.type.POPayment;
import cache.EmployeeCache;
import cache.ItemListCache;
import cache.SupplierCache;
import main.support.Input;
import main.support.DateAndTime;
import ui.support.Frame;
import controller.ControllerFactory;
import controller.Interface;
import database.sql.SQLStatement;
import database.sql.SQLFactory;
import exception.EmptyStringException;
import exception.InvalidNumberException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.event.InternalFrameAdapter;
import javax.swing.event.InternalFrameEvent;
import report.ReportFactory;
import report.ReportForm;
import ui.ColourPalatte;

/**
 *
 * @author Ivantha
 */
public class NewPOController implements Controller {

    private final NewPO view = new NewPO();
    private final PurchaseOrderSQL purchaseOrderSQL = (PurchaseOrderSQL) SQLFactory.getSQLStatement(SQLStatement.PURCHASE_ORDER);
    private final ItemListManagementSQL itemListManagementSQL = (ItemListManagementSQL) SQLFactory.getSQLStatement(SQLStatement.ITEM_LIST_MANAGEMENT);
    private final SupplierManagementSQL supplierManagementSQL = (SupplierManagementSQL) SQLFactory.getSQLStatement(SQLStatement.SUPPLIER_MANAGEMENT);
    private final PaymentSQL paymentSQL = (PaymentSQL) SQLFactory.getSQLStatement(SQLStatement.PAYMENT);
    private PurchaseItemListController purchaseItemListController = (PurchaseItemListController) ControllerFactory.getController(Interface.PO_ITEM_LIST);

    public NewPOController() {
        //Update view
        view.updateViewInternalFrameListener(new InternalFrameAdapter() {
            @Override
            public void internalFrameActivated(InternalFrameEvent e) {

            }
        });

        //New button
        view.addNewButtonActionListener((ActionEvent e) -> {
            purchaseItemListController = (PurchaseItemListController) ControllerFactory.getController(Interface.PO_ITEM_LIST);
            purchaseItemListController.clearView();
            purchaseItemListController.showView(NewPOController.this);
        });

        //Edit button
        view.addEditButtonActionListener((ActionEvent e) -> {
            if (view.itemListNameComboBox.getSelectedItem().equals("Custom")) {
                purchaseItemListController.showView(NewPOController.this);
            } else {
                purchaseItemListController.clearView();
                String itemListID = ItemListCache.getItemListIDMap().get(view.itemListNameComboBox.getSelectedItem().toString());
                itemListManagementSQL.showItemsInList(itemListID, purchaseItemListController.dtm);
                purchaseItemListController.showView(NewPOController.this);
            }
        });

        //OK button
        view.addOKButtonActionListener((ActionEvent e) -> {
            String poNo = purchaseOrderSQL.generateNewID();
            PO po = new PO(poNo, DateAndTime.getDate(), supplierManagementSQL.getSupplier((String) view.supplierNameComboBox.getSelectedItem()), EmployeeCache.getEmployee());

            try {
                if (view.noneRadioButton.isSelected()) {
                    purchaseOrderSQL.newPO(po);
                } else {
                    Double amount = Input.checkIfValidNumber(view.amountTextField.getText(), "Please enter a correct amount");
                    PaymentMethod paymentMethod;
                    if (view.cashRadioButton.isSelected()) {
                        paymentMethod = new Cash();
                    } else if (view.chequeRadioButton.isSelected()) {
                        String bank = Input.checkIfEmptyString(view.bankTextField.getText(), "Please enter a valid bank name");
                        String no = Input.checkIfEmptyString(view.noTextField.getText(), "Please enter a valid cheque number");

                        paymentMethod = new Cheque(no, bank);
                    } else if (view.debitCardRadioButton.isSelected()) {
                        String bank = Input.checkIfEmptyString(view.bankTextField.getText(), "Please enter a valid bank name");
                        String no = Input.checkIfEmptyString(view.noTextField.getText(), "Please enter a valid debit card number");

                        paymentMethod = new DebitCard(no, bank);
                    } else {
                        String bank = Input.checkIfEmptyString(view.bankTextField.getText(), "Please enter a valid bank name");
                        String no = Input.checkIfEmptyString(view.noTextField.getText(), "Please enter a valid credit card number");

                        paymentMethod = new CreditCard(no, bank);
                    }
                    POPayment payment = new POPayment(paymentSQL.generateNewID(), amount, paymentMethod);
                    paymentSQL.newPayment(payment);
                    purchaseOrderSQL.newPO(po, payment);
                }

                //Submit the item list
                if (!view.itemListNameComboBox.getSelectedItem().equals("Custom")) {
                    purchaseItemListController.clearView();
                    String itemListID = ItemListCache.getItemListIDMap().get(view.itemListNameComboBox.getSelectedItem().toString());
                    itemListManagementSQL.showItemsInList(itemListID, purchaseItemListController.dtm);
                }
                purchaseItemListController.submitList(poNo);
                purchaseItemListController.clearView();
            } catch (InvalidNumberException | EmptyStringException ex) {
                Logger.getLogger(NewPOController.class.getName()).log(Level.SEVERE, null, ex);
                return;
            }

            //Report
            if (view.printCheckBox.isSelected()) {
                PurchaseOrderReport purchaseOrderReport = (PurchaseOrderReport) ReportFactory.getReport(ReportForm.PURCHASE_ORDER);
                purchaseOrderReport.newPOReport(poNo);
            }

            view.dispose();
        });

        //Clear button
        view.addClearButtonActionListener((ActionEvent e) -> {
            NewPOController.this.clearView();
        });

        //None radio button
        view.addNoneRadioButtonActionListener((ActionEvent e) -> {
            view.amountTextField.setEditable(false);
            view.amountTextField.setBackground(ColourPalatte.VERY_LIGHT_BLUE);
            view.bankTextField.setEditable(false);
            view.bankTextField.setBackground(ColourPalatte.VERY_LIGHT_BLUE);
            view.noTextField.setEditable(false);
            view.noTextField.setBackground(ColourPalatte.VERY_LIGHT_BLUE);

            view.noLabel.setText("No.");
        });

        //Cash radio button
        view.addCashRadioButtonActionListener((ActionEvent e) -> {
            view.amountTextField.setEditable(true);
            view.amountTextField.setBackground(ColourPalatte.PALE_WHITE);
            view.bankTextField.setEditable(false);
            view.bankTextField.setBackground(ColourPalatte.VERY_LIGHT_BLUE);
            view.noTextField.setEditable(false);
            view.noTextField.setBackground(ColourPalatte.VERY_LIGHT_BLUE);

            view.noLabel.setText("No.");
        });

        //Cheque radio button
        view.addChequeRadioButtonActionListener((ActionEvent e) -> {
            view.amountTextField.setEditable(true);
            view.amountTextField.setBackground(ColourPalatte.PALE_WHITE);
            view.bankTextField.setEditable(true);
            view.bankTextField.setBackground(ColourPalatte.PALE_WHITE);
            view.noTextField.setEditable(true);
            view.noTextField.setBackground(ColourPalatte.PALE_WHITE);

            view.noLabel.setText("Cheque no.");
        });

        //Debit card radio button
        view.addDebitCardRadioButtonActionListener((ActionEvent e) -> {
            view.amountTextField.setEditable(true);
            view.amountTextField.setBackground(ColourPalatte.PALE_WHITE);
            view.bankTextField.setEditable(true);
            view.bankTextField.setBackground(ColourPalatte.PALE_WHITE);
            view.noTextField.setEditable(true);
            view.noTextField.setBackground(ColourPalatte.PALE_WHITE);

            view.noLabel.setText("Debit card no.");
        });

        //Credit card radio button
        view.addCreditCardRadioButtonActionListener((ActionEvent e) -> {
            view.amountTextField.setEditable(true);
            view.amountTextField.setBackground(ColourPalatte.PALE_WHITE);
            view.bankTextField.setEditable(true);
            view.bankTextField.setBackground(ColourPalatte.PALE_WHITE);
            view.noTextField.setEditable(true);
            view.noTextField.setBackground(ColourPalatte.PALE_WHITE);

            view.noLabel.setText("Credit card no.");
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
        this.updateSupplierNameListComboBox();
        this.updateItemListNameListComboBox();
    }

    public void updateSupplierNameListComboBox() {
        view.supplierNameComboBox.removeAllItems();
        for (String supplier : SupplierCache.getSupplierList()) {
            view.supplierNameComboBox.addItem(supplier);
        }
    }

    public void updateItemListNameListComboBox() {
        view.itemListNameComboBox.removeAllItems();
        for (String listName : ItemListCache.getItemListNameList()) {
            view.itemListNameComboBox.addItem(listName);
        }
    }

    public void setItemListAsCustom() {
        this.updateItemListNameListComboBox();

        view.itemListNameComboBox.addItem("Custom");
        view.itemListNameComboBox.setSelectedItem("Custom");
    }

    @Override
    public void clearView() {
        this.updateView();

        view.amountTextField.setEditable(false);
        view.amountTextField.setBackground(ColourPalatte.VERY_LIGHT_BLUE);
        view.amountTextField.setText(null);
        view.bankTextField.setEditable(false);
        view.bankTextField.setBackground(ColourPalatte.VERY_LIGHT_BLUE);
        view.bankTextField.setText(null);
        view.noTextField.setEditable(false);
        view.noTextField.setBackground(ColourPalatte.VERY_LIGHT_BLUE);
        view.noTextField.setText(null);

        view.noLabel.setText("No.");

        view.noneRadioButton.setSelected(true);

        purchaseItemListController = (PurchaseItemListController) ControllerFactory.getController(Interface.PO_ITEM_LIST);
        purchaseItemListController.clearView();
    }
}
