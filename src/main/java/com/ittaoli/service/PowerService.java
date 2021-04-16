package com.ittaoli.service;

import com.ittaoli.dao.PowerMapper;
import com.ittaoli.dao.RoleMapper;
import com.ittaoli.dao.Role_powerMapper;
import com.ittaoli.entity.Role;
import com.ittaoli.entity.Role_power;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.*;

@Service
public class PowerService {
    @Autowired
    private Role_powerMapper rolepowerMapper;
    @Autowired
    private RoleMapper roleMapper;
    @Autowired
    private PowerMapper powerMapper;
//    检验是否有权限
    public boolean PowerValid(int role_id,int power_id){
        Map<String,Object> map = new HashMap<>();
        map.put("role_id",role_id);
        map.put("power_id",power_id);
        return  rolepowerMapper.selectByRoleid(map)!=null;
    }
//    返回角色数量
    public long getCount(){
        return roleMapper.selectCount();
    }
//    返回角色列表
    public List<Map<String,Object>> getRoles(int page, int limit){
    Map<String,Object> map = new HashMap<>();
    map.put("start",(page-1)*limit);
    map.put("limit",limit);
    return roleMapper.selectAll(map);
    }
//    新增角色
    public int addUser(String name){
        Role r = new Role();
        r.setRole(name);
        return roleMapper.insertSelective(r);
    }
//    删除角色
    public int delRole(int id){
        return roleMapper.deleteByPrimaryKey(id);
    }
//    修改角色名
    public int modRole(int id,String name){
        Map<String,Object> map = new HashMap<>();
        map.put("id",id);
        map.put("role",name);
        return roleMapper.updateByPrimaryKeySelective(map);
    }
//获取角色权限list
    public List<Map<String,Object>> getRolesPower(int page, int limit) {
        Map<String,Object> map = new HashMap<>();
        map.put("start",(page-1)*limit);
        map.put("limit",limit);
        return roleMapper.getRolesPower(map);
    }
//所有权限
    public List<Map<String,Object>> selectAll() {
        return  powerMapper.selectAll();
    }
//    权限修改
    @Transactional
    public boolean edit_power(int id,Integer[] powers){
        List<Map<String,Object>> powerList = powerMapper.selectByRoleId(id);
        List<Integer> oldPower = new ArrayList<>();
        for(Map<String,Object> power:powerList){
            oldPower.add((Integer) power.get("id"));
        }
        List<Integer> newPower = Arrays.asList(powers);
        List<Integer> addList = new ArrayList<>();
        List<Integer> delList = new ArrayList<>();
        for(Integer i:newPower){
            if (!oldPower.contains(i)){
                addList.add(i);
            }
        }

        for(Integer i:oldPower){
            if(!newPower.contains(i)){
                delList.add(i);
            }
        }
        for(int i:delList){
            System.out.println(i);
        }
        int temp = 0;
       for(Integer i:addList){
           Role_power rolePower = new Role_power();
           rolePower.setRoleId(id);
           rolePower.setPowerId(i);
          temp+= rolepowerMapper.insertSelective(rolePower);
       }
       for(Integer i :delList){
           Role_power role_power = new Role_power();
           Map<String,Object> map = new HashMap<>();
           map.put("role_id",id);
           map.put("power_id",i);
          temp+= rolepowerMapper.deleteByPrimaryKey(map);
       }
        return temp>0;
    }
}
