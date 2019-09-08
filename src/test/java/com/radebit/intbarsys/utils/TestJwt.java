package com.radebit.intbarsys.utils;

import com.radebit.intbarsys.model.po.Admin;
import io.jsonwebtoken.Claims;
import org.junit.Test;

/**
 * @Author Rade
 * @Date 2019-09-08 11:46
 * 说明：
 */
public class TestJwt {

    @Test
    public void testGenJwt() {
        Admin admin = new Admin();
        admin.setId(1);
        admin.setUsername("rade");
        admin.setPassword("123123");
        String token = JwtUtils.geneAdminJWT(admin);
        System.out.println(token);
    }

    @Test
    public void testCheckJwt() {
        Claims claims = JwtUtils.checkJWT("eyJhbGciOiJIUzI1NiJ9.eyJzdWIiOiJpbnRiYXJzeXMiLCJpZCI6MSwidXNlcm5hbWUiOiJyYWRlIiwiaWF0IjoxNTY3OTE0NTIxLCJleHAiOjE1Njg1MTkzMjF9._iy0L1Ug8clYvmap6hXS0vEDWNSZuARvKOC-YWibOYw");
        if (claims != null){
            System.out.println(claims);

            int id = (Integer) claims.get("id");
            String name = (String) claims.get("username");

            System.out.println(id);
            System.out.println(name);

        }else {
            System.out.println("非法Token");
        }

    }

}
