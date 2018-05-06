package com.yyb.shopping.util;

import java.io.Closeable;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Properties;

import org.apache.log4j.Logger;

/**
 * 获取资源文件内容
 * 
 * @author Raytine
 * @date 2017年9月23日
 */
public class ResourceManager {
    
    private static Logger logger = Logger.getLogger(ResourceManager.class);
    
    private static Properties enProperties;
    
    private static Properties zhProperties;
    
    static {
        
        ResourceManager.class.getResource(File.separator);
        
        enProperties = new Properties();
        zhProperties = new Properties();
        
        FileInputStream fisEn = null;
        FileInputStream fisZh = null;
        InputStreamReader isrZh = null;
        
        try {
            
            String classpath = ResourceManager.class.getResource("/").getPath();
            
            
            
            fisEn = new FileInputStream(classpath + "config_en_US.properties");
            fisZh = new FileInputStream(classpath + "config_zh_CN.properties");
            isrZh = new InputStreamReader(fisZh, "UTF-8");
            
            enProperties.load(fisEn);
            zhProperties.load(isrZh);
            
        } catch (Exception e) {
            logger.error("load resource error: ", e);
        } finally {
            closeStream(fisEn);
            closeStream(isrZh);
            closeStream(fisZh);
        }
        
    }
    
    /**
     * 获取英文资源
     * 
     * @param key 资源的key
     * @return 英文资源
     */
    public static String getEn(String key) {
        return enProperties.getProperty(key);
    }
    
    /**
     * 获取中文资源
     * 
     * @param key 中文资源key
     * @return 中文资源
     */
    public static String getZh(String key) {
        return zhProperties.getProperty(key);
    }
    
    public static void closeStream(Closeable stream) {
        
        if (null != stream) {
            try {
                stream.close();
            } catch (IOException e) {
                logger.error("close stream error: ", e);
            }
        }
        
    }
    
}
