/*
 * Copyright © 02.10.2015 by O.I.Mudannayake. All Rights Reserved.
 */
package exception;

/**
 *
 * @author Ivantha
 */
public class ValueNotSelectedException extends Exception {

    public ValueNotSelectedException() {
    }

    public ValueNotSelectedException(String string) {
        super(string);
    }

    public ValueNotSelectedException(String string, Throwable thrwbl) {
        super(string, thrwbl);
    }

    public ValueNotSelectedException(Throwable thrwbl) {
        super(thrwbl);
    }

    public ValueNotSelectedException(String string, Throwable thrwbl, boolean bln, boolean bln1) {
        super(string, thrwbl, bln, bln1);
    }

}
