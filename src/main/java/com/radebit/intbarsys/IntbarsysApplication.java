package com.radebit.intbarsys;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@MapperScan("com.radebit.intbarsys.mapper")
public class IntbarsysApplication {

    public static void main(String[] args) {
        SpringApplication.run(IntbarsysApplication.class, args);
    }

}
