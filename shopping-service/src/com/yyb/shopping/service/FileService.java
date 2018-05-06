package com.yyb.shopping.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.yyb.shopping.dao.FileDao;

@Service
public class FileService {
    
    @Autowired
    private FileDao fileDao;
    
    public void insertFile(String srcFileName, String uuid, String filePath) {
        try {
            fileDao.insertFile(srcFileName, uuid, filePath);
        } catch (Exception e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }
}
