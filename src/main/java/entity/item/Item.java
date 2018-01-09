/*
 * Copyright © 02.10.2015 by O.I.Mudannayake. All Rights Reserved.
 */
package entity.item;

/**
 *
 * @author Ivantha
 */
public abstract class Item {
    String itemNo;
    String name;
    String description;

    public Item(String itemNo) {
        this.itemNo = itemNo;
    }

    public Item(String itemNo, String name) {
        this.itemNo = itemNo;
        this.name = name;
    }

    public Item(String itemNo, String name, String description) {
        this.itemNo = itemNo;
        this.name = name;
        this.description = description;
    }

    public String getItemNo() {
        return itemNo;
    }

    public void setItemNo(String itemNo) {
        this.itemNo = itemNo;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}