/*
 * Copyright © 02.10.2015 by O.I.Mudannayake. All Rights Reserved.
 */
package history;

import goodreceive.NewGRNController;
import database.sql.type.GoodReceiveSQL;
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
public class GRNHistoryController implements Controller{
    private final GRNHistory view = new GRNHistory();
    private final GoodReceiveSQL goodReceiveSQL = (GoodReceiveSQL) SQLFactory.getSQLStatement(SQLStatement.GOOD_RECEIVE);
    private String grnNoSearchPhrase = "";
    private String invoiceNoSearchPhrase = "";
    private String supplierSearchPhrase = "";
    private String employeeSearchPhrase = "";
    private String greaterThanSearchPhrase = "";
    private String lessThanSearchPhrase = "";

    public GRNHistoryController() {
        //Update view
        view.updateViewInternalFrameListener(new InternalFrameAdapter() {
            @Override
            public void internalFrameActivated(InternalFrameEvent e) {
                GRNHistoryController.this.updateView();
            }
        });
        
        //New button
        view.addNewButtonActionListener((ActionEvent e) -> {
            NewGRNController newGRNController = (NewGRNController) ControllerFactory.getController(Interface.NEW_GRN);
            newGRNController.showView();
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
                grnNoSearchPhrase = view.grnNoTextField.getText().trim();
                invoiceNoSearchPhrase = view.invoiceNoTextField.getText().trim();
                supplierSearchPhrase = view.supplierTextField.getText().trim();
                employeeSearchPhrase = view.employeeTextField.getText().trim();
                greaterThanSearchPhrase = view.greaterThanTextField.getText().trim();
                lessThanSearchPhrase = view.lessThanTextField.getText().trim();
                
                GRNHistoryController.this.updateView();
            }
        });
        view.addSearchActionlistener((ActionEvent e) -> {
            GRNHistoryController.this.updateView();
        });
    }
    
    @Override
    public void showView(){
        this.updateView();
        Frame.showInternalFrame(view);
    }
    
    @Override
    public void updateView(){
        DefaultTableModel dtm = (DefaultTableModel) view.grnTable.getModel();
        dtm.setRowCount(0);
        goodReceiveSQL.showGRN(dtm);
    }

    @Override
    public void clearView() {}
}
