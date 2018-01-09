/*
 * Copyright © 02.10.2015 by O.I.Mudannayake. All Rights Reserved.
 */
package history;

import purchasereturn.NewPRNController;
import database.sql.type.PurchaseReturnSQL;
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
public class PRNHistoryController implements Controller{
    private final PRNHistory view = new PRNHistory();
    private final PurchaseReturnSQL purchaseReturnSQL = (PurchaseReturnSQL) SQLFactory.getSQLStatement(SQLStatement.PURCHASE_RETURN);
    private String prnNoSearchPhrase = "";
    private String poNoSearchPhrase = "";
    private String employeeSearchPhrase = "";
    private String greaterThanSearchPhrase = "";
    private String lessThanSearchPhrase = "";

    public PRNHistoryController() {
        //Update view
        view.updateViewInternalFrameListener(new InternalFrameAdapter() {
            @Override
            public void internalFrameActivated(InternalFrameEvent e) {
                PRNHistoryController.this.updateView();
            }
        });
        
        //New button
        view.addNewButtonActionListener((ActionEvent e) -> {
            NewPRNController newPRNController = (NewPRNController) ControllerFactory.getController(Interface.NEW_PRN);
            newPRNController.showView();
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
                prnNoSearchPhrase = view.prnNoTextField.getText().trim();
                poNoSearchPhrase = view.poNoTextField.getText().trim();
                employeeSearchPhrase = view.employeeTextField.getText().trim();
                greaterThanSearchPhrase = view.greaterThanTextField.getText().trim();
                lessThanSearchPhrase = view.lessThanTextField.getText().trim();
                
                PRNHistoryController.this.updateView();
            }
        });
        view.addSearchActionlistener((ActionEvent e) -> {
            PRNHistoryController.this.updateView();
        });
    }
    
    @Override
    public void showView(){
        this.updateView();
        Frame.showInternalFrame(view);
    }
    
    @Override
    public void updateView(){
        DefaultTableModel dtm = (DefaultTableModel) view.prnTable.getModel();
        dtm.setRowCount(0);
        purchaseReturnSQL.showPRN(dtm);
    }

    @Override
    public void clearView() {}
}
