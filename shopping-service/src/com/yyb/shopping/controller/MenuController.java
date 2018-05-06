package com.yyb.shopping.controller;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.yyb.shopping.model.MenuModel;
import com.yyb.shopping.service.MenuService;

@RequestMapping("/menu")
@Controller
public class MenuController {
    
    @Autowired
    private MenuService menuService;
    
    @RequestMapping(value="/searchAllMenu", method = RequestMethod.GET)
    @ResponseBody
    public List<Map<String, Object>> searchAllMenu() {
        return menuService.searchAllMenu();
    }
    
    @RequestMapping(value="/searchAllRootMenu", method = RequestMethod.GET)
    @ResponseBody
    public List<Map<String, Object>> searchAllRootMenu() {
        return menuService.searchAllRootMenu();
    }
    
    @RequestMapping(value="/searchSecondMenu", method = RequestMethod.GET)
    @ResponseBody
    public List<MenuModel> searchSecondMenu() {
        return menuService.searchSecondMenu();
    }
    
    @RequestMapping(value="/searchMenuChildListByParentId", method = RequestMethod.GET)
    @ResponseBody
    public List<Map<String, Object>> searchMenuChildListByParentId(String parentMenuId) {
        return menuService.searchMenuChildListById(parentMenuId);
    }
    
    @RequestMapping(value="/searchAllMenuChildListById", method = RequestMethod.GET)
    @ResponseBody
    public List<Map<String, Object>> searchAllMenuChildListById(String menuId) {
        return menuService.searchAllMenuChildListById(menuId);
    }
    
    @RequestMapping(value="/search23MenuByFirstMenuId", method = RequestMethod.GET)
    @ResponseBody
    public List<MenuModel> search23MenuByFirstMenuId(String firstMenuId) {
        return menuService.search23MenuByFirstMenuId(firstMenuId);
    }
}
