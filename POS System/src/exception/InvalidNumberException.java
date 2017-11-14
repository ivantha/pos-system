/*
 * Copyright © 02.10.2015 by O.I.Mudannayake. All Rights Reserved.
 */
package exception;

/**
 *
 * @author Ivantha
 */
public class InvalidNumberException extends Exception {

    public InvalidNumberException() {
    }

    public InvalidNumberException(String string) {
        super(string);
    }

    public InvalidNumberException(String string, Throwable thrwbl) {
        super(string, thrwbl);
    }

    public InvalidNumberException(Throwable thrwbl) {
        super(thrwbl);
    }

    public InvalidNumberException(String string, Throwable thrwbl, boolean bln, boolean bln1) {
        super(string, thrwbl, bln, bln1);
    }

}
