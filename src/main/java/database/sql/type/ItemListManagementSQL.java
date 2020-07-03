/*
 * Copyright © 02.10.2015 by O.I.Mudannayake. All Rights Reserved.
 */
package database.sql.type;

import cache.ItemListCache;
import database.sql.SQL;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Ivantha
 */
public class ItemListManagementSQL extends SQL {

    public String generateNewItemListID() {
        String preID = this.getLastValue("item_list", "list_id");
        String idX = String.format("%07d", Integer.parseInt(preID.substring(3, 10)) + 1);
        result = "il." + idX;

        return result;
    }

    public void newItemListID(String itemListID, String listName) {
        query = "INSERT INTO item_list(list_id, name) VALUES ("
                + "'" + itemListID + "',"
                + "'" + listName + "')";

        c.setQuery(query);
        ItemListCache.setItemListListChanged();
    }

    public void newItemList(String itemListID, String itemNo, int qty) {
        query = "INSERT INTO item_list_items(list_id, item_no, qty) VALUES ("
                + "'" + itemListID + "',"
                + "'" + itemNo + "',"
                + "'" + qty + "')";

        c.setQuery(query);
        ItemListCache.setItemListListChanged();
    }

    public void removeItemList(String itemListID) {
        query = "DELETE FROM item_list_items "
                + "WHERE list_id = '" + itemListID + "'";

        c.setQuery(query);

        query = "DELETE FROM item_list "
                + "WHERE list_id = '" + itemListID + "'";

        c.setQuery(query);
        ItemListCache.setItemListListChanged();
    }

    public void showItemsInList(String itemListID, DefaultTableModel dtm) {
        query = "SELECT item.item_no, item.name, item_list_items.qty FROM item, item_list_items WHERE item.item_no = item_list_items.item_no AND item_list_items.list_id = '" + itemListID + "'";
        rs = c.getQuery(query);
        try {
            while (rs.next()) {
                String itemNo = rs.getString("item_no");
                String itemName = rs.getString("name");
                String itemQty = rs.getString("qty");

                dtm.addRow(new Object[]{itemNo, itemName, itemQty});
            }
        } catch (SQLException ex) {
            Logger.getLogger(ItemManagementSQL.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void showItemsInList(String itemListID, DefaultTableModel dtm, ArrayList<String> addedItem) {
        query = "SELECT item.item_no, item.name, item_list_items.qty FROM item, item_list_items WHERE item.item_no = item_list_items.item_no AND item_list_items.list_id = '" + itemListID + "'";
        rs = c.getQuery(query);
        try {
            while (rs.next()) {
                String itemNo = rs.getString("item_no");
                String itemName = rs.getString("name");
                String itemQty = rs.getString("qty");

                dtm.addRow(new Object[]{itemNo, itemName, itemQty});
                addedItem.add(itemName);
            }
        } catch (SQLException ex) {
            Logger.getLogger(ItemManagementSQL.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void addItemToList(String itemListID, String itemNo, int qty) {
        query = "INSERT INTO item_list_items(list_id, item_no, qty) VALUES ("
                + "'" + itemListID + "',"
                + "'" + itemNo + "',"
                + "'" + qty + "')";

        c.setQuery(query);
        ItemListCache.setItemListListChanged();
    }

    public void getItemLists(ArrayList<String> itemListNameList, LinkedHashMap<String, String> itemListIDMap) {
        query = "SELECT list_id, name FROM item_list ORDER BY row ASC";
        rs = c.getQuery(query);
        try {
            while (rs.next()) {
                String listID = rs.getString("list_id");
                String listName = rs.getString("name");

                itemListNameList.add(listName);
                itemListIDMap.put(listName, listID);
            }
        } catch (SQLException ex) {
            Logger.getLogger(ItemManagementSQL.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void updateItemListName(String itemListID, String itemListName) {
        query = "UPDATE item_list SET "
                + "name = '" + itemListName + "' "
                + "WHERE list_id = '" + itemListID + "'";

        c.setQuery(query);
        ItemListCache.setItemListListChanged();
    }

    public void updateItemList(String itemListID, String itemNo, int qty) {
        query = "UPDATE item_list_items SET "
                + "qty = '" + qty + "' "
                + "WHERE list_id = '" + itemListID + "' AND item_no = '" + itemNo + "'";

        c.setQuery(query);
        ItemListCache.setItemListListChanged();
    }

    public void removeFromItemList(String itemListID, ArrayList<String> removedItem) {
        for (String itemNo : removedItem) {
            query = "DELETE FROM item_list_items "
                    + "WHERE list_id = '" + itemListID + "' AND item_no = '" + itemNo + "'";

            c.setQuery(query);
        }

        ItemListCache.setItemListListChanged();
    }
}
