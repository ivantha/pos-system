/*
 * Copyright © 02.10.2015 by O.I.Mudannayake. All Rights Reserved.
 */
package purchaseorder;

import database.sql.type.PurchaseOrderSQL;
import entity.item.type.POItem;
import java.awt.event.ActionEvent;
import java.awt.event.FocusAdapter;
import java.awt.event.FocusEvent;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;
import javax.swing.DefaultListModel;
import javax.swing.table.DefaultTableModel;
import controller.Controller;
import cache.ItemCache;
import ui.support.Frame;
import database.sql.SQLStatement;
import database.sql.SQLFactory;
import exception.InvalidNumberException;
import javax.swing.event.InternalFrameAdapter;
import javax.swing.event.InternalFrameEvent;
import main.support.Input;

/**
 *
 * @author Ivantha
 */
public class PurchaseItemListController implements Controller {

    private final PurchaseItemList view = new PurchaseItemList();
    private final PurchaseOrderSQL purchaseOrderSQL = (PurchaseOrderSQL) SQLFactory.getSQLStatement(SQLStatement.PURCHASE_ORDER);
    private final DefaultListModel dlm = new DefaultListModel();
    DefaultTableModel dtm;
    final ArrayList<String> addedItem = new ArrayList<>();
    private String searchPhrase = "";
    private NewPOController newPOController;

    public PurchaseItemListController() {
        view.itemListJList.setModel(dlm);
        dtm = (DefaultTableModel) view.itemListTable.getModel();

        //Update view
        view.updateViewInternalFrameListener(new InternalFrameAdapter() {
            @Override
            public void internalFrameActivated(InternalFrameEvent e) {
                PurchaseItemListController.this.updateView();
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
            newPOController.setItemListAsCustom();
            view.setVisible(false);
        });

        //Clear button
        view.addClearButtonActionListener((ActionEvent e) -> {
            PurchaseItemListController.this.clearView();
        });

        //Double click
        view.addItemListMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                if (e.getClickCount() == 2) {
                    String currentItem = view.itemListJList.getSelectedValue().toString();
                    if (!addedItem.contains(currentItem)) {
                        dtm.addRow(new Object[]{ItemCache.getItemNoMap().get(currentItem), currentItem, null});
                        addedItem.add(currentItem);
                    }
                }
            }
        });

        //Item list focus gain
        view.addItemListFocusListener(new FocusAdapter() {
            @Override
            public void focusGained(FocusEvent e) {
                PurchaseItemListController.this.updateView();
            }
        });

        //Search
        view.addSearchTextFieldActionListener(new KeyAdapter() {
            @Override
            public void keyReleased(KeyEvent e) {
                searchPhrase = view.searchTextField.getText().trim();
                PurchaseItemListController.this.updateView();
            }
        });
    }

    @Override
    public void showView() {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    public void showView(NewPOController newPOController) {
        this.newPOController = newPOController;

        this.updateView();
        Frame.showInternalFrame(view);
    }

    @Override
    public void updateView() {
        dlm.clear();
        addedItem.clear();
        for (String itemName : ItemCache.getItemNameList()) {
            if (itemName.toLowerCase().contains(searchPhrase.toLowerCase())) {
                dlm.addElement(itemName);
            }
        }
    }

    @Override
    public void clearView() {
        view.searchTextField.setText(null);
        dlm.clear();
        dtm.setRowCount(0);
        addedItem.clear();
    }

    public void submitList(String poNo) throws InvalidNumberException {
        for (int i = 0; i < dtm.getRowCount(); i++) {
            String itemNo = dtm.getValueAt(i, 0).toString();
            int qty = (int) Input.checkIfValidNumber(dtm.getValueAt(i, 2), "Please enter a correct quantity for " + itemNo);
            double unitPrice = Input.checkIfValidNumber(dtm.getValueAt(i, 3), "Please enter a correct price for " + itemNo);

            POItem item = new POItem(itemNo, qty, unitPrice);
            purchaseOrderSQL.addItemToList(poNo, item);
        }
    }
}
