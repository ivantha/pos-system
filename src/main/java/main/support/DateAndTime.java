/*
 * Copyright © 02.10.2015 by O.I.Mudannayake. All Rights Reserved.
 */
package main.support;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.TimeZone;

/**
 *
 * @author Ivantha
 */
public class DateAndTime {
    private static final Calendar calendar = Calendar.getInstance(TimeZone.getDefault());
    private static Date date;
    private static final DateFormat df = new SimpleDateFormat("dd-MM-yyyy");
 
    public static String getDate(){
        date = calendar.getTime();
        return df.format(date);
    }
    
    public static String getDate(Date d){
        return df.format(d);
    }
}
