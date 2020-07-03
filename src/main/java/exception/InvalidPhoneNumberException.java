/*
 * Copyright © 02.10.2015 by O.I.Mudannayake. All Rights Reserved.
 */
package exception;

/**
 *
 * @author Ivantha
 */
public class InvalidPhoneNumberException extends Exception{

    public InvalidPhoneNumberException() {
    }

    public InvalidPhoneNumberException(String string) {
        super(string);
    }

    public InvalidPhoneNumberException(String string, Throwable thrwbl) {
        super(string, thrwbl);
    }

    public InvalidPhoneNumberException(Throwable thrwbl) {
        super(thrwbl);
    }

    public InvalidPhoneNumberException(String string, Throwable thrwbl, boolean bln, boolean bln1) {
        super(string, thrwbl, bln, bln1);
    }
    
}
