package com.radebit.intbarsys.controller;

import com.radebit.intbarsys.model.po.Dictionary;
import com.radebit.intbarsys.service.DictionaryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Author Rade
 * @Date 2019-09-08 10:55
 * 说明：测试接口
 */
@RestController
@RequestMapping("/api/v1/test")
public class TestController {

    @Autowired
    private DictionaryService dictionaryService;

    @GetMapping("hello")
    public String test(){
        return "Test Success!";
    }

    @GetMapping("getDicById")
    public Dictionary getDicById(@RequestParam(value = "id",required = true) int id) {
        return dictionaryService.findDicById(id);
    }

    @GetMapping("getDicByKey")
    public String getDicById(@RequestParam(value = "key",required = true) String key) {
        return dictionaryService.findDicByKey(key);
    }
}
