package com.yyb.shopping.util;

import java.util.HashMap;
import java.util.Map;

public class ShoppingCharge {
    
    private static Map<String, Double> shopsMap = new HashMap<>();
    
    /**
     * ����
     */
    private static final int  ANNIVERSARY = 1;
    
    /**
     * ������
     */
    private static final int  MIDDLE_YEAR = 2;
    
    public ShoppingCharge() {
        shopsMap.put("ƻ��", 3.5);
        shopsMap.put("�㽶", 2.5);
        shopsMap.put("������", 10.5);
        shopsMap.put("������", 1.5);
    }
    
    /**
     * �����ܼ�
     * 
     * @param consumeMap ���ﳵ key����Ʒ���� value������Ʒ����
     * @param activityType ����� 0�޻ ��1���죬2������
     * @return �ܼ�
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
     * ������Ʒ�۸�
     * 
     * @param shopName ��Ʒ����
     * @param price �۸�
     */
    public static void setPrice(String shopName, double price) {
        shopsMap.put(shopName, price);
    }
}
