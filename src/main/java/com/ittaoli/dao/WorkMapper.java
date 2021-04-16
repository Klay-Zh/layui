package com.ittaoli.dao;

import com.ittaoli.entity.Work;
import com.ittaoli.entity.WorkWithBLOBs;

public interface WorkMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(WorkWithBLOBs record);

    int insertSelective(WorkWithBLOBs record);

    WorkWithBLOBs selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(WorkWithBLOBs record);

    int updateByPrimaryKeyWithBLOBs(WorkWithBLOBs record);

    int updateByPrimaryKey(Work record);
}