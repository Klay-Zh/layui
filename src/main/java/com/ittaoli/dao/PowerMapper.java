package com.ittaoli.dao;

import com.ittaoli.entity.Power;

import java.util.List;
import java.util.Map;

public interface PowerMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(Power record);

    int insertSelective(Power record);

    List<Map<String,Object>> selectByRoleId(Integer id);

    int updateByPrimaryKeySelective(Power record);

    int updateByPrimaryKey(Power record);

    List<Map<String, Object>> selectAll();
}