/*
 * Copyright © 02.10.2015 by O.I.Mudannayake. All Rights Reserved.
 */
package entity.item.type;

import entity.item.Item;

/**
 *
 * @author Ivantha
 */
public class POItem extends Item{
    private int qty;
    private double unitPrice;

    public POItem(String itemNo, int qty, double unitPrice) {
        super(itemNo);
        this.qty = qty;
        this.unitPrice = unitPrice;
    }

    public int getQty() {
        return qty;
    }

    public void setQty(int qty) {
        this.qty = qty;
    }

    public double getUnitPrice() {
        return unitPrice;
    }

    public void setUnitPrice(double unitPrice) {
        this.unitPrice = unitPrice;
    }
}
