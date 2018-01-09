/*
 * Copyright © 02.10.2015 by O.I.Mudannayake. All Rights Reserved.
 */
package entity.payment.type;

import entity.payment.Payment;
import entity.payment.PaymentMethod;

/**
 *
 * @author Ivantha
 */
public class GRNPayment extends Payment{
    private double discount;

    public GRNPayment(double discount, String id, double amount, PaymentMethod paymentMethod) {
        super(id, amount, paymentMethod);
        this.discount = discount;
    }

    public double getDiscount() {
        return discount;
    }

    public void setDiscount(double discount) {
        this.discount = discount;
    }
}
