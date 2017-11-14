/*
 * Copyright © 02.10.2015 by O.I.Mudannayake. All Rights Reserved.
 */
package management.item;

import database.sql.type.ItemManagementSQL;
import java.awt.event.ActionEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.DefaultListModel;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import controller.Controller;
import cache.ItemCache;
import ui.support.Frame;
import controller.ControllerFactory;
import controller.Interface;
import database.sql.SQLStatement;
import database.sql.SQLFactory;
import entity.item.Item;
import javax.swing.event.InternalFrameAdapter;
import javax.swing.event.InternalFrameEvent;
import ui.support.Info;

/**
 *
 * @author Ivantha
 */
public class ManageItemsController implements Controller {

    private final ManageItems view = new ManageItems();
    private final ItemManagementSQL itemManagementSQL = (ItemManagementSQL) SQLFactory.getSQLStatement(SQLStatement.ITEM_MANAGEMENT);
    private final DefaultListModel dlm = new DefaultListModel();
    private String searchPhrase = "";

    public ManageItemsController() {
        view.itemListJList.setModel(dlm);

        //Update view
        view.updateViewInternalFrameListener(new InternalFrameAdapter() {
            @Override
            public void internalFrameActivated(InternalFrameEvent e) {
                ManageItemsController.this.updateView();
            }
        });

        //New button
        view.addNewButtonActionlistener((ActionEvent e) -> {
            NewItemController nic = (NewItemController) ControllerFactory.getController(Interface.NEW_ITEM);
            nic.showView();
        });

        //Edit button
        view.addEditButtonActionlistener((ActionEvent e) -> {
            EditItemController eic = (EditItemController) ControllerFactory.getController(Interface.EDIT_ITEM);

            try {
                String currentItemName = view.itemListJList.getSelectedValue().toString();
                String itemNo = ItemCache.getItemNo(currentItemName);
                String description = ItemCache.getItemDescription(currentItemName);
                Item item = new Item(itemNo, currentItemName, description) {
                };
                eic.showView(item);
            } catch (NullPointerException ex) {
                Info.error("Incorrect selection", "Please select an item to edit");
            }
        });

        //Remove button
        view.addRemoveButtonActionListener((ActionEvent e) -> {
            Info.error("Invalid function", "This feature is not yet implemented");
            /*String itemNo = view.itemNoTextField.getText();
            itemManagementSQL.removeItem(itemNo);
            ManageItemsController.this.updateView();*/
        });

        //Mouse click
        view.addItemListMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                String currentItemName = view.itemListJList.getSelectedValue().toString();
                view.itemNoTextField.setText(ItemCache.getItemNo(currentItemName));
                view.descriptionTextArea.setText(ItemCache.getItemDescription(currentItemName));
            }
        });

        //Key pressed
        view.addItemListKeyListener(new KeyAdapter() {
            @Override
            public void keyReleased(KeyEvent e) {
                String currentItemName = view.itemListJList.getSelectedValue().toString();
                view.itemNoTextField.setText(ItemCache.getItemNo(currentItemName));
                view.descriptionTextArea.setText(ItemCache.getItemDescription(currentItemName));
            }
        });

        //Search
        view.addSearchTextFieldActionListener(new KeyAdapter() {
            @Override
            public void keyReleased(KeyEvent e) {
                searchPhrase = view.searchTextField.getText().trim();
                ManageItemsController.this.updateView();
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
        for (String itemName : ItemCache.getItemNameList()) {
            if (itemName.toLowerCase().contains(searchPhrase.toLowerCase())) {
                dlm.addElement(itemName);
            }
        }
    }

    @Override
    public void clearView() {
    }
}
