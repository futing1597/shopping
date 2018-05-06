package com.yyb.shopping.controller;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.mangofactory.swagger.models.dto.Model;
import com.wordnik.swagger.annotations.Api;
import com.wordnik.swagger.annotations.ApiModel;
import com.wordnik.swagger.annotations.ApiOperation;
import com.wordnik.swagger.annotations.ApiParam;
import com.yyb.shopping.model.UserModel;
import com.yyb.shopping.service.UserService;
import com.yyb.shopping.util.ResourceManager;


@RestController
@RequestMapping("/user")
@Api(value = "/user", description = "Operations about user")
public class UserCtrl {
    
    private static String OK = "0";
    
    private Logger logger = Logger.getLogger(UserCtrl.class);
    
    @Autowired
    private UserService userService;

    /*
     * @ApiOperation(value = "接口说明", httpMethod ="接口请求方式", response ="接口返回参数类型", notes ="接口发布说明"
     * 
     * @ApiParam(required = "是否必须参数", name ="参数名称", value ="参数具体描述"
     */
    @RequestMapping(value = "/test", method= RequestMethod.POST)
    @ApiOperation(value="接口说明(测试)",httpMethod="GET",notes="在没有会话、没有签名的情况下，进入方法体")
    public void test(HttpServletRequest request, HttpServletResponse response, Model model) {
        try {
            response.getWriter().write("ignoreAll");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    
    @ApiOperation(value = "添加用户", httpMethod = "POST", response = HashMap.class, notes = "add user")
    @RequestMapping(value="/addUser", method = RequestMethod.POST, produces = "application/json;charset=utf-8")
    public Map<String, Object> addUser(@RequestBody UserModel userModel) {
        
        String checkUserResult = checkUserName(userModel.getUserName());
        if (!OK.equals(checkUserResult)) {
            errorReturn(checkUserResult);
        }
        
        String checkPwdResult = checkPwd(userModel.getPassword());
        if (!OK.equals(checkPwdResult)) {
            errorReturn(checkPwdResult);
        }
        
        String checkEmailResult = checkEmail(userModel.getEmail());
        if (!OK.equals(checkEmailResult)) {
            errorReturn(checkEmailResult);
        }
        
        String checkRoleResult = checkRole(userModel.getRole());
        if (!OK.equals(checkRoleResult)) {
            errorReturn(checkRoleResult);
        }
        
        String checkTelResult = checkTel(userModel.getTel());
        if (!OK.equals(checkTelResult)) {
            errorReturn(checkTelResult);
        }
        
        String checkPwdNoResult = checkPwdNo(userModel.getPwdNo());
        if (!OK.equals(checkPwdNoResult)) {
            errorReturn(checkPwdNoResult);
        }
        
        String checkPwdAnswerResult = checkAnswer(userModel.getPwdAnswer());
        if (!OK.equals(checkPwdAnswerResult)) {
            errorReturn(checkPwdAnswerResult);
        }
        
        //int addResult = userService.addUser(userModel);
        
        return null;
    }
    
    
    
    /**
     * 用户名只能包含字母数字下划线：长度5-15
     * 
     * @param userName 待校验的用户名
     * @return 校验结果
     */
    private String checkUserName(String userName) {
        
        String baseKey = "userName";
        
        if (null == userName || "".equals(userName)) {
            
            // 用户名不能为空
            return baseKey + 1;
        }
        
        if (!userName.matches("[a-zA-Z0-9_]+")) {
            
            // 用户名只能包含字母、数字、下划线
            return baseKey + 2;
        }
        
        if (!checkLength(userName, 5, 15)) {
            
         // 用户名长度为5-15
            return baseKey + 3;
        }
        
        return OK;
    }
    
    /**
     * 密码必须包含字母、数字、特殊字符*[!@#$%^&*()\\-_+={}\\[\\]:;\"'<>,.?/].*：长度6-12
     * 
     * @param userName 待校验的密码
     * @return 校验结果
     */
    private String checkPwd(String pwd) {
        
        String baseKey = "password";
        
        if (null == pwd || "".equals(pwd)) {
            
            // 密码不能为空
            return baseKey + 1;
        }
        
        if (!checkLength(pwd, 6, 12)) {
            
               // 密码长度为6-12
               return baseKey + 2;
       }
        
        if (!pwd.matches(".*[0-9].*") || !pwd.matches(".*[a-zA-Z].*") || !pwd.matches(".*[!@#$%^&*()\\-_+={}\\[\\]:;\"'<>,.?/].*")) {
            
            // 密码必须包含字母、数字、特殊字符*[!@#$%^&*()\\-_+={}\\[\\]:;\"'<>,.?/].*
            return baseKey + 3;
        }
        
        return OK;
    }
    
    /**
     * 校验邮箱
     * 
     * @param userName 待校验的邮箱
     * @return 校验结果
     */
    private String checkEmail(String email) {
        
        String baseKey = "email";
        
        if (null == email || "".equals(email)) {
            
            // 邮箱允许为空
            return OK;
        }
        
        if (!email.matches("^[a-z0-9]+([._\\-]*[a-z0-9])*@([a-z0-9]+[-a-z0-9]*[a-z0-9]+.){1,63}[a-z0-9]+$")) {
            
            // 密码必须包含字母、数字、特殊字符*[!@#$%^&*()\\-_+={}\\[\\]:;\"'<>,.?/].*
            return baseKey;
        }
        
        return OK;
    }
    
    /**
     * 校验角色
     * 
     * @param userName 待校验的角色
     * @return 校验结果
     */
    private String checkRole(String role) {
        
        String baseKey = "role";
        
        if (null == role || "".equals(role)) {
            
            // 角色不能为空
            return baseKey + 1;
        }
        
        if (!role.matches("[0-9]{1,2}")) {
            
            // 角色必须为1-2位数字
            return baseKey + 2;
        }
        
        return OK;
    }
    
    /**
     * 校验电话
     * 
     * @param userName 待校验的电话
     * @return 校验结果
     */
    private String checkTel(String tel) {
        
        String baseKey = "tel";
        
        if (null == tel || "".equals(tel)) {
            
            // 角色不能为空
            return OK;
        }
        
        if (!tel.matches("[0-9]{11}")) {
            
            // 角色必须为1-2位数字
            return baseKey + 1;
        }
        
        return OK;
    }
    
    /**
     * 校验密保问题
     * 
     * @param userName 待校验的密保问题
     * @return 校验结果
     */
    private String checkPwdNo(String pwdNo) {
        
        String baseKey = "pwdNo";
        
        if (null == pwdNo || "".equals(pwdNo)) {
            
            // 角色不能为空
            return baseKey + 1;
        }
        
        if (!pwdNo.matches("[0-9]{11}")) {
            
            // 密保问题必须为1-2位数字
            return baseKey + 2;
        }
        
        return OK;
    }
    
    /**
     * 校验密保答案
     * 
     * @param userName 待校验的密保答案
     * @return 校验结果
     */
    private String checkAnswer(String answer) {
        
        String baseKey = "answer";
        
        if (null == answer || "".equals(answer)) {
            
            // 密保答案不能为空
            return baseKey + 1;
        }
        
        if (!checkLength(answer, 2, 255)) {
            
            // 密保答案长度为2-255
            return baseKey + 2;
        }
        
        return OK;
    }
    
    private Map<String, Object> errorReturn(String key) {
        
        String errorMsg = ResourceManager.getZh(key);
        
        logger.info(errorMsg);
        
        Map<String, Object> result = new HashMap<>();
        result.put("isSuccess", Boolean.FALSE);
        result.put("errorMsg", errorMsg);
        
        return result;
    }
    
    /**
     * 校验字符串的长度
     * 
     * @param str 待检验的字符串
     * @param min 最小长度
     * @param max 最大长度
     * @return true 符合  false 不符合
     */
    private boolean checkLength(String str, int min, int max) {
        
        int len = str.length();
        
        return len >= min && len <= max;
        
    }
    
    public static void main(String[] args) {
        System.out.println("1111111111".matches("[0-9]{11}"));
    }
}
