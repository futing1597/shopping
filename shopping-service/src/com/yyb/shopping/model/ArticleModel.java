package com.yyb.shopping.model;

import java.util.List;
import java.util.Map;

public class ArticleModel {
    
    private String id;
    
    private String leaf_menu_id;
    
    private String title;
    
    private String article_index;
    
    private List<Map<String, Object>> articleContent;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getLeaf_menu_id() {
        return leaf_menu_id;
    }

    public void setLeaf_menu_id(String leaf_menu_id) {
        this.leaf_menu_id = leaf_menu_id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getArticle_index() {
        return article_index;
    }

    public void setArticle_index(String article_index) {
        this.article_index = article_index;
    }

    public List<Map<String, Object>> getArticleContent() {
        return articleContent;
    }

    public void setArticleContent(List<Map<String, Object>> articleContent) {
        this.articleContent = articleContent;
    }
    
}
