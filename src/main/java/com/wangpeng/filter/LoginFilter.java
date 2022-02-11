package com.wangpeng.filter;

import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class LoginFilter implements Filter {
    @Override
    public void init(FilterConfig filterConfig) throws ServletException {

    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        HttpServletRequest req = (HttpServletRequest) servletRequest;
        HttpServletResponse resp = (HttpServletResponse) servletResponse;

        // 获得登录对象
        Object loginObj = req.getSession().getAttribute("loginObj");
        // 获得权限身份
        String authority = (String) req.getSession().getAttribute("authority");

        // 如果没有登录，则回到登录界面
        if (loginObj == null) {
            req.getRequestDispatcher("/index.jsp").forward(req,resp);
            return;
        }

        // 获取请求的路径
        String url = String.valueOf(req.getRequestURL());

        // 学生请求 正则表达式
        String studentRegex = ".*\\/student\\/.+\\..{1,5}";
        // 教师请求 正则表达式
        String teacherRegex = ".*\\/teacher\\/.+\\..{1,5}";

        // 如果登录的是学生
        if(authority.equals("student")) {
            // 不是学生的请求，则回到登录界面
            if ( !url.matches(studentRegex) ) {
                req.getRequestDispatcher("/index.jsp").forward(req,resp);
                return;
            }
        }

        // 如果登录的是教师
        if(authority.equals("teacher")) {
            // 不是教师的请求，则回到登录界面
            if ( !url.matches(teacherRegex) ) {   // 是教师的请求，则放行
                req.getRequestDispatcher("/index.jsp").forward(req,resp);
                return;
            }
        }

        // 访问目标资源
        filterChain.doFilter(servletRequest,servletResponse);
    }

    @Override
    public void destroy() {

    }
}
