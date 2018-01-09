/*
 * Copyright © 02.10.2015 by O.I.Mudannayake. All Rights Reserved.
 */
package history;

import salesreturn.NewSRNController;
import database.sql.type.SalesReturnSQL;
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
public class SRNHistoryController implements Controller{
    private final SRNHistory view = new SRNHistory();
    private final SalesReturnSQL salesReturnSQL = (SalesReturnSQL) SQLFactory.getSQLStatement(SQLStatement.SALES_RETURN);
    private String srnNoSearchPhrase = "";
    private String invoiceNoSearchPhrase = "";
    private String employeeIDSearchPhrase = "";
    private String greaterThanSearchPhrase = "";
    private String lessThanSearchPhrase = "";

    public SRNHistoryController() {
        //Update view
        view.updateViewInternalFrameListener(new InternalFrameAdapter() {
            @Override
            public void internalFrameActivated(InternalFrameEvent e) {
                SRNHistoryController.this.updateView();
            }
        });
        
         //New button
        view.addNewButtonActionListener((ActionEvent e) -> {
            NewSRNController newSRNController = (NewSRNController) ControllerFactory.getController(Interface.NEW_SRN);
            newSRNController.showView();
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
                srnNoSearchPhrase = view.srnNoTextField.getText().trim();
                invoiceNoSearchPhrase = view.invoiceNoTextField.getText().trim();
                employeeIDSearchPhrase = view.employeeTextField.getText().trim();
                greaterThanSearchPhrase = view.greaterThanTextField.getText().trim();
                lessThanSearchPhrase = view.lessThanTextField.getText().trim();
                
                SRNHistoryController.this.updateView();
            }
        });
        view.addSearchActionlistener((ActionEvent e) -> {
            SRNHistoryController.this.updateView();
        });
    }
    
    @Override
    public void showView(){
        this.updateView();
        Frame.showInternalFrame(view);
    }
    
    @Override
    public void updateView(){
        DefaultTableModel dtm = (DefaultTableModel) view.srnTable.getModel();
        dtm.setRowCount(0);
        salesReturnSQL.showSRN(dtm);
    }

    @Override
    public void clearView() {}
}
