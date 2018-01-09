/*
 * Copyright © 02.10.2015 by O.I.Mudannayake. All Rights Reserved.
 */
package management.itemlist;

import cache.ItemCache;
import cache.ItemListCache;
import database.sql.type.ItemListManagementSQL;
import ui.support.Info;
import java.awt.event.ActionEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;
import javax.swing.DefaultListModel;
import javax.swing.table.DefaultTableModel;
import controller.Controller;
import main.support.Input;
import ui.support.Frame;
import database.sql.SQLStatement;
import database.sql.SQLFactory;
import exception.EmptyStringException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.event.InternalFrameAdapter;
import javax.swing.event.InternalFrameEvent;

/**
 *
 * @author Ivantha
 */
public class EditItemListController implements Controller {

    private final EditItemList view = new EditItemList();
    private final ItemListManagementSQL itemListManagementSQL = (ItemListManagementSQL) SQLFactory.getSQLStatement(SQLStatement.ITEM_LIST_MANAGEMENT);
    private final DefaultListModel dlm = new DefaultListModel();
    private final DefaultTableModel dtm;
    private final ArrayList<String> addedItem = new ArrayList<>();
    private final ArrayList<String> removedItem = new ArrayList<>();
    private String itemListID;

    public EditItemListController() {
        view.itemListJList.setModel(dlm);
        dtm = (DefaultTableModel) view.itemListTable.getModel();

        //Update view
        view.updateViewInternalFrameListener(new InternalFrameAdapter() {
            @Override
            public void internalFrameActivated(InternalFrameEvent e) {
                EditItemListController.this.updateView();
            }
        });

        //Add button
        view.addAddButtonActionListener((ActionEvent e) -> {
            String currentItemName = view.itemListJList.getSelectedValue().toString();
            if (!addedItem.contains(currentItemName)) {
                dtm.addRow(new Object[]{ItemCache.getItemNoMap().get(currentItemName), currentItemName, null});
                addedItem.add(currentItemName);
            }
        });

        //Remove button
        view.addRemoveButtonActionListener((ActionEvent e) -> {
            String itemName = dtm.getValueAt(view.itemListTable.getSelectedRow(), 0).toString();
            addedItem.remove(itemName);
            removedItem.add(itemName);
            dtm.removeRow(view.itemListTable.getSelectedRow());
        });

        //OK button
        view.addOKButtonActionListener((ActionEvent e) -> {
            try {
                String listName = Input.checkIfEmptyString(view.nameTextField.getText(), "Please enter a valid list name");
                itemListManagementSQL.updateItemListName(itemListID, listName);
                
                for (int i = 0; i < dtm.getRowCount(); i++) {
                    String itemNo = dtm.getValueAt(i, 0).toString();
                    String itemName = dtm.getValueAt(i, 1).toString();
                    int qty;
                    try {
                        qty = Integer.parseInt(dtm.getValueAt(i, 2).toString());
                    } catch (Exception ex) {
                        Info.error("Incorrect input", "Please enter a correct quantity for " + itemNo);
                        return;
                    }

                    if (addedItem.contains(itemName)) {
                        itemListManagementSQL.updateItemList(itemListID, itemNo, qty);
                    } 
                    else {
                        itemListManagementSQL.addItemToList(itemListID, itemNo, qty);
                    }
                }
                
                itemListManagementSQL.removeFromItemList(itemListID, removedItem);

                Info.information("Item list successfully updated", "Item list no: " + itemListID + "<br>Item name: " + listName + "</br>");
                view.dispose();
            } catch (EmptyStringException ex) {
                Logger.getLogger(EditItemListController.class.getName()).log(Level.SEVERE, null, ex);
            }
        });

        //Clear button
        view.addClearButtonActionListener((ActionEvent e) -> {
            EditItemListController.this.clearView();
        });

        //Double click
        view.addItemListMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                if (e.getClickCount() == 2) {
                    String currentItem = view.itemListJList.getSelectedValue().toString();
                    if (!addedItem.contains(currentItem)) {
                        dtm.addRow(new Object[]{ItemCache.getItemNoMap().get(currentItem), currentItem, null});
                    }
                }
            }
        });
    }

    @Override
    public void showView() {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    public void showView(String itemListName) {
        this.itemListID = ItemListCache.getItemListID(itemListName);
        view.itemListIDTextField.setText(itemListID);
        view.nameTextField.setText(itemListName);
        
        this.updateView();
        Frame.showInternalFrame(view);
    }

    @Override
    public void updateView() {
        dlm.clear();
        for (String itemName : ItemCache.getItemNameList()) {
            dlm.addElement(itemName);
        }

        dtm.setRowCount(0);
        itemListManagementSQL.showItemsInList(itemListID, dtm, addedItem);
    }

    @Override
    public void clearView() {
        view.nameTextField.setText(null);
        view.itemListJList.setSelectedIndex(0);
        dtm.setRowCount(0);
    }
}
