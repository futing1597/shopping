package com.yyb.shopping.test;

import java.io.File;
import java.util.Map;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.yyb.shopping.dao.ArticleDao;
import com.yyb.shopping.dao.FileDao;
import com.yyb.shopping.dao.MenuDao;
import com.yyb.shopping.dao.UserDao;
import com.yyb.shopping.model.UserModel;

import javassist.compiler.ast.NewExpr;

@RunWith(SpringJUnit4ClassRunner.class)    
@ContextConfiguration(locations={"classpath:spring-mybatis.xml"})  
public class UserTest {
    
    @Autowired
    private MenuDao userDao;
    
    @Autowired
    private ArticleDao articleDao;
    
    @Autowired
    private ArticleDao menuDao;
    
    @Autowired
    private FileDao fileDao;
    
    @Autowired
    private UserDao userDao1;
    
    @Test
    public void addUser() {
        try {
           UserModel userModel =  new UserModel();
           userModel.setUserName("aaa");
           userModel.setPassword("bbb");
           userModel.setEmail("aaa");
           userModel.setPwdNo("1");
           userModel.setPwdAnswer("222");
           userModel.setRole("1");
           userModel.setTel("12345");
           
           int result = userDao1.addUser(userModel);
           
           System.out.println(result);
           
        } catch (Exception e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }
    
    @Test
    public void mkdir() {
        
        try {
            
            for (Map<String, Object> m : userDao.searchAllRootMenu()) {
                String id = m.get("id").toString();
                
                new File("D://config//menu_" + id).mkdir();
                
                for (Map<String, Object> m1 : userDao.searchMenuChildListById(id)) {
                    String id1 = m1.get("id").toString();
                    new File("D://config//menu_" + id + "//menu_" + id1).mkdir();
                    
                    for (Map<String, Object> m2 : userDao.searchMenuChildListById(id1)) {
                        String id2 = m2.get("id").toString();
                        new File("D://config//menu_" + id + "//menu_" + id1 + "//menu_" + id2).mkdir();
                        
                        
                    }
                }
                
            }
            
        } catch (Exception e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }
}
