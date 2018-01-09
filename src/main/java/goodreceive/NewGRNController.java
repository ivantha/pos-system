/*
 * Copyright © 02.10.2015 by O.I.Mudannayake. All Rights Reserved.
 */
package goodreceive;

import entity.note.type.GRN;
import database.sql.type.GoodReceiveSQL;
import database.sql.type.PaymentSQL;
import database.sql.type.SupplierManagementSQL;
import java.awt.event.ActionEvent;
import java.util.ArrayList;
import controller.Controller;
import cache.EmployeeCache;
import entity.payment.Cash;
import entity.payment.CreditCard;
import entity.payment.type.GRNPayment;
import entity.payment.PaymentMethod;
import main.support.Input;
import main.support.DateAndTime;
import ui.support.Frame;
import controller.ControllerFactory;
import controller.Interface;
import database.sql.SQLStatement;
import database.sql.SQLFactory;
import database.sql.type.PurchaseReturnSQL;
import javax.swing.event.InternalFrameAdapter;
import javax.swing.event.InternalFrameEvent;
import report.ReportFactory;
import report.ReportForm;
import report.type.GoodReceiveReport;
import entity.Supplier;
import exception.EmptyStringException;
import exception.InvalidNumberException;
import java.util.logging.Level;
import java.util.logging.Logger;
import ui.ColourPalatte;
import ui.support.Info;

/**
 *
 * @author Ivantha
 */
public class NewGRNController implements Controller {

    private final NewGRN view = new NewGRN();
    private GRNItemListController grnItemListController = (GRNItemListController) ControllerFactory.getController(Interface.GRN_ITEM_LIST);
    private final GoodReceiveSQL goodReceiveSQL = (GoodReceiveSQL) SQLFactory.getSQLStatement(SQLStatement.GOOD_RECEIVE);
    private final PurchaseReturnSQL purchaseReturnSQL = (PurchaseReturnSQL) SQLFactory.getSQLStatement(SQLStatement.PURCHASE_RETURN);
    private final PaymentSQL paymentSQL = (PaymentSQL) SQLFactory.getSQLStatement(SQLStatement.PAYMENT);
    private final SupplierManagementSQL supplierManagementSQL = (SupplierManagementSQL) SQLFactory.getSQLStatement(SQLStatement.SUPPLIER_MANAGEMENT);
    private ArrayList<String> poList = new ArrayList<>();
    private String poNo;
    private Supplier supplier;

    public NewGRNController() {
        //Update view
        view.updateViewInternalFrameListener(new InternalFrameAdapter() {
            @Override
            public void internalFrameActivated(InternalFrameEvent e) {

            }
        });

        //New button
        view.addNewButtonActionlistener((ActionEvent e) -> {
            grnItemListController.clearView();
            grnItemListController.showView();
        });

        //Edit button
        view.addEditButtonActionListener((ActionEvent e) -> {
            grnItemListController.showView();
        });

        //OK button
        view.addOKButtonActionListener((ActionEvent e) -> {
            String invoiceDate;
            try {
                invoiceDate = DateAndTime.getDate(view.invoiceDateXDatePicker.getDate());
            } catch (NullPointerException ex) {
                Info.error("Incorrect input", "Please enter a valid invoice date");
                return;
            }

            try {
                String grnNo = goodReceiveSQL.generateNewID();
                String invoiceNo = Input.checkIfEmptyString(view.invoiceNoTextField.getText(), "Please enter a valid invoice number");
                String description = view.descriptionTextArea.getText();
                double netAmount = Input.checkIfValidNumber(view.netAmountTextField.getText(), "Please enter a correct net amount");
                double discount = Input.checkIfValidNumber(view.discountTextField.getText(), "Please enter a correct discount");

                PaymentMethod paymentMethod;
                if (view.cashRadioButton.isSelected()) {
                    paymentMethod = new Cash();
                } else {
                    String bank = Input.checkIfEmptyString(view.bankTextField.getText(), "Please enter a valid bank name");
                    String no;
                    if (view.chequeRadioButton.isSelected()) {
                        no = Input.checkIfEmptyString(view.noTextField.getText(), "Please enter a valid cheque number");
                    } else if (view.debitCardRadioButton.isSelected()) {
                        no = Input.checkIfEmptyString(view.noTextField.getText(), "Please enter a valid debit card number");
                    } else {
                        no = Input.checkIfEmptyString(view.noTextField.getText(), "Please enter a valid credit card number");
                    }
                    paymentMethod = new CreditCard(no, bank);
                }

                GRNPayment payment = new GRNPayment(discount, paymentSQL.generateNewID(), netAmount, paymentMethod);
                paymentSQL.newPayment(payment);

                GRN grn = new GRN(grnNo, DateAndTime.getDate(), supplier, invoiceNo, invoiceDate, poNo, description, payment, EmployeeCache.getEmployee());
                goodReceiveSQL.newGRN(grn);

                //Submit the item list
                grnItemListController.submitList(grnNo);

                //Report
                if (view.printCheckBox.isSelected()) {
                    GoodReceiveReport goodReceiveReport = (GoodReceiveReport) ReportFactory.getReport(ReportForm.GOOD_RECEIVE);
                    goodReceiveReport.newGRNReport(grnNo);
                }

                view.dispose();
            } catch (EmptyStringException | InvalidNumberException ex) {
                Logger.getLogger(NewGRNController.class.getName()).log(Level.SEVERE, null, ex);
            }
        });

        //Clear button
        view.addClearButtonActionListener((ActionEvent e) -> {
            NewGRNController.this.clearView();
        });

        //Cash radio button
        view.addCashRadioButtonActionListener((ActionEvent e) -> {
            view.bankTextField.setEditable(false);
            view.bankTextField.setBackground(ColourPalatte.VERY_LIGHT_BLUE);
            view.noTextField.setEditable(false);
            view.noTextField.setBackground(ColourPalatte.VERY_LIGHT_BLUE);

            view.noLabel.setText("No.");
        });

        //Cheque radio button
        view.addChequeRadioButtonActionListener((ActionEvent e) -> {
            view.bankTextField.setEditable(true);
            view.bankTextField.setBackground(ColourPalatte.PALE_WHITE);
            view.noTextField.setEditable(true);
            view.noTextField.setBackground(ColourPalatte.PALE_WHITE);

            view.noLabel.setText("Cheque no.");
        });

        //Debit card radio button
        view.addDebitCardRadioButtonActionListener((ActionEvent e) -> {
            view.bankTextField.setEditable(true);
            view.bankTextField.setBackground(ColourPalatte.PALE_WHITE);
            view.noTextField.setEditable(true);
            view.noTextField.setBackground(ColourPalatte.PALE_WHITE);

            view.noLabel.setText("Debit card no.");
        });

        //Credit card radio button
        view.addCreditCardRadioButtonActionListener((ActionEvent e) -> {
            view.bankTextField.setEditable(true);
            view.bankTextField.setBackground(ColourPalatte.PALE_WHITE);
            view.noTextField.setEditable(true);
            view.noTextField.setBackground(ColourPalatte.PALE_WHITE);

            view.noLabel.setText("Credit card no.");
        });

        //PO no. combo box
        view.addPoNoComboBoxActionListener((ActionEvent e) -> {
            poNo = (String) view.poNoComboBox.getSelectedItem();
            grnItemListController.clearView();
            String supplierName = goodReceiveSQL.getPODetail(poNo, grnItemListController.dtm, grnItemListController.addedItem);
            supplier = supplierManagementSQL.getSupplier(supplierName);
            grnItemListController.calculateTotal();
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
        view.poNoComboBox.removeAllItems();
        purchaseReturnSQL.getPOList(poList);
        for (String p : poList) {
            view.poNoComboBox.addItem(p);
        }
    }

    @Override
    public void clearView() {
        view.invoiceNoTextField.setText(null);
        view.invoiceDateXDatePicker.setDate(null);
        view.itemListIDTextField.setText(null);
        view.descriptionTextArea.setText(null);
        view.netAmountTextField.setText(null);
        view.discountTextField.setText("0.0");

        view.cashRadioButton.setSelected(true);

        view.bankTextField.setEditable(false);
        view.bankTextField.setBackground(ColourPalatte.VERY_LIGHT_BLUE);
        view.noTextField.setEditable(false);
        view.noTextField.setBackground(ColourPalatte.VERY_LIGHT_BLUE);

        view.noLabel.setText("No.");
    }

    public void setNetAmount(double netAmount) {
        view.netAmountTextField.setText(String.valueOf(netAmount));
    }
}
