package com.ittaoli.controller;

import com.ittaoli.entity.User;
import com.ittaoli.service.AdminService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.util.DigestUtils;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;


import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.net.URLEncoder;
import java.util.HashMap;
import java.util.Map;

@Controller
@RequestMapping("/admin")
public class AdminController {
    @Autowired
    private AdminService ad;


    //    登陆
    @RequestMapping("/login")
    @ResponseBody
    public Map<String, Object> login(String username, String password, HttpSession session) {
        Map<String, Object> map = new HashMap<>();
        User u = ad.login(username, password);
        if (u != null) {
            session.setAttribute("loginUser", u);
            map.put("code", 1);
        } else {
            map.put("code", 0);
            map.put("msg", "用户名或密码错误");
        }
        return map;
    }

    //    注册
    @RequestMapping("/reg")
    @ResponseBody
    public Map<String, Object> reg(String username, String password, HttpSession session) {
        Map<String, Object> map = new HashMap<String, Object>();
        User u = ad.register(username, password);
        if (u != null) {
            map.put("code", 1);
            session.setAttribute("loginUser", u);
        } else {
            map.put("code", 0);
            map.put("msg", "用户名已存在，换一个试试");
        }
        return map;
    }

    //    退出
    @RequestMapping("/exit")
    @ResponseBody
    public int exit(HttpSession session) {
        session.removeAttribute("loginUser");
        return 1;
    }

    //    修改密码
    @RequestMapping("/reset")
    @ResponseBody
    public Map<String, Object> reset(HttpSession session, String password, String new_password) {
        Map<String, Object> map = new HashMap<>();
        User u = (User) session.getAttribute("loginUser");
        System.out.println(password);
        System.out.println(new_password);
        //对密码进行 md5 加密
        String md5Pwd = DigestUtils.md5DigestAsHex(password.getBytes());
        if (u.getPassword().equals(md5Pwd)) {
            int result = ad.reset(u.getId(), new_password);
            System.out.println(result);
            if(result==1){
                map.put("code",1);
                session.removeAttribute("loginUser");
            }else{
                map.put("code",0);
                map.put("msg","重置失败");
            }
        } else {
            map.put("code", 0);
            map.put("msg", "原密码错误");
        }
        return map;
    }
}

