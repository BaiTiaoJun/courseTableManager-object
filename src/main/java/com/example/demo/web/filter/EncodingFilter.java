package com.example.demo.web.filter;

import javax.servlet.*;
import java.io.IOException;

public class EncodingFilter implements Filter {

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws ServletException, IOException {
        request.setCharacterEncoding("utf-8");
        response.setContentType("html/text;charset=utf-8");
        chain.doFilter(request, response);
    }
}
