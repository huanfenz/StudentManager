package com.wangpeng.controller;

import com.wangpeng.pojo.Manager;
import com.wangpeng.service.LoginService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;

@Controller
@RequestMapping("/login")
public class LoginController {

    @Autowired
    LoginService service;

    @RequestMapping("login.do")
    @ResponseBody
    public int login(String username, String password, String authority, String captcha, HttpServletRequest req){
        /*  status: 0验证码错误，1账号密码错误，2成功
         */
        // 验证码错误
        if( !captcha.equals("xszg")) return 0;

        // 账号密码错误
        Object obj = null;
        if(authority.equals("manager")){
            obj = service.managerLogin(username,password);
        } else if(authority.equals("teacher")){
            obj = service.teacherLogin(username,password);
        } else if(authority.equals("student")){
            obj = service.studentLogin(username,password);
        }

        if(obj == null) return 1;
        else {
            //保存用户登陆的信息到Session域中
            req.getSession().setAttribute("loginObj", obj);
            return 2;
        }
    }

    @RequestMapping("alterPassword.do")
    @ResponseBody
    public int alterPassword(String oldPassword, String newPassword,HttpServletRequest req){
        //获取当前账号信息
        Manager loginManager = (Manager) req.getSession().getAttribute("loginObj");
        //检查旧密码是否正确
        Manager manager = service.managerLogin(loginManager.getUsername(), oldPassword);
        if(manager == null) {   //旧密码不正确
            return 0;
        } else {    //旧密码正确，设置新密码
            service.setPassword(loginManager, newPassword);
            return 1;
        }
    }
}
