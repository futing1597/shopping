package com.yyb.shopping.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.yyb.shopping.dao.UserDao;
import com.yyb.shopping.model.UserModel;


@Service
public class UserService {
    
    @Autowired
    private UserDao userDao;
    
    @Transactional
    public void addUser(UserModel userModel) {
        userDao.addUser(userModel);
    }
}
