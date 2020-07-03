/*
 * Copyright © 02.10.2015 by O.I.Mudannayake. All Rights Reserved.
 */
package exception;

/**
 *
 * @author Ivantha
 */
public class JobRoleNotFoundException extends Exception{

    public JobRoleNotFoundException() {
    }

    public JobRoleNotFoundException(String message) {
        super(message);
    }

    public JobRoleNotFoundException(String message, Throwable cause) {
        super(message, cause);
    }

    public JobRoleNotFoundException(Throwable cause) {
        super(cause);
    }

    public JobRoleNotFoundException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
    
}
