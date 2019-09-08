package com.radebit.intbarsys.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Author Rade
 * @Date 2019-09-08 10:55
 * 说明：测试接口
 */
@RestController
@RequestMapping("/api/v1/test")
public class TestController {

    @GetMapping("hello")
    public String test(){
        return "Test Success!";
    }
}
