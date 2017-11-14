/*
 * Copyright © 02.10.2015 by O.I.Mudannayake. All Rights Reserved.
 */
package entity.payment;

/**
 *
 * @author Ivantha
 */
public class CreditCard extends PaymentMethod{
    private String creditCardNo;
    private String bank;
    
    @Override
    public String getMethod() {
        return "Credit";
    }

    public CreditCard(String creditCardNo, String bank) {
        this.creditCardNo = creditCardNo;
        this.bank = bank;
    }

    public String getCreditCardNo() {
        return creditCardNo;
    }

    public void setCreditCardNo(String creditCardNo) {
        this.creditCardNo = creditCardNo;
    }

    public String getBank() {
        return bank;
    }

    public void setBank(String bank) {
        this.bank = bank;
    }
}
