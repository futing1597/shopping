package com.yyb.shopping.util;

import java.util.HashMap;
import java.util.Map;

public class ShoppingCharge {
    
    private static Map<String, Double> shopsMap = new HashMap<>();
    
    /**
     * 店庆
     */
    private static final int  ANNIVERSARY = 1;
    
    /**
     * 年中庆
     */
    private static final int  MIDDLE_YEAR = 2;
    
    public ShoppingCharge() {
        shopsMap.put("苹果", 3.5);
        shopsMap.put("香蕉", 2.5);
        shopsMap.put("火龙果", 10.5);
        shopsMap.put("西红柿", 1.5);
    }
    
    /**
     * 计算总价
     * 
     * @param consumeMap 购物车 key：商品名称 value：该商品数量
     * @param activityType 活动类型 0无活动 ，1店庆，2年中庆
     * @return 总价
     */
    public static double calConsume(Map<String, Integer> consumeMap, int activityType) {
        
        double total = 0;
        
        for (String shopsName : consumeMap.keySet()) {
            double price = shopsMap.get(shopsName);
            int num = consumeMap.get(shopsName);
            total += price * num;
        }
        
        if (ANNIVERSARY == activityType) {
            total *= 0.7;
        }
        if (MIDDLE_YEAR == activityType && total > 700) {
            total -= 200;
        }
        
        return total;
    }
    
    /**
     * 设置商品价格
     * 
     * @param shopName 商品名称
     * @param price 价格
     */
    public static void setPrice(String shopName, double price) {
        shopsMap.put(shopName, price);
    }
}
