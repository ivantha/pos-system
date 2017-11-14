/*
 * Copyright © 02.10.2015 by O.I.Mudannayake. All Rights Reserved.
 */
package entity.payment;

/**
 *
 * @author Ivantha
 */
public abstract class Payment {
    String paymentID;
    double amount;
    PaymentMethod paymentMethod;

    public Payment(String id, double amount, PaymentMethod paymentMethod) {
        this.paymentID = id;
        this.amount = amount;
        this.paymentMethod = paymentMethod;
    }

    public String getId() {
        return paymentID;
    }

    public void setId(String id) {
        this.paymentID = id;
    }
    
    public double getAmount() {
        return amount;
    }

    public void setAmount(double amount) {
        this.amount = amount;
    }

    public PaymentMethod getPaymentMethod() {
        return paymentMethod;
    }

    public void setPaymentMethod(PaymentMethod paymentMethod) {
        this.paymentMethod = paymentMethod;
    }  
}
