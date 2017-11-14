/*
 * Copyright © 02.10.2015 by O.I.Mudannayake. All Rights Reserved.
 */
package database.sql.type;

import cache.ItemCache;
import database.sql.SQL;
import entity.item.Item;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Ivantha
 */
public class ItemManagementSQL extends SQL {

    public String generateNewItemNo() {
        String preID = this.getLastValue("item", "item_no");
        String idX = String.format("%07d", Integer.parseInt(preID.substring(3, 10)) + 1);

        result = "it." + idX;
        return result;
    }

    public void newItem(Item item) {
        query = "INSERT INTO item(item_no, name, description) VALUES ("
                + "'" + item.getItemNo() + "',"
                + "'" + item.getName() + "',"
                + "'" + item.getDescription() + "')";

        c.setQuery(query);
        ItemCache.setItemListChanged();
    }

    public void updateItem(Item item) {
        query = "UPDATE item SET "
                + "name = '" + item.getName() + "', "
                + "description = '" + item.getDescription() + "' "
                + "WHERE item_no = '" + item.getItemNo() + "'";

        c.setQuery(query);
        ItemCache.setItemListChanged();
    }

    /*public void removeItem(String itemNo){
        query = "DELETE FROM item WHERE item_no = '" + itemNo + "'";
        
        c.setQuery(query);
        ItemCache.setItemListChanged();
    }*/
    public void getItems(LinkedHashMap<String, String> itemNoMap, ArrayList<String> itemNameList, 
            LinkedHashMap<String, String> itemDescriptionMap, LinkedHashMap<String, Double> itemPriceMap) {
        query = "SELECT item.item_no, item.name, item.description, inventory_item_list.unit_price FROM item "
                + "LEFT JOIN inventory_item_list ON item.item_no = inventory_item_list.item_no";
        rs = c.getQuery(query);

        try {
            while (rs.next()) {
                String itemNo = rs.getString("item.item_no");
                String itemName = rs.getString("item.name");
                String itemDescription = rs.getString("item.description");
                Double itemPrice = Double.parseDouble(rs.getString("inventory_item_list.unit_price"));

                itemNoMap.put(itemName, itemNo);
                itemNameList.add(itemName);
                itemDescriptionMap.put(itemName, itemDescription);
                itemPriceMap.put(itemName, itemPrice);
            }
        } catch (SQLException ex) {
            Logger.getLogger(ItemManagementSQL.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
