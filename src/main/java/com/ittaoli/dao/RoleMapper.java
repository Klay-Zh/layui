package com.ittaoli.dao;

import com.ittaoli.entity.Role;

import java.util.List;
import java.util.Map;

public interface RoleMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(Role record);

    int insertSelective(Role r);

    Role selectByPrimaryKey(Integer id);
    long selectCount();
    List<Map<String,Object>> selectAll(Map<String,Object> map);

    int updateByPrimaryKeySelective(Map<String,Object> map);

    int updateByPrimaryKey(Role record);

    List<Map<String, Object>> getRolesPower(Map<String, Object> map);
}