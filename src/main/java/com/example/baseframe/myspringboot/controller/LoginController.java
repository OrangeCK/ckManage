package com.example.baseframe.myspringboot.controller;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.example.baseframe.myspringboot.domain.Employee;
import com.example.baseframe.myspringboot.domain.ResultData;
import com.example.baseframe.myspringboot.jwt.JwtUtil;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.IncorrectCredentialsException;
import org.apache.shiro.authc.UnknownAccountException;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.subject.Subject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * @author 01378803
 * @date 2018/11/8 9:37
 * Description  :
 */
@RestController
@RequestMapping("/login")
public class LoginController {
    private final static Logger logger = LoggerFactory.getLogger(LoginController.class);

    @RequestMapping(value = "/login", method = RequestMethod.POST)
    public ResultData login(@RequestBody String jsonStr){
        JSONObject jsonObject = JSON.parseObject(jsonStr);
        String loginName = jsonObject.getString("loginName");
        String password = jsonObject.getString("password");

        // 创建用户名和密码的令牌
//        UsernamePasswordToken token = new UsernamePasswordToken(loginName, password);
        String token = JwtUtil.sign(loginName, password);
//        response.setHeader();
        // subject理解为用户对象
//        Subject subject = SecurityUtils.getSubject();
//        ResultData resultData = new ();
//        try {
//            subject.login(token);
//            resultData = new ResultData("登陆成功");
//            logger.error("账号为" + loginName + "登陆成功");
//        } catch (UnknownAccountException e) {
//            resultData = new ResultData("fail","登录账号不存在");
//            logger.error("账号为" + loginName + "登录账号不存在");
//            e.printStackTrace();
//        } catch (IncorrectCredentialsException e) {
//            resultData = new ResultData("fail","密码验证错误");
//            logger.error("账号为" + loginName + "密码验证错误");
//            e.printStackTrace();
//        } catch (AuthenticationException e) {
//            resultData = new ResultData("fail","登录失败");
//            logger.error("账号为" + loginName + "登录失败");
//            e.printStackTrace();
//        }
        return new ResultData(token);
    }
    @RequestMapping(value = "/index", method = RequestMethod.POST)
    public ResultData loginInfo(){
        Subject subject = SecurityUtils.getSubject();
        Employee employee = (Employee) subject.getPrincipal();
        if(null == employee){
            return new ResultData("fail", "无登录用户");
        }else{
            ResultData resultData = new ResultData();
            resultData.setData(employee);
            return resultData;
        }
    }
}
