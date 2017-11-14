/*
 * Copyright © 02.10.2015 by O.I.Mudannayake. All Rights Reserved.
 */
package cache;

import database.sql.SQLStatement;
import database.sql.SQLFactory;
import database.sql.type.ItemManagementSQL;
import java.util.ArrayList;
import java.util.LinkedHashMap;

/**
 *
 * @author Ivantha
 */
public class ItemCache {
    private static final ItemManagementSQL itemManagementSQL = (ItemManagementSQL) SQLFactory.getSQLStatement(SQLStatement.ITEM_MANAGEMENT);
    
    private static boolean itemListChanged = true;
    
    private static final ArrayList<String> itemNameList = new ArrayList<>();
    private static final LinkedHashMap<String, String> itemNoMap = new LinkedHashMap<>();
    private static final LinkedHashMap<String, String> itemDescriptionMap = new LinkedHashMap<>();
    private static final LinkedHashMap<String, Double> itemPriceMap = new LinkedHashMap<>();
    
    public static void setItemListChanged(){
        itemListChanged = true;
    }
    
    public static String getItemNo(String itemName){
        return ItemCache.getItemNoMap().get(itemName);
    }
    
    public static String getItemDescription(String itemName){
        return ItemCache.getItemDescriptionMap().get(itemName);
    }
    
    public static Double getItemPrice(String itemName){
        return ItemCache.getItemPriceMap().get(itemName);
    }
    
    public static ArrayList<String> getItemNameList(){
        ItemCache.updateItemList();
        return itemNameList;
    }
    
    public static LinkedHashMap<String, String> getItemNoMap(){
        ItemCache.updateItemList();
        return itemNoMap;
    }
    
    public static LinkedHashMap<String, String> getItemDescriptionMap(){
        ItemCache.updateItemList();
        return itemDescriptionMap;
    }
    
    public static LinkedHashMap<String, Double> getItemPriceMap(){
        ItemCache.updateItemList();
        return itemPriceMap;
    }
    
    public static void updateItemList(){
        if (itemListChanged){
            itemNoMap.clear();
            itemNameList.clear();
            itemDescriptionMap.clear();
            itemManagementSQL.getItems(itemNoMap, itemNameList, itemDescriptionMap, itemPriceMap);
            
            itemListChanged = false;
        }
    }
}
