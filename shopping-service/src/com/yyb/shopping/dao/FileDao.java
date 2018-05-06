package com.yyb.shopping.dao;

import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;


@Repository
public interface FileDao {
    
    void insertFile(@Param("srcFileName") String srcFileName, 
            @Param("uuidName") String uuid, @Param("filePath") String filePath) throws Exception;
    
}
