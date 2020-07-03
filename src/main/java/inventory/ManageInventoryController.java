/*
 * Copyright © 02.10.2015 by O.I.Mudannayake. All Rights Reserved.
 */
package inventory;

import ui.support.Frame;
import controller.Controller;
import controller.ControllerFactory;
import controller.Interface;
import database.sql.SQLStatement;
import database.sql.SQLFactory;
import database.sql.type.InventorySQL;
import entity.item.type.InventoryItem;
import exception.ValueNotSelectedException;
import java.awt.event.ActionEvent;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.event.InternalFrameAdapter;
import javax.swing.event.InternalFrameEvent;
import javax.swing.table.DefaultTableModel;
import ui.support.Info;

/**
 *
 * @author Ivantha
 */
public class ManageInventoryController implements Controller {

    private final ManageInventory view = new ManageInventory();
    private final InventorySQL inventorySQL = (InventorySQL) SQLFactory.getSQLStatement(SQLStatement.INVENTORY);
    private final DefaultTableModel dtm;

    public ManageInventoryController() {
        dtm = (DefaultTableModel) view.inventoryTable.getModel();

        //Update view
        view.updateViewInternalFrameListener(new InternalFrameAdapter() {
            @Override
            public void internalFrameActivated(InternalFrameEvent e) {
                ManageInventoryController.this.updateView();
            }
        });

        //Edit button
        view.addEditButtonActionListener((ActionEvent e) -> {
            EditInventoryItemController controller = (EditInventoryItemController) ControllerFactory.getController(Interface.EDIT_INVENTORY_ITEM);
            try {
                controller.showView(ManageInventoryController.this.getItem());
            } catch (ValueNotSelectedException ex) {
                Info.error("Incorrect selection", "Please select an item to edit");
                Logger.getLogger(ManageInventoryController.class.getName()).log(Level.SEVERE, null, ex);
            }
        });

        //Remove button
        view.addRemoveButtonActionListener((ActionEvent e) -> {
            Info.error("Invalid function", "This feature is not yet implemented");
        });
    }

    @Override
    public void showView() {
        Frame.showInternalFrame(view);
    }

    @Override
    public void updateView() {
        dtm.setRowCount(0);
        inventorySQL.showItemsInList(dtm);
    }

    @Override
    public void clearView() {
    }

    public InventoryItem getItem() throws ValueNotSelectedException {
        if (view.inventoryTable.getSelectedRow() != -1) {
            String itemNo = (String) dtm.getValueAt(view.inventoryTable.getSelectedRow(), 0);
            String name = (String) dtm.getValueAt(view.inventoryTable.getSelectedRow(), 1);
            int qty = Integer.parseInt((String) dtm.getValueAt(view.inventoryTable.getSelectedRow(), 2));
            double unitPrice = Double.parseDouble((String) dtm.getValueAt(view.inventoryTable.getSelectedRow(), 3));

            return new InventoryItem(itemNo, name, qty, unitPrice);
        } else {
            throw new ValueNotSelectedException();
        }
    }
}
