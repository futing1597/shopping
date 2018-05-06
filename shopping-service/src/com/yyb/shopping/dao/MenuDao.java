package com.yyb.shopping.dao;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;


@Repository
public interface MenuDao {
    
    List<Map<String, Object>> searchAllMenu() throws Exception;
    
    List<Map<String, Object>> searchAllRootMenu() throws Exception;
    
    List<Map<String, Object>> searchMenuChildListById(@Param("menuId") String menuId) throws Exception;
    
    List<Map<String, Object>> searchAllMenuChildListById(@Param("menuId") String menuId) throws Exception;
    
}
