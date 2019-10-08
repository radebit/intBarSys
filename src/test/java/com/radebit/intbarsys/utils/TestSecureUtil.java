package com.radebit.intbarsys.utils;

import cn.hutool.crypto.SecureUtil;

/**
 * @Author Rade
 * @Date 2019-10-01 16:30
 * 说明：
 */
public class TestSecureUtil {
    public static void main(String[] args) {
        String password = "123456";
        String md5 = SecureUtil.md5(password);
        System.out.println(md5);
    }
}
