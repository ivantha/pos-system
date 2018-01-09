/*
 * Copyright © 02.10.2015 by O.I.Mudannayake. All Rights Reserved.
 */
package goodreceive;

import cache.ItemCache;
import database.sql.type.GoodReceiveSQL;
import java.awt.event.ActionEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;
import javax.swing.DefaultListModel;
import javax.swing.table.DefaultTableModel;
import controller.Controller;
import controller.ControllerFactory;
import controller.Interface;
import ui.support.Frame;
import database.sql.SQLStatement;
import database.sql.SQLFactory;
import entity.item.type.GRNItem;
import javax.swing.event.InternalFrameAdapter;
import javax.swing.event.InternalFrameEvent;
import database.sql.type.InventorySQL;
import exception.InvalidNumberException;
import java.util.logging.Level;
import java.util.logging.Logger;
import main.support.Input;

/**
 *
 * @author Ivantha
 */
public class GRNItemListController implements Controller {

    private final GRNItemList view = new GRNItemList();
    private final GoodReceiveSQL goodReceiveSQL = (GoodReceiveSQL) SQLFactory.getSQLStatement(SQLStatement.GOOD_RECEIVE);
    private final InventorySQL inventorySQL = (InventorySQL) SQLFactory.getSQLStatement(SQLStatement.INVENTORY);
    private final DefaultListModel dlm = new DefaultListModel();
    DefaultTableModel dtm;

    final ArrayList<String> addedItem = new ArrayList<>();
    double netAmount = 0.0;

    public GRNItemListController() {
        view.itemListJList.setModel(dlm);
        dtm = (DefaultTableModel) view.itemListTable.getModel();

        //Update view
        view.updateViewInternalFrameListener(new InternalFrameAdapter() {
            @Override
            public void internalFrameActivated(InternalFrameEvent e) {
                GRNItemListController.this.updateView();
            }
        });

        //Add button
        view.addAddButtonActionListener((ActionEvent e) -> {
            GRNItemListController.this.addItem();
        });

        //Remove button
        view.addRemoveButtonActionListener((ActionEvent e) -> {
            String currentItemName;
            if (view.itemListJList.isSelectionEmpty()) {
                currentItemName = dtm.getValueAt(view.itemListTable.getSelectedRow(), 1).toString();
            } else {
                currentItemName = view.itemListJList.getSelectedValue().toString();
            }

            addedItem.remove(currentItemName);
            dtm.removeRow(view.itemListTable.getSelectedRow());
        });

        //OK button
        view.addOKButtonActionListener((ActionEvent e) -> {
            GRNItemListController.this.calculateTotal();
            view.setVisible(false);
        });

        //Clear button
        view.addClearButtonActionListener((ActionEvent e) -> {
            GRNItemListController.this.clearView();
        });

        //Double click
        view.addItemListMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                if (e.getClickCount() == 2) {
                    GRNItemListController.this.addItem();
                }
            }
        });
    }

    @Override
    public void showView() {
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
        dtm.setRowCount(0);
        addedItem.clear();
    }

    public void submitList(String grnNo) {
        try {
            for (int i = 0; i < dtm.getRowCount(); i++) {
                String itemNo = dtm.getValueAt(i, 0).toString();
                int qty = (int) Input.checkIfValidNumber(dtm.getValueAt(i, 2), "Please enter a correct quantity for " + itemNo);
                double unitPrice = Input.checkIfValidNumber(dtm.getValueAt(i, 3), "Please enter a correct price for " + itemNo);
                double discount = Input.checkIfValidNumber(dtm.getValueAt(i, 4).toString(), "Please enter a correct discount");

                GRNItem grnItem = new GRNItem(itemNo, qty, unitPrice, discount);
                goodReceiveSQL.newGRNItemList(grnNo, grnItem);
                inventorySQL.incrementItemQty(itemNo, qty);
            }
        } catch (InvalidNumberException ex) {
            Logger.getLogger(GRNItemListController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void addItem() {
        String currentItem = view.itemListJList.getSelectedValue().toString();
        if (!addedItem.contains(currentItem)) {
            dtm.addRow(new Object[]{ItemCache.getItemNoMap().get(currentItem), currentItem, null});
            addedItem.add(currentItem);
        }
    }

    public void calculateTotal() {
        try {
            netAmount = 0.0;

            for (int i = 0; i < dtm.getRowCount(); i++) {
                String itemNo = dtm.getValueAt(i, 0).toString();
                int qty = (int) Input.checkIfValidNumber(dtm.getValueAt(i, 2), "Please enter a correct quantity for " + itemNo);
                double unitPrice = Input.checkIfValidNumber(dtm.getValueAt(i, 3), "Please enter a correct price for " + itemNo);
                double discount = Input.checkIfValidNumber(dtm.getValueAt(i, 4).toString(), "Please enter a correct discount");

                netAmount += unitPrice * qty * (100.0 - discount) / 100.0;
            }

            NewGRNController newGRNController = (NewGRNController) ControllerFactory.getController(Interface.NEW_GRN);
            newGRNController.setNetAmount(netAmount);
        } catch (InvalidNumberException | NullPointerException ex) {
            Logger.getLogger(GRNItemListController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
