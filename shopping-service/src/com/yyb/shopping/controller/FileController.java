package com.yyb.shopping.controller;

import java.io.File;
import java.io.IOException;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import com.yyb.shopping.service.FileService;
import com.yyb.shopping.util.CommonResult;
import com.yyb.shopping.util.UUIDUtil;

@Controller
@RequestMapping("/upload")
public class FileController {

    private Logger log = Logger.getLogger(FileController.class);
    
    @Autowired
    private FileService fileService;
    
    @ResponseBody
    @RequestMapping(value = "/fileUpload",method = RequestMethod.POST)
    public Map<String, Object> fileUpload(@RequestParam(value = "file", required = true) MultipartFile file, HttpServletRequest request) throws IllegalStateException, IOException {
        
        if (null == file) {
            return CommonResult.buildErrorResult("file not exist");
        }
        
        String fileName = file.getOriginalFilename();       
        String type = fileName.indexOf(".") != -1 ? fileName.substring(fileName.lastIndexOf(".") + 1, fileName.length()) : null;
        if (null == type) {
            return CommonResult.buildErrorResult("no ext");
        }
        
        if (!"GIF".equals(type.toUpperCase()) && !"PNG".equals(type.toUpperCase()) && !"JPG".equals(type.toUpperCase())) {
            return CommonResult.buildErrorResult("wrong ext");
        }

        StringBuilder sb = new StringBuilder();
        StringBuilder sbAbsolute = new StringBuilder();
        // Tomcat�\�и�·��
        String rootPath=request.getSession().getServletContext().getRealPath("/");
        String uuid = UUIDUtil.getUUID();
        
        sb.append(rootPath);
        sb.append("images").append(File.separator);
        sb.append(uuid).append("_").append(fileName);
        
        sbAbsolute.append(File.separator).append("images").append(File.separator);
        sbAbsolute.append(uuid).append("_").append(fileName);
        
        String destFilePath = sb.toString();
        String absoluteFilePath = sbAbsolute.toString();
        
        // 将图片传输到Tomcat服务器上
        file.transferTo(new File(destFilePath));
        log.info("图片传输地址: " + destFilePath);
        
        // �����ļ�ӳ��
        fileService.insertFile(fileName, uuid, absoluteFilePath);
        log.info("数据库保存图片地址: " + absoluteFilePath);
                    
        return CommonResult.buildResult(absoluteFilePath);
    }
    
}
