package com.ittaoli.dao;

import com.ittaoli.entity.User;

import java.util.Map;

public interface UserMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(User record);

    int insertSelective(User record);

    User selectByName(String name);

    int updateByPrimaryKeySelective(Map<String,Object> map);

    int updateByPrimaryKey(User record);
}