package com.ra.util;

import java.text.SimpleDateFormat;
import java.util.Date;

public class DateUtil {
    public static String dateToString(Date date, String format) {
        SimpleDateFormat fmt = new SimpleDateFormat(format);
        return  fmt.format(date);
    }
}
