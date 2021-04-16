package com.ittaoli.dao;

import com.ittaoli.entity.Role_power;

import java.util.Map;

public interface Role_powerMapper {
    int deleteByPrimaryKey(Map<String,Object> map);

    int insert(Role_power record);

    int insertSelective(Role_power record);

    Role_power selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(Role_power record);

    int updateByPrimaryKey(Role_power record);

    Role_power selectByRoleid(Map<String, Object> map);
}