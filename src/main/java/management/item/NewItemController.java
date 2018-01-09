/*
 * Copyright © 02.10.2015 by O.I.Mudannayake. All Rights Reserved.
 */
package management.item;

import database.sql.type.ItemManagementSQL;
import java.awt.event.ActionEvent;
import main.support.Input;
import entity.item.Item;
import controller.Controller;
import ui.support.Frame;
import database.sql.SQLStatement;
import database.sql.SQLFactory;
import database.sql.type.InventorySQL;
import entity.item.type.InventoryItem;
import exception.EmptyStringException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.event.InternalFrameAdapter;
import javax.swing.event.InternalFrameEvent;
import ui.support.Info;

/**
 *
 * @author Ivantha
 */
public class NewItemController implements Controller{
    private final NewItem view = new NewItem();
    private final ItemManagementSQL itemManagementSQL = (ItemManagementSQL) SQLFactory.getSQLStatement(SQLStatement.ITEM_MANAGEMENT);
    private final InventorySQL inventorySQL = (InventorySQL) SQLFactory.getSQLStatement(SQLStatement.INVENTORY);

    public NewItemController() {
        //Update view
        view.updateViewInternalFrameListener(new InternalFrameAdapter() {
            @Override
            public void internalFrameActivated(InternalFrameEvent e) {
                NewItemController.this.updateView();
            }
        });
        
        //OK button
        view.addOKButtonActionListener((ActionEvent e) -> {
            try {
                String name = Input.checkIfEmptyString(view.nameTextField.getText(), "Please enter a valid item name");
                String description = view.descriptionTextArea.getText();

                Item item = new Item(itemManagementSQL.generateNewItemNo(), name, description) {};
                itemManagementSQL.newItem(item);
                    
                InventoryItem inventoryItem = new InventoryItem(item.getItemNo(), 0, 0);
                inventorySQL.newItem(inventoryItem);
                    
                Info.information("Item successfully added", "Item no: " + item.getItemNo() + "<br>Item name: " + item.getName() + "</br>");
                view.dispose();
            } catch (EmptyStringException ex) {
                Logger.getLogger(NewItemController.class.getName()).log(Level.SEVERE, null, ex);
            }
        });
        
        //Clear button
        view.addClearButtonActionListener((ActionEvent e) -> {
            NewItemController.this.clearView();
        });
    }
    
    @Override
    public void showView(){
        this.clearView();
        Frame.showInternalFrame(view);
    }

    @Override
    public void updateView() {}

    @Override
    public void clearView() {
        view.nameTextField.setText(null);
        view.descriptionTextArea.setText(null);
    }
}
