/*
 * Copyright © 02.10.2015 by O.I.Mudannayake. All Rights Reserved.
 */
package entity.payment;

/**
 *
 * @author Ivantha
 */
public class Cheque extends PaymentMethod{
    private String chequeNo;
    private String bank;
    
    @Override
    public String getMethod() {
        return "Cheque";
    }

    public Cheque(String chequeNo, String bank) {
        this.chequeNo = chequeNo;
        this.bank = bank;
    }

    public String getChequeNo() {
        return chequeNo;
    }

    public void setChequeNo(String chequeNo) {
        this.chequeNo = chequeNo;
    }

    public String getBank() {
        return bank;
    }

    public void setBank(String bank) {
        this.bank = bank;
    }
}
