package com.example.demo.web.filter;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

public class LoginFilter implements javax.servlet.Filter {

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
        HttpServletRequest req = (HttpServletRequest) request;
        HttpSession session = req.getSession(false);
        String uri = req.getRequestURI();
        if ("/myweb/".equals(uri) || uri.contains("login.do") || uri.contains("initPage")) {
            chain.doFilter(request, response);
        }else{
            if (session == null) {
                ((HttpServletResponse) response).sendRedirect("/myweb/");
            }else {
                chain.doFilter(request, response);
            }
        }
    }
}
