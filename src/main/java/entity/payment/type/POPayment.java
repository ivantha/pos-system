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
public class POPayment extends Payment {
    public POPayment(String id, double amount, PaymentMethod paymentMethod) {
        super(id, amount, paymentMethod);
    }
}
