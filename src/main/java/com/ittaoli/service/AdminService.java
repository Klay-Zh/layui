package com.ittaoli.service;

import com.ittaoli.common.PasswordEncode;
import com.ittaoli.dao.UserMapper;
import com.ittaoli.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.DigestUtils;

import java.util.HashMap;
import java.util.Map;

@Service
public class AdminService {
    @Autowired
    private UserMapper usermapper;

    //        登陆
    public User login(String name, String pwd) {
        //对密码进行 md5 加密
//         pwd = PasswordEncode.encode(pwd);
        System.out.println(pwd);
        User u = usermapper.selectByName(name);
        if (u != null && u.getPassword().equals(pwd)) {
            u.setPassword(null);
            return u;
        } else {
            return null;
        }
    }

    //        注册
    public User register(String name, String pwd) {
        //对密码进行 md5 加密
        String md5Pwd = DigestUtils.md5DigestAsHex(pwd.getBytes());
        User u = new User();
        u.setName(name);
        u.setPassword(md5Pwd);
        try {
            int result = usermapper.insert(u);
            if (result == 1) {
                return u;
            }
        } catch (Exception e) {
            return null;
        }
        return null;
    }

    public int reset(Integer id, String new_password) {
        //对密码进行 md5 加密
        String md5Pwd = DigestUtils.md5DigestAsHex(new_password.getBytes());
        Map<String,Object> map = new HashMap<>();
        map.put("id",id);
        map.put("password",md5Pwd);
         return usermapper.updateByPrimaryKeySelective(map);
    }
}
