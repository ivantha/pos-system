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
public class InvoicePayment extends Payment{
    private double discount = 0.0;
    private double amountPaid;

    public InvoicePayment(String id, double amount, PaymentMethod paymentMethod, double amountPaid) {
        super(id, amount, paymentMethod);
        this.amountPaid = amountPaid;
    }

    public InvoicePayment(String id, double amount, PaymentMethod paymentMethod, double discount, double amountPaid) {
        super(id, amount, paymentMethod);
        this.discount = discount;
        this.amountPaid = amountPaid;
    }

    public double getDiscount() {
        return discount;
    }

    public void setDiscount(double discount) {
        this.discount = discount;
    }

    public double getAmountPaid() {
        return amountPaid;
    }

    public void setAmountPaid(double amountPaid) {
        this.amountPaid = amountPaid;
    }
}
