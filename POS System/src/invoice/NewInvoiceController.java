/*
 * Copyright © 02.10.2015 by O.I.Mudannayake. All Rights Reserved.
 */
package invoice;

import entity.Customer;
import database.sql.type.InvoiceSQL;
import database.sql.type.PaymentSQL;
import java.awt.event.ActionEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;
import javax.swing.DefaultListModel;
import javax.swing.table.DefaultTableModel;
import controller.Controller;
import cache.EmployeeCache;
import cache.CustomerCache;
import cache.ItemCache;
import entity.payment.Cash;
import entity.payment.CreditCard;
import entity.payment.PaymentMethod;
import entity.payment.type.InvoicePayment;
import main.support.Input;
import main.support.DateAndTime;
import ui.support.Frame;
import ui.support.Info;
import database.sql.SQLStatement;
import database.sql.SQLFactory;
import entity.item.type.InvoiceItem;
import javax.swing.event.InternalFrameAdapter;
import javax.swing.event.InternalFrameEvent;
import entity.note.type.Invoice;
import report.ReportFactory;
import report.ReportForm;
import report.type.InvoiceReport;
import database.sql.type.InventorySQL;
import exception.EmptyStringException;
import exception.InvalidNumberException;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.util.logging.Level;
import java.util.logging.Logger;
import management.item.ManageItemsController;
import ui.ColourPalatte;

/**
 *
 * @author Ivantha
 */
public class NewInvoiceController implements Controller {

    private final NewInvoice view = new NewInvoice();
    private final InvoiceSQL invoiceSQL = (InvoiceSQL) SQLFactory.getSQLStatement(SQLStatement.INVOICE);
    private final PaymentSQL paymentSQL = (PaymentSQL) SQLFactory.getSQLStatement(SQLStatement.PAYMENT);
    private final InventorySQL inventorySQL = (InventorySQL) SQLFactory.getSQLStatement(SQLStatement.INVENTORY);
    private final DefaultListModel dlm = new DefaultListModel();
    DefaultTableModel dtm;
    private final ArrayList<String> addedItem = new ArrayList<>();
    private String invoiceNo;
    private double netAmount;
    private String searchPhrase = "";

    public NewInvoiceController() {
        view.itemListJList.setModel(dlm);
        dtm = (DefaultTableModel) view.itemListTable.getModel();

        //Update view
        view.updateViewInternalFrameListener(new InternalFrameAdapter() {
            @Override
            public void internalFrameActivated(InternalFrameEvent e) {
                NewInvoiceController.this.updateView();
            }
        });

        //OK button
        view.addOKButtonActionListener((ActionEvent e) -> {
            try {
                //New payment
                NewInvoiceController.this.calculateNetAmount();
                double netAmount = Input.checkIfValidNumber(view.netAmountTextField.getText(), "Please enter a correct net amount");
                double amountPaid = Input.checkIfValidNumber(view.amountPaidTextField.getText(), "Please enter a correct paid amount");

                InvoicePayment payment;
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

                payment = new InvoicePayment(paymentSQL.generateNewID(), netAmount, paymentMethod, amountPaid);
                paymentSQL.newPayment(payment);

                //New invoice
                if (view.customerComboBox.getSelectedItem().equals("Regular customer")) {
                    invoiceNo = invoiceSQL.generateNewID();
                    Invoice invoice = new Invoice(invoiceNo, DateAndTime.getDate(), payment, Customer.regularCustomer, EmployeeCache.getEmployee());
                    invoiceSQL.newInvoice(invoice);
                } else {
                    Info.error("Input error", "Different customer types are not yet implemented");
                }

                //Add items
                for (int i = 0; i < dtm.getRowCount(); i++) {
                    String itemNo = dtm.getValueAt(i, 0).toString();
                    int qty = (int) Input.checkIfValidNumber(dtm.getValueAt(i, 2), "Please enter a correct quantity for " + itemNo);
                    double unitPrice = Input.checkIfValidNumber(dtm.getValueAt(i, 3), "Please enter a correct price for " + itemNo);
                    double discount = Input.checkIfValidNumber(dtm.getValueAt(i, 4).toString(), "Please enter a correct discount");

                    InvoiceItem invoiceItem = new InvoiceItem(itemNo, qty, unitPrice, discount);
                    invoiceSQL.newInvoiceItemList(invoiceNo, invoiceItem);
                    inventorySQL.decrementItemQty(itemNo, qty);
                }

                //Report
                if (view.printCheckBox.isSelected()) {
                    InvoiceReport invoiceReport = (InvoiceReport) ReportFactory.getReport(ReportForm.INVOICE);
                    invoiceReport.newInvoiceReport(invoiceNo);
                }

                view.dispose();
            } catch (EmptyStringException | InvalidNumberException ex) {
                Logger.getLogger(NewInvoiceController.class.getName()).log(Level.SEVERE, null, ex);
            }
        });

        //Clear button
        view.addClearButtonActionListener((ActionEvent e) -> {
            NewInvoiceController.this.clearView();
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

        //Double click
        view.addItemListMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                if (e.getClickCount() == 2) {
                    NewInvoiceController.this.addItem();
                }
            }
        });

        //Search
        view.addSearchTextFieldActionListener(new KeyAdapter() {
            @Override
            public void keyReleased(KeyEvent e) {
                searchPhrase = view.searchTextField.getText().trim();
                NewInvoiceController.this.updateView();
            }
        });

        //Amount paid click
        view.addAmountPaidTextFieldActionListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                NewInvoiceController.this.calculateNetAmount();

            }
        });
    }

    @Override
    public void showView() {
        this.clearView();
        Frame.showInternalFrame(view);
    }

    @Override
    public void updateView() {
        view.customerComboBox.removeAllItems();
        for (String customerName : CustomerCache.getCustomerList()) {
            view.customerComboBox.addItem(customerName);
        }

        dlm.clear();
        for (String itemName : ItemCache.getItemNameList()) {
            if (itemName.toLowerCase().contains(searchPhrase.toLowerCase())) {
                dlm.addElement(itemName);
            }
        }
    }

    @Override
    public void clearView() {
        view.customerComboBox.setSelectedItem("Regular Customer");
        dtm.setRowCount(0);
        view.netAmountTextField.setText(null);
        view.amountPaidTextField.setText(null);

        view.cashRadioButton.setSelected(true);

        view.bankTextField.setEditable(false);
        view.bankTextField.setText(null);
        view.bankTextField.setBackground(ColourPalatte.VERY_LIGHT_BLUE);
        view.noTextField.setEditable(false);
        view.noTextField.setText(null);
        view.noTextField.setBackground(ColourPalatte.VERY_LIGHT_BLUE);

        view.noLabel.setText("No.");
    }

    public void addItem() {
        String currentItem = view.itemListJList.getSelectedValue().toString();
        if (!addedItem.contains(currentItem)) {
            dtm.addRow(new Object[]{ItemCache.getItemNo(currentItem), currentItem, null, String.valueOf(ItemCache.getItemPrice(currentItem)), "0.0"});
            addedItem.add(currentItem);
        }
    }

    public void calculateNetAmount() {
        netAmount = 0.0;
        try {
            for (int i = 0; i < dtm.getRowCount(); i++) {
                int qty = Integer.parseInt(dtm.getValueAt(i, 2).toString());
                double unitPrice = Double.parseDouble(dtm.getValueAt(i, 3).toString());

                netAmount += qty * unitPrice;
            }
            view.netAmountTextField.setText(String.valueOf(netAmount));
        } catch (NumberFormatException ex) {
        }
    }
}
