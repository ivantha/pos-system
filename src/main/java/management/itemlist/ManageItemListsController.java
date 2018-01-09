/*
 * Copyright © 02.10.2015 by O.I.Mudannayake. All Rights Reserved.
 */
package management.itemlist;

import database.sql.type.ItemListManagementSQL;
import java.awt.event.ActionEvent;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.DefaultListModel;
import javax.swing.table.DefaultTableModel;
import controller.Controller;
import cache.ItemListCache;
import ui.support.Frame;
import controller.ControllerFactory;
import controller.Interface;
import database.sql.SQLStatement;
import database.sql.SQLFactory;
import exception.ValueNotSelectedException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.event.InternalFrameAdapter;
import javax.swing.event.InternalFrameEvent;
import ui.support.Info;

/**
 *
 * @author Ivantha
 */
public class ManageItemListsController implements Controller {

    private final ManageItemLists view = new ManageItemLists();
    private final ItemListManagementSQL itemListManagementSQL = (ItemListManagementSQL) SQLFactory.getSQLStatement(SQLStatement.ITEM_LIST_MANAGEMENT);
    private final DefaultListModel dlm = new DefaultListModel();
    private final DefaultTableModel dtm;
    private String searchPhrase = "";

    public ManageItemListsController() {
        view.itemListJList.setModel(dlm);
        dtm = (DefaultTableModel) view.itemListTable.getModel();

        //Update view
        view.updateViewInternalFrameListener(new InternalFrameAdapter() {
            @Override
            public void internalFrameActivated(InternalFrameEvent e) {
                ManageItemListsController.this.updateView();
            }
        });

        //New button
        view.addNewButtonActionListener((ActionEvent e) -> {
            NewItemListController newItemListController = (NewItemListController) ControllerFactory.getController(Interface.NEW_ITEM_LIST);
            newItemListController.showView();
        });

        //Edit button
        view.addEditButtonActionListener((ActionEvent e) -> {
            EditItemListController editItemListController = (EditItemListController) ControllerFactory.getController(Interface.EDIT_ITEM_LIST);
            try {
                editItemListController.showView(ManageItemListsController.this.getItemListName());
            } catch (ValueNotSelectedException ex) {
                Info.error("Value not selected", "Please select an item list name from the list to edit");
                Logger.getLogger(ManageItemListsController.class.getName()).log(Level.SEVERE, null, ex);
            }
        });

        //Remove button
        view.addRemoveButtonActionListener((ActionEvent e) -> {
            try {
                String itemListName = ManageItemListsController.this.getItemListName();
                String itemListID = ItemListCache.getItemListID(itemListName);
                itemListManagementSQL.removeItemList(itemListID);
                
                ManageItemListsController.this.updateView();
                Info.information("Item list successfully deleted", "Item list no: " + itemListID + "<br>Item list name: " + itemListName + "</br>");
            } catch (ValueNotSelectedException ex) {
                Info.error("Value not selected", "Please select an item list name from the list to delete");
                Logger.getLogger(ManageItemListsController.class.getName()).log(Level.SEVERE, null, ex);
            }
        });

        //Mouse click
        view.addItemListsMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                if (e.getClickCount() == 2) {
                    EditItemListController editItemListController = (EditItemListController) ControllerFactory.getController(Interface.EDIT_ITEM_LIST);
                    try {
                        editItemListController.showView(ManageItemListsController.this.getItemListName());
                    } catch (ValueNotSelectedException ex) {
                        Info.error("Value not selected", "Please select an item list name from the list");
                        Logger.getLogger(ManageItemListsController.class.getName()).log(Level.SEVERE, null, ex);
                    }
                } else {
                    ManageItemListsController.this.updateItemListTable();
                    try {
                        view.itemlistIDTextField.setText(ItemListCache.getItemListID(ManageItemListsController.this.getItemListName()));
                    } catch (ValueNotSelectedException ex) {
                        Logger.getLogger(ManageItemListsController.class.getName()).log(Level.SEVERE, null, ex);
                    }
                }

            }
        });

        //Key pressed
        view.addItemListKeyListener(new KeyAdapter() {
            @Override
            public void keyReleased(KeyEvent e) {
                ManageItemListsController.this.updateItemListTable();
                try {
                    view.itemlistIDTextField.setText(ItemListCache.getItemListID(ManageItemListsController.this.getItemListName()));
                } catch (ValueNotSelectedException ex) {
                    Logger.getLogger(ManageItemListsController.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        });

        //Search
        view.addSearchTextFieldKeyListener(new KeyAdapter() {
            @Override
            public void keyReleased(KeyEvent e) {
                searchPhrase = view.searchTextField.getText().trim();
                ManageItemListsController.this.updateView();
            }
        });
    }

    @Override
    public void showView() {
        Frame.showInternalFrame(view);
    }

    @Override
    public void updateView() {
        dlm.clear();
        for (String listName : ItemListCache.getItemListNameList()) {
            if (listName.toLowerCase().contains(searchPhrase.toLowerCase())) {
                dlm.addElement(listName);
            }
        }

        this.updateItemListTable();
    }

    public void updateItemListTable() {
        dtm.setRowCount(0);
        try {
            itemListManagementSQL.showItemsInList(ItemListCache.getItemListID(this.getItemListName()), dtm);
        } catch (ValueNotSelectedException ex) {
            Logger.getLogger(ManageItemListsController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public String getItemListName() throws ValueNotSelectedException {
        if (view.itemListJList.getSelectedValue() != null) {
            return view.itemListJList.getSelectedValue().toString();
        } else {
            throw new ValueNotSelectedException();
        }
    }

    @Override
    public void clearView() {
    }
}
