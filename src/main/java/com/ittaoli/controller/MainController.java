package com.ittaoli.controller;

import com.ittaoli.entity.User;
import com.ittaoli.service.AdminService;
import com.ittaoli.service.MainService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpSession;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
@RequestMapping("/main")
public class MainController {
    @Autowired
    private MainService mainService;
    @RequestMapping("/menu")
    @ResponseBody
public Object menu(HttpSession session){
    Map<String,Object> map = new HashMap<>();
    User u =(User)session.getAttribute("loginUser");
    map.put("loginName",u.getName());
    map.put("menu",mainService.selectByRoleId(u.getRoleId()));
    return map;
}






}
