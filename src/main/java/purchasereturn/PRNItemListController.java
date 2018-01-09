/*
 * Copyright © 02.10.2015 by O.I.Mudannayake. All Rights Reserved.
 */
package purchasereturn;

import java.awt.event.ActionEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.table.DefaultTableModel;
import controller.Controller;
import ui.support.Frame;
import javax.swing.event.InternalFrameAdapter;
import javax.swing.event.InternalFrameEvent;

/**
 *
 * @author Ivantha
 */
public class PRNItemListController implements Controller {

    private final PRNItemList view = new PRNItemList();
    DefaultTableModel dtm;
    private NewPRNController newPRNController;

    public PRNItemListController() {
        dtm = (DefaultTableModel) view.itemListTable.getModel();

        //Update view
        view.updateViewInternalFrameListener(new InternalFrameAdapter() {
            @Override
            public void internalFrameActivated(InternalFrameEvent e) {
                PRNItemListController.this.updateView();
            }
        });

        //Add button
        view.addAddButtonActionListener((ActionEvent e) -> {
            PRNItemListController.this.addItem();
        });

        //Double click
        view.addItemListMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                if (e.getClickCount() == 2) {
                    PRNItemListController.this.addItem();
                }
            }
        });
    }

    @Override
    public void showView() {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    public void showView(NewPRNController newPRNController) {
        this.newPRNController = newPRNController;

        Frame.showInternalFrame(view);
    }

    @Override
    public void updateView() {
    }

    @Override
    public void clearView() {
    }

    public void addItem() {
        String currentItemName = (String) view.itemListTable.getModel().getValueAt(view.itemListTable.getSelectedRow(), 1);
        if (!newPRNController.addedItem.contains(currentItemName)) {
            String itemNo = (String) view.itemListTable.getModel().getValueAt(view.itemListTable.getSelectedRow(), 0);
            Double unitPrice = (Double) view.itemListTable.getModel().getValueAt(view.itemListTable.getSelectedRow(), 3);
            newPRNController.dtm.addRow(new Object[]{itemNo, currentItemName, "", unitPrice});
            newPRNController.addedItem.add(currentItemName);
        }
    }
}
