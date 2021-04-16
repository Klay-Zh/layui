package com.ittaoli.common;


import org.springframework.util.DigestUtils;

public class PasswordEncode {
    private static final String PASSWORD_KEY= "carcar";
     public static String encode(String pwd){
        String str = pwd + PASSWORD_KEY;
        return DigestUtils.md5DigestAsHex(str.getBytes());
    }
}
