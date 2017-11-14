/*
 * Copyright © 02.10.2015 by O.I.Mudannayake. All Rights Reserved.
 */
package management.supplier;

import entity.Supplier;
import controller.Controller;
import database.sql.SQLFactory;
import database.sql.SQLStatement;
import database.sql.type.SupplierManagementSQL;
import ui.support.Frame;
import javax.swing.event.InternalFrameAdapter;
import javax.swing.event.InternalFrameEvent;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Ivantha
 */
public class SupplierHistoryController implements Controller {

    private final SupplierHistory view = new SupplierHistory();
    private final SupplierManagementSQL supplierManagementSQL = (SupplierManagementSQL) SQLFactory.getSQLStatement(SQLStatement.SUPPLIER_MANAGEMENT);
    private final DefaultTableModel dtm;

    public SupplierHistoryController() {
        dtm = (DefaultTableModel) view.supplierHistoryTable.getModel();

        //Update view
        view.updateViewInternalFrameListener(new InternalFrameAdapter() {
            @Override
            public void internalFrameActivated(InternalFrameEvent e) {
                SupplierHistoryController.this.updateView();
            }
        });
    }

    @Override
    public void showView() {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    public void showView(Supplier supplier) {
        this.clearView();
        view.supplierIDTextField.setText(supplier.getSupplierID());
        view.nameTextField.setText(supplier.getName());
        supplierManagementSQL.showSupplierHistory(supplier, dtm);

        Frame.showInternalFrame(view);
    }

    @Override
    public void updateView() {
    }

    @Override
    public void clearView() {
        dtm.setRowCount(0);
    }
}
