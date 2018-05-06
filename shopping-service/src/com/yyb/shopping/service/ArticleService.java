package com.yyb.shopping.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.yyb.shopping.dao.ArticleDao;
import com.yyb.shopping.model.ArticleModel;

@Service
public class ArticleService {
    
    @Autowired
    private ArticleDao articleDao;
    
    public List<ArticleModel> searchArticleByLeafMenuId(String leaf_menu_id) {
        
        List<ArticleModel> aiticleModels = new ArrayList<>();
        
        try {
            
            List<Map<String, Object>> articleList = articleDao.searchArticleByLeafMenuId(leaf_menu_id);
            for (Map<String, Object> article : articleList) {
                String id = article.get("id").toString();
                String title = article.get("title").toString();
                String article_index = article.get("article_index").toString();
                
                ArticleModel articleModel = new ArticleModel();
                articleModel.setId(id);
                articleModel.setArticle_index(article_index);
                articleModel.setLeaf_menu_id(leaf_menu_id);
                articleModel.setTitle(title);                
                articleModel.setArticleContent(articleDao.searchContentByArticleId(id));
                
                aiticleModels.add(articleModel);
            }
            
            
            
            return aiticleModels;
        } catch (Exception e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        return null;
    }
    
    public Map<String, Object> searchArticleByLeafMenuIdNew(String leaf_menu_id, int index) {
        
        try {
            return articleDao.searchArticleByLeafMenuId(leaf_menu_id).get(index);
        } catch (Exception e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        
        return null;
    }
    
    public void insertArticle(String leafMenuId, String title, String index, String content) {
        articleDao.insertArticle(leafMenuId, title, index, content);
    }
}
