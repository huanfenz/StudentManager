package com.wangpeng.controller;

import com.wangpeng.pojo.Manager;
import com.wangpeng.pojo.Student;
import com.wangpeng.pojo.Teacher;
import com.wangpeng.service.LoginService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@RestController
@RequestMapping("/login")
public class LoginController {

    @Autowired
    LoginService service;

    @RequestMapping("login.do")
    public int login(String username, String password, String authority, String captcha, HttpServletRequest req, HttpServletResponse resp){
        //  status: 0验证码错误，1账号密码错误，2成功，3验证码失效

        //获取Session中的验证码
        String token = (String) req.getSession().getAttribute("KAPTCHA_SESSION_KEY");
        // 删除Session中的验证码
        req.getSession().removeAttribute("KAPTCHA_SESSION_KEY");

        System.out.println("验证码[" + token + "]");

        // 验证码失效
        if(token == null) return 3;

        // 验证码错误
        if( !captcha.equals(token)) return 0;

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
            req.getSession().setAttribute("authority",authority);   //权限身份
            req.getSession().setAttribute("loginObj", obj);         //登录对象
            return 2;
        }
    }

    @RequestMapping("alterPassword.do")
    public int alterPassword(String oldPassword, String newPassword,HttpServletRequest req){
        //获取当前登录的权限
        String authority = (String) req.getSession().getAttribute("authority");

        if(authority.equals("manager")) {
            //获取当前账号信息
            Manager loginManager =  (Manager) req.getSession().getAttribute("loginObj");

            //检查旧密码是否正确
            Manager manager = service.managerLogin(loginManager.getUsername(), oldPassword);
            if(manager == null) {   //旧密码不正确
                return 0;
            } else {    //旧密码正确，设置新密码
                service.setManagerPassword(loginManager, newPassword);
                return 1;
            }
        } else if(authority.equals("teacher")) {
            //获取当前账号信息
            Teacher loginTeacher =  (Teacher) req.getSession().getAttribute("loginObj");

            //检查旧密码是否正确
            Teacher teacher = service.teacherLogin(loginTeacher.getTnum(), oldPassword);

            if(teacher == null) {   //旧密码不正确
                return 0;
            } else {    //旧密码正确，设置新密码
                service.setTeacherPassword(loginTeacher, newPassword);
                return 1;
            }
        } else if(authority.equals("student")) {
            //获取当前账号信息
            Student loginStudent =  (Student) req.getSession().getAttribute("loginObj");

            //检查旧密码是否正确
            Student student = service.studentLogin(loginStudent.getSnum(), oldPassword);

            if(student == null) {   //旧密码不正确
                return 0;
            } else {    //旧密码正确，设置新密码
                service.setStudentPassword(loginStudent, newPassword);
                return 1;
            }
        }

        return 0;
    }

    @RequestMapping("exitLogin.do")
    public void exitLogin(HttpServletRequest req){
        req.getSession().setAttribute("authority", null);
        req.getSession().setAttribute("loginObj", null);
    }
}
