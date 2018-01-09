/*
 * Copyright © 02.10.2015 by O.I.Mudannayake. All Rights Reserved.
 */
package entity.payment;

/**
 *
 * @author Ivantha
 */
public class Cash extends PaymentMethod{
    @Override
    public String getMethod() {
        return "Cash";
    }
}
