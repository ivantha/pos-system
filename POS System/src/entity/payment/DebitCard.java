/*
 * Copyright © 02.10.2015 by O.I.Mudannayake. All Rights Reserved.
 */
package entity.payment;

/**
 *
 * @author Ivantha
 */
public class DebitCard extends PaymentMethod{
    private String debitCardNo;
    private String bank;
    
    @Override
    public String getMethod() {
        return "Debit";
    }

    public DebitCard(String debitCardNo, String bank) {
        this.debitCardNo = debitCardNo;
        this.bank = bank;
    }

    public String getDebitCardNo() {
        return debitCardNo;
    }

    public void setDebitCardNo(String debitCardNo) {
        this.debitCardNo = debitCardNo;
    }

    public String getBank() {
        return bank;
    }

    public void setBank(String bank) {
        this.bank = bank;
    }
}
