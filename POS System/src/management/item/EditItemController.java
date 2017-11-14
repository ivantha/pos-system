/*
 * Copyright © 02.10.2015 by O.I.Mudannayake. All Rights Reserved.
 */
package management.item;

import main.support.Input;
import controller.Controller;
import database.sql.SQLFactory;
import database.sql.SQLStatement;
import database.sql.type.ItemManagementSQL;
import entity.item.Item;
import exception.EmptyStringException;
import java.awt.event.ActionEvent;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.event.InternalFrameAdapter;
import javax.swing.event.InternalFrameEvent;
import ui.support.Frame;
import ui.support.Info;

/**
 *
 * @author Ivantha
 */
public class EditItemController implements Controller {

    private final EditItem view = new EditItem();
    private final ItemManagementSQL itemManagementSQL = (ItemManagementSQL) SQLFactory.getSQLStatement(SQLStatement.ITEM_MANAGEMENT);

    public EditItemController() {
        //Update view
        view.updateViewInternalFrameListener(new InternalFrameAdapter() {
            @Override
            public void internalFrameActivated(InternalFrameEvent e) {
                EditItemController.this.updateView();
            }
        });

        //OK button
        view.addOKButtonActionlistener((ActionEvent ae) -> {
            try {
                String itemNo = view.itemNoTextField.getText();
                String name = Input.checkIfEmptyString(view.nameTextField.getText(), "Please enter a valid item name");
                String description = view.descriptionTextArea.getText();

                Item item = new Item(itemNo, name, description) {};
                itemManagementSQL.updateItem(item);
                
                Info.information("Item successfully updated", "Item no: " + item.getItemNo() + "<br>Item name: " + item.getName() + "</br>");
                view.dispose();
            } catch (EmptyStringException ex) {
                Logger.getLogger(EditItemController.class.getName()).log(Level.SEVERE, null, ex);
            }
        });

        //Clear button
        view.addClearButtonActionListener((ActionEvent ae) -> {
            EditItemController.this.clearView();
        });
    }

    @Override
    public void showView() {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    public void showView(Item item) {
        view.itemNoTextField.setText(item.getItemNo());
        view.nameTextField.setText(item.getName());
        view.descriptionTextArea.setText(item.getDescription());
        Frame.showInternalFrame(view);
    }

    @Override
    public void updateView() {
    }

    @Override
    public void clearView() {
        view.nameTextField.setText(null);
        view.descriptionTextArea.setText(null);
    }
}
