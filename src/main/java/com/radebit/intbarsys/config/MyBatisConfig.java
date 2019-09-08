package com.radebit.intbarsys.config;

import com.github.pagehelper.PageHelper;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.Properties;

/**
 * @Author Rade
 * @Date 2019-09-08 11:17
 * 说明：MyBatis配置
 */
@Configuration
public class MyBatisConfig {
    @Bean
    public PageHelper pageHelper() {
        PageHelper pageHelper = new PageHelper();
        Properties p = new Properties();

        //设置为True时，会将RowBounds第一个参数offset当做pageNum页码使用
        p.setProperty("offsetAsPageNum","true");

        //设置为True时，使用RowBounds分页时，会进行count查询
        p.setProperty("rowBoundsWithCount","true");
        p.setProperty("reasonable","true");
        pageHelper.setProperties(p);
        return pageHelper;
    }
}
