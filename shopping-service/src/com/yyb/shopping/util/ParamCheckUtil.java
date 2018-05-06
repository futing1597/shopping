package com.yyb.shopping.util;

public class ParamCheckUtil {
    
    public static boolean checkLength(int max, String str) {
        return checkLength(0, max, str);
    }
    
    public static boolean checkLength(int min, int max, String str) {
        
        if (null == str || "".equals(str)) {
            return false;
        }
        
        int len = str.length();
        
        return len > min && len <= max;
    }
    
}
