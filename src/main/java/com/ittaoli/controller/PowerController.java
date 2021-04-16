package com.ittaoli.controller;

import com.ittaoli.common.UserPower;
import com.ittaoli.service.PowerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.HashMap;
import java.util.Map;

@Controller
@RequestMapping("/power")
public class PowerController {
    @Autowired
    private PowerService powerService;
    @UserPower(2)
    @RequestMapping("/users")
    @ResponseBody
    public Object users(int page,int limit){
    Map<String,Object> map = new HashMap<>();
    map.put("code",0);
    map.put("msg","");
    map.put("count",powerService.getCount());
    map.put("data",powerService.getRoles(page,limit));
    return map;
}
    @UserPower(2)
    @RequestMapping("/add" )
    @ResponseBody
    public Object add(String name){
        Map<String,Object> map = new HashMap<>();
        int result = powerService.addUser(name);
        if(result==1){
            map.put("code",1);
        }else{
            map.put("code",0);
            map.put("msg","新增失败");
        }
        return map;

}
    @UserPower(2)
    @RequestMapping("/del")
    @ResponseBody
    public Object del(int id){
        Map<String,Object> map = new HashMap<>();
    int result = powerService.delRole(id);
        if(result==1){
            map.put("code",1);
        }else{
            map.put("code",0);
            map.put("msg","删除失败");
        }
        return map;
    }
    @UserPower(2)
    @RequestMapping("/mod")
    @ResponseBody
    public Object mod(int id,String name){
        Map<String,Object> map = new HashMap<>();
        int result = powerService.modRole(id,name);
        if(result==1){
            map.put("code",1);
        }else{
            map.put("code",0);
            map.put("msg","修改失败");
        }
        return map;
    }
     @UserPower(5)
    @RequestMapping("/powers")
    @ResponseBody
    public Object powers(int page,int limit){
        Map<String,Object> map = new HashMap<>();
         map.put("code",0);
         map.put("msg","");
         map.put("count",powerService.getCount());
         map.put("data",powerService.getRolesPower(page,limit));
        return map;
     }
     @UserPower(5)
    @RequestMapping("/allpowers")
    @ResponseBody
    public Object allpowers(){
        return powerService.selectAll();
     }
    @UserPower(5)
    @RequestMapping("/edit_power")
    @ResponseBody
    public Object edit_power(int rid,Integer[] powers){
        Map<String,Object> map = new HashMap<>();
        if(powerService.edit_power(rid,powers)){
            map.put("code",1);
        }else{
            map.put("code",0);
            map.put("msg","权限修改失败");
        }
        return map;
    }
}
