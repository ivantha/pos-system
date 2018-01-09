/*
 * Copyright © 02.10.2015 by O.I.Mudannayake. All Rights Reserved.
 */
package history;

import purchaseorder.NewPOController;
import database.sql.type.PurchaseOrderSQL;
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
public class POHistoryController implements Controller{
    private final POHistory view = new POHistory();
    private final PurchaseOrderSQL purchaseOrderSQL = (PurchaseOrderSQL) SQLFactory.getSQLStatement(SQLStatement.PURCHASE_ORDER);
    private String poNoSearchPhrase = "";
    private String supplierSearchPhrase = "";
    private String employeeSearchPhrase = "";
    private String greaterThanSearchPhrase = "";
    private String lessThanSearchPhrase = "";

    public POHistoryController() {
        //Update view
        view.updateViewInternalFrameListener(new InternalFrameAdapter() {
            @Override
            public void internalFrameActivated(InternalFrameEvent e) {
                POHistoryController.this.updateView();
            }
        });
        
        //New button
        view.addNewButtonActionListener((ActionEvent e) -> {
            NewPOController newPOController = (NewPOController) ControllerFactory.getController(Interface.NEW_PO);
            newPOController.showView();
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
                poNoSearchPhrase = view.poNoTextField.getText().trim();
                supplierSearchPhrase = view.supplierTextField.getText().trim();
                employeeSearchPhrase = view.employeeTextField.getText().trim();
                greaterThanSearchPhrase = view.greaterThanTextField.getText().trim();
                lessThanSearchPhrase = view.lessThanTextField.getText().trim();
                
                POHistoryController.this.updateView();
            }
        });
        view.addSearchActionlistener((ActionEvent e) -> {
            POHistoryController.this.updateView();
        });
    }
    
    @Override
    public void showView(){
        this.updateView();
        Frame.showInternalFrame(view);
    }
    
    @Override
    public void updateView(){
        DefaultTableModel dtm = (DefaultTableModel) view.poTable.getModel();
        dtm.setRowCount(0);
        purchaseOrderSQL.showPO(dtm);
    }

    @Override
    public void clearView() {}
}