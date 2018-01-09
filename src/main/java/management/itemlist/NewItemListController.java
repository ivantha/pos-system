/*
 * Copyright © 02.10.2015 by O.I.Mudannayake. All Rights Reserved.
 */
package management.itemlist;

import database.sql.type.ItemListManagementSQL;
import ui.support.Info;
import java.awt.event.ActionEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;
import javax.swing.DefaultListModel;
import javax.swing.table.DefaultTableModel;
import controller.Controller;
import cache.ItemCache;
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
public class NewItemListController implements Controller {

    private final NewItemList view = new NewItemList();
    private final ItemListManagementSQL itemListManagementSQL = (ItemListManagementSQL) SQLFactory.getSQLStatement(SQLStatement.ITEM_LIST_MANAGEMENT);
    private final DefaultListModel dlm = new DefaultListModel();
    private DefaultTableModel dtm;
    private final ArrayList<String> addedItem = new ArrayList<>();

    public NewItemListController() {
        view.itemListJList.setModel(dlm);
        dtm = (DefaultTableModel) view.itemListTable.getModel();

        //Update view
        view.updateViewInternalFrameListener(new InternalFrameAdapter() {
            @Override
            public void internalFrameActivated(InternalFrameEvent e) {
                NewItemListController.this.updateView();
            }
        });

        //Add button
        view.addAddButtonActionListener((ActionEvent e) -> {
            String currentItemName = view.itemListJList.getSelectedValue().toString();
            if (!addedItem.contains(currentItemName)) {
                addedItem.add(currentItemName);
                dtm.addRow(new Object[]{ItemCache.getItemNoMap().get(currentItemName), currentItemName, null});
            }
        });

        //Remove button
        view.addRemoveButtonActionListener((ActionEvent e) -> {
            String currentItemName = (String) view.itemListTable.getModel().getValueAt(view.itemListTable.getSelectedRow(), 1);
            addedItem.remove(currentItemName);
            dtm.removeRow(view.itemListTable.getSelectedRow());
        });

        //OK button
        view.addOKButtonActionListener((ActionEvent e) -> {
            try {
                String itemListID = itemListManagementSQL.generateNewItemListID();
                String listName = Input.checkIfEmptyString(view.nameTextField.getText(), "Please enter a valid list name");
                itemListManagementSQL.newItemListID(itemListID, listName);

                for (int i = 0; i < dtm.getRowCount(); i++) {
                    String itemNo = dtm.getValueAt(i, 0).toString();
                    int qty;
                    try {
                        qty = Integer.parseInt(dtm.getValueAt(i, 2).toString());
                    } catch (Exception ex) {
                        Info.error("Incorrect input", "Please enter a correct quantity for " + itemNo);
                        return;
                    }
                    itemListManagementSQL.newItemList(itemListID, itemNo, qty);
                }

                Info.information("Item list successfully created", "Item list no: " + itemListID + "<br>Item list name: " + listName + "</br>");
                view.dispose();
            } catch (EmptyStringException ex) {
                Logger.getLogger(NewItemListController.class.getName()).log(Level.SEVERE, null, ex);
            }
        });

        //Clear button
        view.addClearButtonActionListener((ActionEvent e) -> {
            NewItemListController.this.clearView();
        });

        //Double click
        view.addItemListMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                if (e.getClickCount() == 2) {
                    String currentItemName = view.itemListJList.getSelectedValue().toString();
                    if (!addedItem.contains(currentItemName)) {
                        dtm.addRow(new Object[]{ItemCache.getItemNoMap().get(currentItemName), currentItemName, null});
                        addedItem.add(currentItemName);
                    }
                }
            }
        });
    }

    @Override
    public void showView() {
        this.clearView();
        this.updateView();
        Frame.showInternalFrame(view);
    }

    @Override
    public void updateView() {
        dlm.clear();
        for (String itemName : ItemCache.getItemNameList()) {
            dlm.addElement(itemName);
        }
    }

    @Override
    public void clearView() {
        view.searchTextField.setText(null);
        view.nameTextField.setText(null);
        dtm.setRowCount(0);
        addedItem.clear();
    }
}
