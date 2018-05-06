package com.yyb.shopping.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.yyb.shopping.dao.MenuDao;
import com.yyb.shopping.model.MenuModel;

@Service
public class MenuService {
    
    @Autowired
    private MenuDao menuDao;
    
    public List<Map<String, Object>> searchAllRootMenu(){
        try {
            return menuDao.searchAllRootMenu();
        } catch (Exception e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        return null;
    }
    
    public List<Map<String, Object>> searchAllMenu() {
        try {
            return menuDao.searchAllMenu();
        } catch (Exception e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        return null;
    }
    
    public List<MenuModel> searchSecondMenu() {
        
        List<MenuModel> menuModels = new ArrayList<>();
        try {
            
            List<Map<String, Object>> rootMenuList = searchAllRootMenu();
            for (Map<String, Object> rootMenu : rootMenuList) {
                String id = rootMenu.get("id").toString();
                String is_leaf = rootMenu.get("is_leaf").toString();
                String name_zh_CN = rootMenu.get("name_zh_CN").toString();
                String parent_menu_id = rootMenu.get("parent_menu_id").toString();
                
                List<Map<String, Object>> childMenuList = menuDao.searchMenuChildListById(id);
                MenuModel model = new MenuModel();
                menuModels.add(model);
                model.addChildMenuList(childMenuList);
                model.setId(id);
                model.setIs_leaf(is_leaf);
                model.setName_zh_CN(name_zh_CN);
                model.setParent_menu_id(parent_menu_id);
                
            }
            
            return menuModels;
        } catch (Exception e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        return null;
    }
    
    public List<Map<String, Object>> searchMenuChildListById(String menuId) {
        try {
            return menuDao.searchMenuChildListById(menuId);
        } catch (Exception e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        return null;
    }
    
    public List<Map<String, Object>> searchAllMenuChildListById(String menuId) {
        try {
            return menuDao.searchAllMenuChildListById(menuId);
        } catch (Exception e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        return null;
    }
    
    public List<MenuModel> search23MenuByFirstMenuId(String firstMenuId) {
        
        List<MenuModel> menuModels = new ArrayList<>();
        
        try {
            
            List<Map<String, Object>> second = menuDao.searchMenuChildListById(firstMenuId);
            for (Map<String, Object> secondMenu : second) {
                String id = secondMenu.get("id").toString();
                String is_leaf = secondMenu.get("is_leaf").toString();
                String name_zh_CN = secondMenu.get("name_zh_CN").toString();
                String parent_menu_id = secondMenu.get("parent_menu_id").toString();
                
                List<Map<String, Object>> childMenuList = menuDao.searchMenuChildListById(id);
                MenuModel model = new MenuModel();
                menuModels.add(model);
                model.addChildMenuList(childMenuList);
                model.setId(id);
                model.setIs_leaf(is_leaf);
                model.setName_zh_CN(name_zh_CN);
                model.setParent_menu_id(parent_menu_id);
            }
         
            return menuModels;
        } catch (Exception e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        return null;
    }
    
}
