package com.yyb.shopping.util;

public class Bodyrendering {
    
    /**
     * ��������ͼ��
     * 
     * @param head ͷ 1 ������2 ��
     * @param body ���� 1 ���֣�2����
     * @param arm �첲  �� 1�� 2 ϸ
     * @param leg �� 1 ����2 ��
     * @return �˵�ͼ��
     */
    public static String bodyrendering(int head, int body, int arm, int leg) {
        
        StringBuilder sb = new StringBuilder();
        if (1 == head) {
            sb.append("����");
        } else {
            sb.append("��");
        }
        
        if (1 == body) {
            sb.append("����");
        } else {
            sb.append("����");
        }
        
        if (1 == arm) {
            sb.append("ǿ׳");
        } else {
            sb.append("��ǿ׳");
        }
        
        if (1 == leg) {
            sb.append("�ߴ�");
        } else {
            sb.append("��С");
        }
        
        return sb.toString();
    }
}
