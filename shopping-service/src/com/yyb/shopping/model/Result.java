package com.yyb.shopping.model;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


/**
 * 前段调用返回结果
 * 
 * @author Raytine
 * @date 2017年3月19日
 * @param <T>
 */
public class Result<T> {
    
    /**
     * 是否成功， true：成功，false：失败
     */
    private boolean success = false;
    
    /**
     * 失败原因，如果成功，置空
     */
    private String errorMsg = "";
    
    /**
     * 返回的具体值（单个值形式）
     */
    private T result;
    
    /**
     * 返回一条数据多个值的形式
     */
    private Map<String, Object> resultMap = new HashMap<String, Object>();
    
    /**
     * 返回列表形式
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
