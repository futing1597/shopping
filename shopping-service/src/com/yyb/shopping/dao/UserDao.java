package com.yyb.shopping.dao;

import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import com.yyb.shopping.model.UserModel;

@Repository
public interface UserDao {
    
    int addUser(@Param("userModel")UserModel userModel);
}
