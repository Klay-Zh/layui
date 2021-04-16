package com.ittaoli.controller;

import com.ittaoli.entity.Stock;
import com.ittaoli.service.PartService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.HashMap;
import java.util.Map;

@Controller
@RequestMapping("part")
public class PartController {
    @Autowired
    private PartService partService;
    @RequestMapping("add")
    @ResponseBody
    public Object addPart(Stock stock){
        Map<String,Object> map = new HashMap<>();
        if(partService.add(stock)==1){
            map.put("code",1);
        }else{
            map.put("code",0);
            map.put("msg","出错了");
        }
        return map;
    }
}
