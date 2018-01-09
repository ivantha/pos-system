/*
 * Copyright © 02.10.2015 by O.I.Mudannayake. All Rights Reserved.
 */
package entity.item.type;

import entity.item.Item;

/**
 *
 * @author Ivantha
 */
public class InvoiceItem extends Item{
    private int qty;
    private double unitPrice;
    private double discount;

    public InvoiceItem(String itemNo, int qty, double unitPrice, double discount) {
        super(itemNo);
        this.qty = qty;
        this.unitPrice = unitPrice;
        this.discount = discount;
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

    public double getDiscount() {
        return discount;
    }

    public void setDiscount(double discount) {
        this.discount = discount;
    }
}
