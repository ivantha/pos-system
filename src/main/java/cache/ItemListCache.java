/*
 * Copyright © 02.10.2015 by O.I.Mudannayake. All Rights Reserved.
 */
package cache;

import database.sql.SQLStatement;
import database.sql.SQLFactory;
import database.sql.type.ItemListManagementSQL;
import java.util.ArrayList;
import java.util.LinkedHashMap;

/**
 *
 * @author Ivantha
 */
public class ItemListCache {

    private static final ItemListManagementSQL itemListManagementSQL = (ItemListManagementSQL) SQLFactory.getSQLStatement(SQLStatement.ITEM_LIST_MANAGEMENT);

    private static boolean itemListListChanged = true;

    private static final ArrayList<String> itemListNameList = new ArrayList<>();
    private static final LinkedHashMap<String, String> itemListIDMap = new LinkedHashMap<>();

    public static void setItemListListChanged() {
        itemListListChanged = true;
    }

    public static String getItemListID(String itemListName) {
        return ItemListCache.getItemListIDMap().get(itemListName);
    }

    public static ArrayList<String> getItemListNameList() {
        ItemListCache.updateItemListList();
        return itemListNameList;
    }

    public static LinkedHashMap<String, String> getItemListIDMap() {
        ItemListCache.updateItemListList();
        return itemListIDMap;
    }

    public static void updateItemListList() {
        if (itemListListChanged) {
            itemListNameList.clear();
            itemListIDMap.clear();
            itemListManagementSQL.getItemLists(itemListNameList, itemListIDMap);

            itemListListChanged = false;
        }
    }
}
