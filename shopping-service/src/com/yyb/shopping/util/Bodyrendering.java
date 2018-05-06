package com.yyb.shopping.util;

public class Bodyrendering {
    
    /**
     * 绘制人体图像
     * 
     * @param head 头 1 聪明，2 笨
     * @param body 身子 1 肥胖，2消瘦
     * @param arm 胳膊  粗 1， 2 细
     * @param leg 腿 1 长，2 短
     * @return 人的图像
     */
    public static String bodyrendering(int head, int body, int arm, int leg) {
        
        StringBuilder sb = new StringBuilder();
        if (1 == head) {
            sb.append("聪明");
        } else {
            sb.append("笨");
        }
        
        if (1 == body) {
            sb.append("肥胖");
        } else {
            sb.append("消瘦");
        }
        
        if (1 == arm) {
            sb.append("强壮");
        } else {
            sb.append("不强壮");
        }
        
        if (1 == leg) {
            sb.append("高大");
        } else {
            sb.append("矮小");
        }
        
        return sb.toString();
    }
}
