/*
 * Copyright © 02.10.2015 by O.I.Mudannayake. All Rights Reserved.
 */
package main.support;

import exception.EmptyStringException;
import exception.InvalidPhoneNumberException;
import exception.InvalidNumberException;
import ui.support.Info;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 *
 * @author Ivantha
 */
public class Input {

    public static String checkIfEmptyString(String phrase, String info) throws EmptyStringException {
        Pattern p = Pattern.compile("([^\\s])+?");
        Matcher m = p.matcher(phrase);
        if (m.find()) {
            return phrase.trim();
        } else {
            Info.error("Incorrect input", info);
            throw new EmptyStringException();
        }
    }

    public static String checkIfValidTelephone(String phrase, String info) throws InvalidPhoneNumberException {
        Pattern p = Pattern.compile("\\d\\d\\d\\d\\d\\d\\d\\d\\d\\d");
        Matcher m = p.matcher(phrase);
        if (m.find() && phrase.length() == 10) {
            return phrase.trim();
        } else {
            Info.error("Incorrect input", info);
            throw new InvalidPhoneNumberException();
        }
    }

    public static double checkIfValidNumber(Object phrase, String info) throws InvalidNumberException {
        try {
            return Double.parseDouble((String) phrase);
        } catch (NumberFormatException | NullPointerException  ex) {
            Info.error("Incorrect input", info);
            throw new InvalidNumberException();
        }
    }

    /*public static String verifyInput(String phrase, String regex, String information) {
        Pattern p = Pattern.compile(regex);
        Matcher m = p.matcher(phrase);
        if (m.find()) {
            return phrase.trim();
        } else {
            Info.error("Incorrect input", information);
            return null;
        }
    }*/

 /*public static boolean notNull(Object... arguement) {
        for (Object a : arguement) {
            if (a == null) {
                return false;
            }
        }
        return true;

    /*public static String verifyInput(String phrase, String regex, String information) {
        Pattern p = Pattern.compile(regex);
        Matcher m = p.matcher(phrase);
        if (m.find()) {
            return phrase.trim();
        } else {
            Info.error("Incorrect input", information);
            return null;
        }
    }*/

 /*public static boolean notNull(Object... arguement) {
        for (Object a : arguement) {
            if (a == null) {
                return false;
            }
        }
        return true;
    }*/
}
