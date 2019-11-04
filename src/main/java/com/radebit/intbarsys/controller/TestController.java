package com.radebit.intbarsys.controller;

import com.radebit.intbarsys.controller.annotation.AdminToken;
import com.radebit.intbarsys.controller.annotation.AuthToken;
import com.radebit.intbarsys.domain.JsonData;
import com.radebit.intbarsys.model.po.Dictionary;
import com.radebit.intbarsys.service.DictionaryService;
import io.swagger.annotations.Api;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * @Author Rade
 * @Date 2019-09-08 10:55
 * 说明：测试接口
 */
@Api(value = "测试接口模块")
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

    @PostMapping("testHasToken")
    @AuthToken
    public JsonData testHasToken(){
        return JsonData.buildSuccess("成功访问");
    }
}
