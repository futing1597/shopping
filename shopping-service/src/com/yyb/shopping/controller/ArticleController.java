package com.yyb.shopping.controller;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.yyb.shopping.service.ArticleService;
import com.yyb.shopping.util.CommonResult;

@Controller
@RequestMapping("/article")
public class ArticleController {
    
    @Autowired
    private ArticleService articleService;
    
    @RequestMapping(value="/searchArticleByLeafMenuId", method = RequestMethod.GET)
    @ResponseBody
    public Map<String, Object> searchArticleByLeafMenuId(String leafMenuId, int index) {
        return articleService.searchArticleByLeafMenuIdNew(leafMenuId, index);
    }
    
    /**
     * 插入文章
     * 
     * @param articleContent 文章內容
     * @param leafMenuId 叶子结点ID
     * @param index 文章所属叶子结点的顺序
     * @param title 文章标题
     * @return 插入状态
     */
    @RequestMapping(value="/insertArticle", method = RequestMethod.POST)
    @ResponseBody
    public Map<String, Object> insertArticle(@RequestBody Map<String, String> paramMap) {
        
        String leafMenuId = paramMap.get("leafMenuId");
        String title = paramMap.get("title");
        String index = paramMap.get("index");
        String articleContent = paramMap.get("articleContent");
        
        articleService.insertArticle(leafMenuId, title, index, articleContent);
        
        return CommonResult.buildResult("");
    }
    
}
