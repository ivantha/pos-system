/*
 * Copyright © 02.10.2015 by O.I.Mudannayake. All Rights Reserved.
 */
package database.sql.type;

import database.sql.SQL;
import entity.item.type.InventoryItem;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Ivantha
 */
public class InventorySQL extends SQL {

    public void newItem(InventoryItem item) {
        query = "INSERT INTO inventory_item_list(item_no, qty, unit_price) VALUES ("
                + "'" + item.getItemNo() + "',"
                + "'" + item.getQty() + "',"
                + "'" + item.getUnitPrice() + "')";

        c.setQuery(query);
    }

    public void updateItem(InventoryItem item) {
        query = "UPDATE inventory_item_list SET "
                + "qty = '" + item.getQty() + "', "
                + "unit_price = '" + item.getUnitPrice() + "' "
                + "WHERE item_no = '" + item.getItemNo() + "'";

        c.setQuery(query);
    }

    public void incrementItemQty(String itemNo, int qty) {
        query = "SELECT qty FROM inventory_item_list "
                + "WHERE item_no = '" + itemNo + "'";
        rs = c.getQuery(query);
        try {
            while (rs.next()) {
                int newQty = Integer.parseInt(rs.getString("qty")) + qty;
                this.updateItemQty(itemNo, newQty);
            }
        } catch (SQLException ex) {
            Logger.getLogger(InventorySQL.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void decrementItemQty(String itemNo, int qty) {
        query = "SELECT qty FROM inventory_item_list "
                + "WHERE item_no = '" + itemNo + "'";
        rs = c.getQuery(query);
        try {
            while (rs.next()) {
                int newQty = Integer.parseInt(rs.getString("qty")) - qty;
                this.updateItemQty(itemNo, newQty);
            }
        } catch (SQLException ex) {
            Logger.getLogger(InventorySQL.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void updateItemQty(String itemNo, int qty) {
        query = "UPDATE inventory_item_list SET "
                + "qty = '" + qty + "' "
                + "WHERE item_no = '" + itemNo + "'";

        c.setQuery(query);
    }

    public void showItemsInList(DefaultTableModel dtm) {
        query = "SELECT item.item_no, item.name, inventory_item_list.qty, inventory_item_list.unit_price FROM item, inventory_item_list "
                + "WHERE item.item_no = inventory_item_list.item_no";
        rs = c.getQuery(query);
        try {
            while (rs.next()) {
                String itemNo = rs.getString("item_no");
                String itemName = rs.getString("name");
                String itemQty = rs.getString("qty");
                String unitPrice = rs.getString("unit_price");

                dtm.addRow(new Object[]{itemNo, itemName, itemQty, unitPrice});
            }
        } catch (SQLException ex) {
            Logger.getLogger(InventorySQL.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
