package com.yyb.shopping.model;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class MenuModel {
    
    private String id;
    
    private String is_leaf;
    
    private String name_zh_CN;
    
    private String parent_menu_id;
    
    private List<Map<String, Object>> childMenuList = new ArrayList<>();

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getIs_leaf() {
        return is_leaf;
    }

    public void setIs_leaf(String is_leaf) {
        this.is_leaf = is_leaf;
    }

    public String getName_zh_CN() {
        return name_zh_CN;
    }

    public void setName_zh_CN(String name_zh_CN) {
        this.name_zh_CN = name_zh_CN;
    }

    public String getParent_menu_id() {
        return parent_menu_id;
    }

    public void setParent_menu_id(String parent_menu_id) {
        this.parent_menu_id = parent_menu_id;
    }

    public List<Map<String, Object>> getChildMenuList() {
        return childMenuList;
    }

    public void addChildMenuList(List<Map<String, Object>> childMenuList) {
        this.childMenuList.addAll(childMenuList);
    }
    
}
