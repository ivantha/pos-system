/*
 * Copyright © 02.10.2015 by O.I.Mudannayake. All Rights Reserved.
 */
package database.sql.type;

import database.sql.SQL;
import entity.payment.Cheque;
import entity.payment.CreditCard;
import entity.payment.DebitCard;
import entity.payment.type.GRNPayment;
import entity.payment.type.InvoicePayment;
import entity.payment.type.POPayment;
import entity.payment.type.PRNPayment;
import entity.payment.type.SRNPayment;

/**
 *
 * @author Ivantha
 */
public class PaymentSQL extends SQL {

    public String generateNewID() {
        String preID = this.getLastValue("payment", "payment_id");
        String idX = String.format("%07d", Integer.parseInt(preID.substring(3, 10)) + 1);

        result = "pa." + idX;
        return result;
    }

    public void newPayment(POPayment payment) {
        switch (payment.getPaymentMethod().getMethod()) {
            case "Cash":
                query = "INSERT INTO payment(payment_id, amount, payment_method) VALUES ("
                        + "'" + payment.getId() + "',"
                        + "'" + payment.getAmount() + "',"
                        + "'" + payment.getPaymentMethod().getMethod() + "')";
                break;
            case "Cheque":
                Cheque cheque = (Cheque) payment.getPaymentMethod();
                query = "INSERT INTO payment(payment_id, amount, payment_method, bank, cheque_no) VALUES ("
                        + "'" + payment.getId() + "',"
                        + "'" + payment.getAmount() + "',"
                        + "'" + payment.getPaymentMethod().getMethod() + "',"
                        + "'" + cheque.getBank() + "',"
                        + "'" + cheque.getChequeNo() + "')";
                break;
            case "Debit":
                DebitCard debitCard = (DebitCard) payment.getPaymentMethod();
                query = "INSERT INTO payment(payment_id, amount, payment_method, bank, debit_card_no) VALUES ("
                        + "'" + payment.getId() + "',"
                        + "'" + payment.getAmount() + "',"
                        + "'" + payment.getPaymentMethod().getMethod() + "',"
                        + "'" + debitCard.getBank() + "',"
                        + "'" + debitCard.getDebitCardNo() + "')";
                break;
            case "Credit":
                CreditCard creditCard = (CreditCard) payment.getPaymentMethod();
                query = "INSERT INTO payment(payment_id, amount, payment_method, bank, credit_card_no) VALUES ("
                        + "'" + payment.getId() + "',"
                        + "'" + payment.getAmount() + "',"
                        + "'" + payment.getPaymentMethod().getMethod() + "',"
                        + "'" + creditCard.getBank() + "',"
                        + "'" + creditCard.getCreditCardNo() + "')";
                break;
        }

        c.setQuery(query);
    }

    public void newPayment(GRNPayment payment) {
        switch (payment.getPaymentMethod().getMethod()) {
            case "Cash":
                query = "INSERT INTO payment(payment_id, amount, discount, payment_method) VALUES ("
                        + "'" + payment.getId() + "',"
                        + "'" + payment.getAmount() + "',"
                        + "'" + payment.getDiscount() + "',"
                        + "'" + payment.getPaymentMethod().getMethod() + "')";
                break;
            case "Cheque":
                Cheque cheque = (Cheque) payment.getPaymentMethod();
                query = "INSERT INTO payment(payment_id, amount, discount, payment_method, bank, cheque_no) VALUES ("
                        + "'" + payment.getId() + "',"
                        + "'" + payment.getAmount() + "',"
                        + "'" + payment.getDiscount() + "',"
                        + "'" + payment.getPaymentMethod().getMethod() + "',"
                        + "'" + cheque.getBank() + "',"
                        + "'" + cheque.getChequeNo() + "')";
                break;
            case "Debit":
                DebitCard debitCard = (DebitCard) payment.getPaymentMethod();
                query = "INSERT INTO payment(payment_id, amount, discount, payment_method, bank, debit_card_no) VALUES ("
                        + "'" + payment.getId() + "',"
                        + "'" + payment.getAmount() + "',"
                        + "'" + payment.getDiscount() + "',"
                        + "'" + payment.getPaymentMethod().getMethod() + "',"
                        + "'" + debitCard.getBank() + "',"
                        + "'" + debitCard.getDebitCardNo() + "')";
                break;
            case "Credit":
                CreditCard creditCard = (CreditCard) payment.getPaymentMethod();
                query = "INSERT INTO payment(payment_id, amount, discount, payment_method, bank, credit_card_no) VALUES ("
                        + "'" + payment.getId() + "',"
                        + "'" + payment.getAmount() + "',"
                        + "'" + payment.getDiscount() + "',"
                        + "'" + payment.getPaymentMethod().getMethod() + "',"
                        + "'" + creditCard.getBank() + "',"
                        + "'" + creditCard.getCreditCardNo() + "')";
                break;
        }

        c.setQuery(query);
    }

    public void newPayment(PRNPayment payment) {
        switch (payment.getPaymentMethod().getMethod()) {
            case "Cash":
                query = "INSERT INTO payment(payment_id, amount, payment_method) VALUES ("
                        + "'" + payment.getId() + "',"
                        + "'" + payment.getAmount() + "',"
                        + "'" + payment.getPaymentMethod().getMethod() + "')";
                break;
            case "Cheque":
                Cheque cheque = (Cheque) payment.getPaymentMethod();
                query = "INSERT INTO payment(payment_id, amount, payment_method, bank, cheque_no) VALUES ("
                        + "'" + payment.getId() + "',"
                        + "'" + payment.getAmount() + "',"
                        + "'" + payment.getPaymentMethod().getMethod() + "',"
                        + "'" + cheque.getBank() + "',"
                        + "'" + cheque.getChequeNo() + "')";
                break;
            case "Debit":
                DebitCard debitCard = (DebitCard) payment.getPaymentMethod();
                query = "INSERT INTO payment(payment_id, amount, payment_method, bank, debit_card_no) VALUES ("
                        + "'" + payment.getId() + "',"
                        + "'" + payment.getAmount() + "',"
                        + "'" + payment.getPaymentMethod().getMethod() + "',"
                        + "'" + debitCard.getBank() + "',"
                        + "'" + debitCard.getDebitCardNo() + "')";
                break;
            case "Credit":
                CreditCard creditCard = (CreditCard) payment.getPaymentMethod();
                query = "INSERT INTO payment(payment_id, amount, payment_method, bank, credit_card_no) VALUES ("
                        + "'" + payment.getId() + "',"
                        + "'" + payment.getAmount() + "',"
                        + "'" + payment.getPaymentMethod().getMethod() + "',"
                        + "'" + creditCard.getBank() + "',"
                        + "'" + creditCard.getCreditCardNo() + "')";
                break;
        }

        c.setQuery(query);
    }

    public void newPayment(InvoicePayment payment) {
        switch (payment.getPaymentMethod().getMethod()) {
            case "Cash":
                query = "INSERT INTO payment(payment_id, amount, discount, amount_paid, payment_method) VALUES ("
                        + "'" + payment.getId() + "',"
                        + "'" + payment.getAmount() + "',"
                        + "'" + payment.getDiscount() + "',"
                        + "'" + payment.getAmountPaid() + "',"
                        + "'" + payment.getPaymentMethod().getMethod() + "')";
                break;
            case "Cheque":
                Cheque cheque = (Cheque) payment.getPaymentMethod();
                query = "INSERT INTO payment(payment_id, amount, discount, amount_paid, payment_method, bank, cheque_no) VALUES ("
                        + "'" + payment.getId() + "',"
                        + "'" + payment.getAmount() + "',"
                        + "'" + payment.getDiscount() + "',"
                        + "'" + payment.getAmountPaid() + "',"
                        + "'" + payment.getPaymentMethod().getMethod() + "',"
                        + "'" + cheque.getBank() + "',"
                        + "'" + cheque.getChequeNo() + "')";
                break;
            case "Debit":
                DebitCard debitCard = (DebitCard) payment.getPaymentMethod();
                query = "INSERT INTO payment(payment_id, amount, discount, amount_paid, payment_method, bank, debit_card_no) VALUES ("
                        + "'" + payment.getId() + "',"
                        + "'" + payment.getAmount() + "',"
                        + "'" + payment.getDiscount() + "',"
                        + "'" + payment.getAmountPaid() + "',"
                        + "'" + payment.getPaymentMethod().getMethod() + "',"
                        + "'" + debitCard.getBank() + "',"
                        + "'" + debitCard.getDebitCardNo() + "')";
                break;
            case "Credit":
                CreditCard creditCard = (CreditCard) payment.getPaymentMethod();
                query = "INSERT INTO payment(payment_id, amount, discount, amount_paid, payment_method, bank, credit_card_no) VALUES ("
                        + "'" + payment.getId() + "',"
                        + "'" + payment.getAmount() + "',"
                        + "'" + payment.getDiscount() + "',"
                        + "'" + payment.getAmountPaid() + "',"
                        + "'" + payment.getPaymentMethod().getMethod() + "',"
                        + "'" + creditCard.getBank() + "',"
                        + "'" + creditCard.getCreditCardNo() + "')";
                break;
        }

        c.setQuery(query);
    }

    public void newPayment(SRNPayment payment) {
        switch (payment.getPaymentMethod().getMethod()) {
            case "Cash":
                query = "INSERT INTO payment(payment_id, amount, payment_method) VALUES ("
                        + "'" + payment.getId() + "',"
                        + "'" + payment.getAmount() + "',"
                        + "'" + payment.getPaymentMethod().getMethod() + "')";
                break;
            case "Cheque":
                Cheque cheque = (Cheque) payment.getPaymentMethod();
                query = "INSERT INTO payment(payment_id, amount, payment_method, bank, cheque_no) VALUES ("
                        + "'" + payment.getId() + "',"
                        + "'" + payment.getAmount() + "',"
                        + "'" + payment.getPaymentMethod().getMethod() + "',"
                        + "'" + cheque.getBank() + "',"
                        + "'" + cheque.getChequeNo() + "')";
                break;
            case "Debit":
                DebitCard debitCard = (DebitCard) payment.getPaymentMethod();
                query = "INSERT INTO payment(payment_id, amount, payment_method, bank, debit_card_no) VALUES ("
                        + "'" + payment.getId() + "',"
                        + "'" + payment.getAmount() + "',"
                        + "'" + payment.getPaymentMethod().getMethod() + "',"
                        + "'" + debitCard.getBank() + "',"
                        + "'" + debitCard.getDebitCardNo() + "')";
                break;
            case "Credit":
                CreditCard creditCard = (CreditCard) payment.getPaymentMethod();
                query = "INSERT INTO payment(payment_id, amount, payment_method, bank, credit_card_no) VALUES ("
                        + "'" + payment.getId() + "',"
                        + "'" + payment.getAmount() + "',"
                        + "'" + payment.getPaymentMethod().getMethod() + "',"
                        + "'" + creditCard.getBank() + "',"
                        + "'" + creditCard.getCreditCardNo() + "')";
                break;
        }

        c.setQuery(query);
    }
}
