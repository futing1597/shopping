package com.yyb.shopping.util;

import java.util.HashMap;
import java.util.Map;

import com.yyb.shopping.constant.Constant;

public class CommonResult {
    
    public static Map<String, Object> buildErrorResult(String errorMsg) {
        
        Map<String, Object> map = new HashMap<>();
        map.put(Constant.IS_SUCCESS, Boolean.FALSE);
        map.put(Constant.ERR_MSG, errorMsg);
        
        System.out.println(errorMsg);
        
        return map;
    }
    
    public static Map<String, Object> buildResult(String result) {
        
        Map<String, Object> map = new HashMap<>();
        map.put(Constant.IS_SUCCESS, Boolean.TRUE);
        map.put(Constant.RESULT, result);
        
        return map;
    } 
}
