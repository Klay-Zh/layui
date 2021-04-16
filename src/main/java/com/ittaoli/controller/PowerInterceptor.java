package com.ittaoli.controller;

import com.ittaoli.common.UserPower;
import com.ittaoli.entity.User;
import com.ittaoli.service.PowerService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.method.HandlerMethod;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class PowerInterceptor implements HandlerInterceptor {
    @Autowired
private PowerService powerService;
    @Override
    public boolean preHandle(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Object o) throws Exception {
        HttpSession session = httpServletRequest.getSession();
        if(session.getAttribute("loginUser")==null){
            return false;
        }
        HandlerMethod hand = (HandlerMethod) o;
        UserPower userPower = hand.getMethodAnnotation(UserPower.class);
        if (userPower == null) {
            return true;
        }
        int value = userPower.value();
        User u = (User)session.getAttribute("loginUser");
        int role_id = u.getRoleId();
        return powerService.PowerValid(role_id,value);
    }

    @Override
    public void postHandle(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Object o, ModelAndView modelAndView) throws Exception {

    }

    @Override
    public void afterCompletion(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Object o, Exception e) throws Exception {

    }

}
