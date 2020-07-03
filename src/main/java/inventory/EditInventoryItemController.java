/*
 * Copyright © 02.10.2015 by O.I.Mudannayake. All Rights Reserved.
 */
package inventory;

import cache.ItemCache;
import controller.Controller;
import database.sql.SQLFactory;
import database.sql.SQLStatement;
import database.sql.type.InventorySQL;
import entity.item.type.InventoryItem;
import exception.EmptyStringException;
import exception.InvalidNumberException;
import java.awt.event.ActionEvent;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.event.InternalFrameAdapter;
import javax.swing.event.InternalFrameEvent;
import main.support.Input;
import ui.support.Frame;
import ui.support.Info;

/**
 *
 * @author Ivantha
 */
public class EditInventoryItemController implements Controller {

    private final EditInventoryItem view = new EditInventoryItem();
    private final InventorySQL inventorySQL = (InventorySQL) SQLFactory.getSQLStatement(SQLStatement.INVENTORY);
    private InventoryItem item;

    public EditInventoryItemController() {
        //Update view
        view.updateViewInternalFrameListener(new InternalFrameAdapter() {
            @Override
            public void internalFrameActivated(InternalFrameEvent e) {
                EditInventoryItemController.this.updateView();
            }
        });

        //OK button
        view.addOKButtonActionListener((ActionEvent e) -> {

            try {
                int qty = (int) Input.checkIfValidNumber(view.qtyTextField.getText(), "Please enter a valid qty");
                double unitPrice = Input.checkIfValidNumber(view.unitPriceTextField.getText(), "Please enter a valid unit price");
                
                InventoryItem newItem = new InventoryItem(item.getItemNo(), qty, unitPrice);
                inventorySQL.updateItem(newItem);

                Info.information("Item successfully updated", "Item no: " + item.getItemNo() + "<br>Item name: " + item.getName() + "</br>");
                view.dispose();
            } catch (InvalidNumberException ex) {
                Logger.getLogger(EditInventoryItemController.class.getName()).log(Level.SEVERE, null, ex);
            }

        });

        //Clear button
        view.addClearButtonActionListener((ActionEvent e) -> {
            EditInventoryItemController.this.clearView();
        });
    }

    @Override
    public void showView() {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    public void showView(InventoryItem item) {
        this.item = item;
        view.itemNoTextField.setText(item.getItemNo());
        view.nameTextField.setText(item.getName());
        view.descriptionTextArea.setText(ItemCache.getItemDescription(item.getName()));
        view.unitPriceTextField.setText(String.valueOf(item.getUnitPrice()));
        view.qtyTextField.setText(String.valueOf(item.getQty()));

        Frame.showInternalFrame(view);
    }

    @Override
    public void updateView() {
    }

    @Override
    public void clearView() {
        view.unitPriceTextField.setText(null);
        view.qtyTextField.setText(null);
    }

}
