package com.ra.util;

import java.util.Date;

public class Generator {
    public static String genOrderId() {
        return "ODH" + DateUtil.dateToString(new Date(), "yyyyMMdd_HHmmss.SS");
    }
}
