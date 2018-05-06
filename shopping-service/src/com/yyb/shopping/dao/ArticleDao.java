package com.yyb.shopping.dao;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;


@Repository
public interface ArticleDao {
    
    List<Map<String, Object>> searchArticleByLeafMenuId(@Param("leaf_menu_id") String leaf_menu_id) throws Exception;
    
    List<Map<String, Object>> searchContentByArticleId(@Param("article_id") String article_id) throws Exception;
    
    void insertArticle(@Param("leafMenuId")String leafMenuId, @Param("title")String title,
            @Param("index")String index, @Param("content")String content);
}
