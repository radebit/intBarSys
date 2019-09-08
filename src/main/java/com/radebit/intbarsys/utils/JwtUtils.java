package com.radebit.intbarsys.utils;

import com.radebit.intbarsys.model.po.Admin;
import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;

import java.util.Date;

/**
 * @Author Rade
 * @Date 2019-09-08 11:41
 * 说明：JWT工具类
 */
public class JwtUtils {
    public static final String SUBJECT = "intbarsys";    //设置签发人

    public static final long EXPIRE = 1000 * 60 * 60 * 24 * 7;   //设置失效时间(毫秒级)7天

    public static final String APPSECRET = "isuFJ4f389ux8u398s5rcEvr7ySRws8a7evt5st86es";    //密钥

    /**
     * Admin生成Token
     *
     * @param admin
     * @return
     */
    public static String geneAdminJWT(Admin admin) {

        //校验admin对象内容是否为空
        if (admin == null || admin.getId() == null || admin.getUsername() == null) {
            return null;
        } else {
            String token = Jwts.builder().setSubject(SUBJECT)
                    .claim("id", admin.getId())
                    .claim("username", admin.getUsername())
                    .setIssuedAt(new Date())
                    .setExpiration(new Date(System.currentTimeMillis() + EXPIRE))
                    .signWith(SignatureAlgorithm.HS256, APPSECRET).compact();

            return token;
        }
    }

    /**
     * 校验Token
     *
     * @param token
     * @return
     */
    public static Claims checkJWT(String token) {

        try {

            Claims claims = Jwts.parser().setSigningKey(APPSECRET)
                    .parseClaimsJws(token)
                    .getBody();

            return claims;

        }catch (Exception e){
            //抛异常
        }

        return null;
    }
}
