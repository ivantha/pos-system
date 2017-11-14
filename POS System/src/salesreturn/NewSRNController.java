/*
 * Copyright © 02.10.2015 by O.I.Mudannayake. All Rights Reserved.
 */
package salesreturn;

import database.sql.type.PaymentSQL;
import database.sql.type.SalesReturnSQL;
import java.awt.event.ActionEvent;
import java.util.ArrayList;
import javax.swing.table.DefaultTableModel;
import controller.Controller;
import cache.EmployeeCache;
import entity.payment.Cash;
import entity.payment.Cheque;
import entity.payment.PaymentMethod;
import entity.payment.type.SRNPayment;
import main.support.Input;
import main.support.DateAndTime;
import ui.support.Frame;
import ui.support.Info;
import controller.ControllerFactory;
import controller.Interface;
import database.sql.SQLStatement;
import database.sql.SQLFactory;
import entity.item.type.SRNItem;
import entity.note.type.SRN;
import javax.swing.event.InternalFrameAdapter;
import javax.swing.event.InternalFrameEvent;
import report.ReportFactory;
import report.ReportForm;
import report.type.SalesReturnReport;
import database.sql.type.InventorySQL;
import exception.EmptyStringException;
import exception.InvalidNumberException;
import java.util.logging.Level;
import java.util.logging.Logger;
import ui.ColourPalatte;

/**
 *
 * @author Ivantha
 */
public class NewSRNController implements Controller {

    private final NewSRN view = new NewSRN();
    private final SalesReturnSQL salesReturnSQL = (SalesReturnSQL) SQLFactory.getSQLStatement(SQLStatement.SALES_RETURN);
    private final PaymentSQL paymentSQL = (PaymentSQL) SQLFactory.getSQLStatement(SQLStatement.PAYMENT);
    private final InventorySQL inventorySQL = (InventorySQL) SQLFactory.getSQLStatement(SQLStatement.INVENTORY);
    DefaultTableModel dtm;
    private SRNItemListController srnItemListController = (SRNItemListController) ControllerFactory.getController(Interface.SRN_ITEM_LIST);
    final ArrayList<String> addedItem = new ArrayList<>();
    final ArrayList<String> invoiceList = new ArrayList<>();
    private String srnNo;
    private String invoiceNo;
    private double refundPayment = 0.0;

    public NewSRNController() {
        dtm = (DefaultTableModel) view.itemListTable.getModel();

        //Update view
        view.updateViewInternalFrameListener(new InternalFrameAdapter() {
            @Override
            public void internalFrameActivated(InternalFrameEvent e) {
                NewSRNController.this.updateView();
            }
        });

        //Add button
        view.addAddButtonActionListener((ActionEvent e) -> {
            invoiceNo = view.invoiceNoTextField.getText();
            if (invoiceList.contains(invoiceNo)) {
                srnItemListController.dtm.setRowCount(0);
                salesReturnSQL.getInvoiceDetail(invoiceNo, srnItemListController.dtm);
                srnItemListController.showView(NewSRNController.this);
            } else {
                Info.error("Incorrect input", "Please enter a valid invoice number");
            }
        });

        //Remove button
        view.addRemoveButtonActionListener((ActionEvent e) -> {
            String currentItemName = (String) view.itemListTable.getModel().getValueAt(view.itemListTable.getSelectedRow(), 1);
            addedItem.remove(currentItemName);
            dtm.removeRow(view.itemListTable.getSelectedRow());
        });

        //OK button
        view.addOKButtonActionListener((ActionEvent e) -> {
            try {
                //Check items
                for (int i = 0; i < dtm.getRowCount(); i++) {
                    String itemNo = dtm.getValueAt(i, 0).toString();
                    int qty = (int) Input.checkIfValidNumber(dtm.getValueAt(i, 2).toString(), "Please enter a correct quantity for " + itemNo);
                    double unitPrice = Input.checkIfValidNumber(dtm.getValueAt(i, 3).toString(), "Please enter a correct price for " + itemNo);
                }
                NewSRNController.this.calculateRefundPayment();
                String description = view.descriptionTextArea.getText();

                //New payment
                Double refundPayment = Input.checkIfValidNumber(view.refundPaymentTextField.getText(), "Please enter a correct refund payment");

                SRNPayment payment;
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
                    paymentMethod = new Cheque(no, bank);
                }

                payment = new SRNPayment(paymentSQL.generateNewID(), refundPayment, paymentMethod);
                paymentSQL.newPayment(payment);

                //New SRN
                srnNo = salesReturnSQL.generateNewID();
                SRN srn = new SRN(srnNo, DateAndTime.getDate(), invoiceNo, description, payment, EmployeeCache.getEmployee());
                salesReturnSQL.newSRN(srn);

                //Add items
                for (int i = 0; i < dtm.getRowCount(); i++) {
                    String itemNo = dtm.getValueAt(i, 0).toString();
                    int qty = (int) Input.checkIfValidNumber(dtm.getValueAt(i, 2).toString(), "Please enter a correct quantity for " + itemNo);
                    double unitPrice = Input.checkIfValidNumber(dtm.getValueAt(i, 3).toString(), "Please enter a correct price for " + itemNo);

                    SRNItem srnItem = new SRNItem(itemNo, qty, unitPrice);
                    salesReturnSQL.newSRNItemList(srnNo, srnItem);
                    inventorySQL.incrementItemQty(itemNo, qty);
                }

                //Report
                if (view.printCheckBox.isSelected()) {
                    SalesReturnReport salesReturnReport = (SalesReturnReport) ReportFactory.getReport(ReportForm.SALES_RETURN);
                    salesReturnReport.newSRNReport(srnNo);
                }

                view.dispose();
            } catch (EmptyStringException | InvalidNumberException ex) {
                Logger.getLogger(NewSRNController.class.getName()).log(Level.SEVERE, null, ex);
            }
        });

        //Clear button
        view.addClearButtonActionListener((ActionEvent e) -> {
            NewSRNController.this.clearView();
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
    }

    @Override
    public void showView() {
        this.clearView();
        this.updateView();
        Frame.showInternalFrame(view);
    }

    @Override
    public void updateView() {
        salesReturnSQL.getInvoiceList(invoiceList);
    }

    @Override
    public void clearView() {
        view.invoiceNoTextField.setText(null);
        dtm.setRowCount(0);
        addedItem.clear();
        view.descriptionTextArea.setText(null);
        view.refundPaymentTextField.setText(null);

        view.cashRadioButton.setSelected(true);

        view.bankTextField.setEditable(false);
        view.bankTextField.setBackground(ColourPalatte.VERY_LIGHT_BLUE);
        view.noTextField.setEditable(false);
        view.noTextField.setBackground(ColourPalatte.VERY_LIGHT_BLUE);

        view.noLabel.setText("No.");
    }
    
    public void calculateRefundPayment() {
        refundPayment = 0.0;
        try {
            for (int i = 0; i < dtm.getRowCount(); i++) {
                int qty = Integer.parseInt(dtm.getValueAt(i, 2).toString());
                double unitPrice = Double.parseDouble(dtm.getValueAt(i, 3).toString());

                refundPayment += qty * unitPrice;
            }
            view.refundPaymentTextField.setText(String.valueOf(refundPayment));
        } catch (NumberFormatException ex) {
        }
    }
}
