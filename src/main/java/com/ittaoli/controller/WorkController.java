package com.ittaoli.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

@Controller
@RequestMapping("work")
public class WorkController {
    public Map<String,Object> create(  String orderId, String carId, Integer serverType, Integer waiterId, Integer repairId, Integer addPr, Integer adjustPr, Integer realPr, Integer payType,
                                       Integer payState, Integer carKm, Date createTime, Date payTime, Date checkoutTime,
                                       String serverSug, String salePolicy, String maintainSug, String remarks
    ){
        Map<String, Object> map = new HashMap<>();
        if (true) {
            map.put("code", 1);
        } else {
            map.put("code", 0);
            map.put("msg", "用户名或密码错误");
        }
        return map;
    }
}
