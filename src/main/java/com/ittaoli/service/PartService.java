package com.ittaoli.service;

import com.ittaoli.dao.StockMapper;
import com.ittaoli.entity.Stock;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PartService {
    @Autowired
private StockMapper stockMapper;
    public int add(Stock stock) {
        return stockMapper.insertSelective(stock);
    }
}
