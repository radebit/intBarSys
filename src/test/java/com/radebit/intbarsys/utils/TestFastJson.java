package com.radebit.intbarsys.utils;

import com.alibaba.fastjson.JSON;
import com.radebit.intbarsys.model.po.Admin;

import java.sql.Timestamp;
import java.util.Date;

/**
 * @Author Rade
 * @Date 2019-09-30 21:37
 * 说明：
 */
public class TestFastJson {
    public static void main(String[] args) {
        serialize();
        deserialize();
    }

    public static void serialize() {
        Admin admin = new Admin();
        admin.setId(10001);
        admin.setUsername("rade");
        admin.setPassword("123456");
        admin.setLastLoginIp("127.0.0.1");
        Timestamp nowTimestamp = new Timestamp(new Date().getTime());
        admin.setLastLoginTime(nowTimestamp);
        System.out.println(JSON.toJSON(admin));
    }

    public static void deserialize() {
        String json = "{\"lastLoginTime\":1569856107724,\"password\":\"123456\",\"id\":10001,\"lastLoginIp\":\"127.0.0.1\",\"username\":\"rade\"}";
        Admin admin = JSON.parseObject(json,Admin.class);
        System.out.println(admin.getUsername());
        System.out.println(admin.getId());

    }
}
