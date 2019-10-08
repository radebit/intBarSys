package com.radebit.intbarsys.utils;

import cn.hutool.core.net.NetUtil;

import java.sql.Timestamp;
import java.util.Date;

/**
 * @Author Rade
 * @Date 2019-10-01 17:11
 * 说明：
 */
public class TestHutool {
    public static void main(String[] args) {
        String str1 = "e10adc3949ba59abbe56e057f20f883e";
        String str2 = "e10adc3949ba59abbe56e057f20f883e";
        System.out.println(str1.equals(str2));

        System.out.println(new Timestamp(new Date().getTime()));
    }
}
