package com.radebit.intbarsys.utils;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * @Author Rade
 * @Date 2019-09-30 23:00
 * 说明：时间日期工具类
 */
public class DateTimeUtils {

    /**
     * 时间戳转换成日期格式字符串
     * @param seconds 精确到秒的字符串
     * @param format
     * @return
     */
    public static String timeStamp2Date(String seconds,String format) {
        if(seconds == null || seconds.isEmpty() || seconds.equals("null")){
            return "";
        }
        if(format == null || format.isEmpty()){
            format = "yyyy-MM-dd HH:mm:ss";
        }
        SimpleDateFormat sdf = new SimpleDateFormat(format);
        return sdf.format(new Date(Long.valueOf(seconds+"000")));
    }
    /**
     * 日期格式字符串转换成时间戳
     * @param date 字符串日期
     * @param format 如：yyyy-MM-dd HH:mm:ss
     * @return
     */
    public static String date2TimeStamp(String date,String format){
        try {
            SimpleDateFormat sdf = new SimpleDateFormat(format);
            return String.valueOf(sdf.parse(date).getTime()/1000);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return "";
    }

    /**
     * 取得当前时间戳（精确到秒）
     * @return
     */
    public static String timeStamp(){
        long time = System.currentTimeMillis();
        String t = String.valueOf(time/1000);
        return t;
    }


    /**
     * Date转Timestamp
     *
     * Timestamp createTime = new Timestamp(new Date().getTime());
     *
     *
     * Timestamp转Date
     *
     *     Timestamp t = new Timestamp(System.currentTimeMillis());
     *     Date d = new Date(t.getTime());
     */

}
