package com.radebit.intbarsys.utils;

import org.junit.Test;

/**
 * @Author Rade
 * @Date 2019-10-19 17:49
 * 说明：
 */
public class TestUtils {
    @Test
    public void testDate(){
        System.out.println(DateTimeUtils.timeStamp());
        String date = DateTimeUtils.timeStamp();
        System.out.println(DateTimeUtils.timeStamp2Date(date,"yyyy-MM-dd HH:mm:ss"));

    }
}
