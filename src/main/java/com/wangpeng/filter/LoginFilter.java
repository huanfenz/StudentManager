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

        Object loginObj = req.getSession().getAttribute("loginObj");

        if(loginObj != null) {
            // 继续访问目标资源
            filterChain.doFilter(servletRequest,servletResponse);
        } else {
            //回到登录界面
            req.getRequestDispatcher("/index.jsp").forward(req,resp);
        }
    }

    @Override
    public void destroy() {

    }
}
