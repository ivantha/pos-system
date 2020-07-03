/*
 * Copyright © 02.10.2015 by O.I.Mudannayake. All Rights Reserved.
 */
package exception;

/**
 *
 * @author Ivantha
 */
public class EmptyStringException extends Exception{

    public EmptyStringException() {
    }

    public EmptyStringException(String message) {
        super(message);
    }

    public EmptyStringException(String message, Throwable cause) {
        super(message, cause);
    }

    public EmptyStringException(Throwable cause) {
        super(cause);
    }

    public EmptyStringException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
    
}
