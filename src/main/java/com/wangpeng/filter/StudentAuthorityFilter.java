package com.wangpeng.filter;

import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class StudentAuthorityFilter implements Filter {
    @Override
    public void init(FilterConfig filterConfig) throws ServletException {

    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        HttpServletRequest req = (HttpServletRequest) servletRequest;
        HttpServletResponse resp = (HttpServletResponse) servletResponse;

        String authority = (String) req.getSession().getAttribute("authority");

        if(authority.equals("student")) {
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
