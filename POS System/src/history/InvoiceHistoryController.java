/*
 * Copyright © 02.10.2015 by O.I.Mudannayake. All Rights Reserved.
 */
package history;

import invoice.NewInvoiceController;
import database.sql.type.InvoiceSQL;
import java.awt.event.ActionEvent;
import javax.swing.table.DefaultTableModel;
import controller.Controller;
import ui.support.Frame;
import controller.ControllerFactory;
import controller.Interface;
import database.sql.SQLStatement;
import database.sql.SQLFactory;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import javax.swing.event.InternalFrameAdapter;
import javax.swing.event.InternalFrameEvent;
import ui.support.Info;

/**
 *
 * @author Ivantha
 */
public class InvoiceHistoryController implements Controller{
    private final InvoiceHistory view = new InvoiceHistory();
    private final InvoiceSQL invoiceSQL = (InvoiceSQL) SQLFactory.getSQLStatement(SQLStatement.INVOICE);
    private String invoiceNoSearchPhrase = "";
    private String customerSearchPhrase = "";
    private String employeeSearchPhrase = "";
    private String greaterThanSearchPhrase = "";
    private String lessThanSearchPhrase = "";

    public InvoiceHistoryController() {
        //Update view
        view.updateViewInternalFrameListener(new InternalFrameAdapter() {
            @Override
            public void internalFrameActivated(InternalFrameEvent e) {
                InvoiceHistoryController.this.updateView();
            }
        });
        
        //New button
        view.addNewButtonActionListener((ActionEvent e) -> {
            NewInvoiceController newInvoiceController = (NewInvoiceController) ControllerFactory.getController(Interface.NEW_INVOICE);
            newInvoiceController.showView();
        });
        
        //Edit button
        view.addEditButtonActionListener((ActionEvent e) -> {
            Info.error("Invalid function", "This feature is not yet implemented");
        });
        
        //Remove button
        view.addRemoveButtonActionListener((ActionEvent e) -> {
            Info.error("Invalid function", "This feature is not yet implemented");
        });
        
        //Search
        view.addSearchKeyListener(new KeyAdapter() {
            @Override
            public void keyReleased(KeyEvent e) {
                invoiceNoSearchPhrase = view.invoiceNoTextField.getText().trim();
                customerSearchPhrase = view.customerTextField.getText().trim();
                employeeSearchPhrase = view.employeeTextField.getText().trim();
                greaterThanSearchPhrase = view.greaterThanTextField.getText().trim();
                lessThanSearchPhrase = view.lessThanTextField.getText().trim();
                
                InvoiceHistoryController.this.updateView();
            }
        });
        view.addSearchActionlistener((ActionEvent e) -> {
            InvoiceHistoryController.this.updateView();
        });
    }
    
    @Override
    public void showView(){
        this.updateView();
        Frame.showInternalFrame(view);
    }
    
    @Override
    public void updateView(){
        DefaultTableModel dtm = (DefaultTableModel) view.invoiceTable.getModel();
        dtm.setRowCount(0);
        invoiceSQL.showInvoice(dtm);
    }

    @Override
    public void clearView() {}
}
