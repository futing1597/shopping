package com.yyb.shopping.model;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


/**
 * ǰ�ε��÷��ؽ��
 * 
 * @author Raytine
 * @date 2017��3��19��
 * @param <T>
 */
public class Result<T> {
    
    /**
     * �Ƿ�ɹ��� true���ɹ���false��ʧ��
     */
    private boolean success = false;
    
    /**
     * ʧ��ԭ������ɹ����ÿ�
     */
    private String errorMsg = "";
    
    /**
     * ���صľ���ֵ������ֵ��ʽ��
     */
    private T result;
    
    /**
     * ����һ�����ݶ��ֵ����ʽ
     */
    private Map<String, Object> resultMap = new HashMap<String, Object>();
    
    /**
     * �����б���ʽ
     */
    private List<T> resultList = new ArrayList<>();

    public boolean isSuccess() {
        return success;
    }

    public void setSuccess(boolean success) {
        this.success = success;
    }

    public String getErrorMsg() {
        return errorMsg;
    }

    public void setErrorMsg(String errorMsg) {
        this.errorMsg = errorMsg;
    }

    public T getResult() {
        return result;
    }

    public void setResult(T result) {
        this.result = result;
    }

    public Map<String, Object> getResultMap() {
        return resultMap;
    }

    public void setResultMap(Map<String, Object> resultMap) {
        this.resultMap = resultMap;
    }

    public List<T> getResultList() {
        return resultList;
    }

    public void setResultList(List<T> resultList) {
        this.resultList = resultList;
    }
    
}
