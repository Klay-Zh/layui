package com.ittaoli.filter;

import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

public class MyFilter implements Filter {

    @Override
    public void destroy() {

    }
    @Override
    public void doFilter( ServletRequest req, ServletResponse resp, FilterChain chain) throws ServletException, IOException {
        HttpServletRequest request = (HttpServletRequest)req;
        HttpServletResponse response = (HttpServletResponse)resp;
        HttpSession session = request.getSession();
        if(session.getAttribute("loginUser")==null){
            // 没有登录
            response.sendRedirect("login.html");
        }else{
            chain.doFilter(req, resp);
        }


    }

    public void init(FilterConfig config) throws ServletException {

    }


}
