package com.ittaoli.service;

import com.ittaoli.dao.PowerMapper;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class MainService {
    @Autowired
private PowerMapper powerMapper;
public List<Map<String,Object>> selectByRoleId(int id){
    return powerMapper.selectByRoleId(id);
}

}
