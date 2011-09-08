/*
 . * File name£ºLog.java
 . * Copyright£ºCopyright 2011-2013 Huawei Tech. Co. Ltd. All Rights Reserved.
 . * Description£º
 . * Author£ºhuangshan
 . * Change date£º2011-9-2
 . * Tracking form ID£º
 . * Change request ID£º
 . * Change content£º
 */
package com.habzy.log;

import java.util.Calendar;
import java.util.Date;

/**
 * One sentence description
 * Detailed description
 * @author Habzy
 * @version [version, 2011-9-2]
 * @see [relevant class/method]
 * @since [product/module version] 
 */
public class Log
{
    private static Calendar sCalendar = Calendar.getInstance();
    
    public static void log(String TAG,String message)
    {
        System.out.println(currentTimestamp()+" -- "+TAG+" : "+message);
    }
    
    private static String currentTimestamp()
    {
        // Add the TIMESTAMP field of the HEADER
        // Time format is "Mmm dd hh:mm:ss". For more info see rfc3164.
        
        long currentTime = System.currentTimeMillis();
        sCalendar.setTime(new Date(currentTime));
        
        String str = "";
        str += sCalendar.get(Calendar.YEAR) + "-";
        
        final int month = sCalendar.get(Calendar.MONTH) + 1;
        if (month < 10)
        {
            str += 0;
        }
        str += month + "-";
        
        final int day = sCalendar.get(Calendar.DAY_OF_MONTH);
        if (day < 10)
        {
            str += 0;
        }
        str += day;
        
        str += "T";
        
        final int hour = sCalendar.get(Calendar.HOUR_OF_DAY);
        if (hour < 10)
        {
            str += 0;
        }
        str += hour + ":";
        
        final int minute = sCalendar.get(Calendar.MINUTE);
        if (minute < 10)
        {
            str += 0;
        }
        str += minute + ":";
        
        final int second = sCalendar.get(Calendar.SECOND);
        if (second < 10)
        {
            str += 0;
        }
        str += second + ".";
        
        final int milli = sCalendar.get(Calendar.MILLISECOND);
        str += milli;
        
        str += "Z";
        
        return str;
    }
}
