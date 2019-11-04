package com.radebit.intbarsys.utils;

import cn.hutool.json.JSONObject;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;

import javax.servlet.http.HttpServletResponse;
import java.io.PrintWriter;

/**
 * @Author Rade
 * @Date 2019-11-04 13:55
 * 说明：Token生成出错返回json
 */
public final class TokenError {
    public static void printError(HttpServletResponse response,int code,String msg) {
        JSONObject jsonObject = new JSONObject();

        PrintWriter out = null;
        try {
            response.setStatus(401);
            response.setContentType(MediaType.APPLICATION_JSON_VALUE);

            jsonObject.put("code", code);
            jsonObject.put("message", msg);
            out = response.getWriter();
            out.println(jsonObject);
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (null != out) {
                out.flush();
                out.close();
            }
        }
    }

}
