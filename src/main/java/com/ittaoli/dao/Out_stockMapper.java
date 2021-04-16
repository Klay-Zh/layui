package com.ittaoli.dao;

import com.ittaoli.entity.Out_stock;

public interface Out_stockMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(Out_stock record);

    int insertSelective(Out_stock record);

    Out_stock selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(Out_stock record);

    int updateByPrimaryKey(Out_stock record);
}