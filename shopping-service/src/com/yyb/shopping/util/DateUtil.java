package com.yyb.shopping.util;

import java.text.SimpleDateFormat;
import java.util.Date;

public class DateUtil {
    
    public static String PATTERN1 = "yyyy-MM-dd";
    
    public static String getCurrDay(String pattern) {
        return new SimpleDateFormat().format(new Date());
    }
    
}
