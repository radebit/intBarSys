package com.radebit.intbarsys.controller;

import com.radebit.intbarsys.controller.annotation.AdminToken;
import com.radebit.intbarsys.controller.annotation.AuthToken;
import com.radebit.intbarsys.domain.JsonData;
import com.radebit.intbarsys.model.po.Admin;
import com.radebit.intbarsys.model.po.Dictionary;
import com.radebit.intbarsys.service.AdminService;
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

    @Autowired
    private AdminService adminService;

    @GetMapping("hello")
    public String test(){
        return "Test Success!";
    }

    @PostMapping("testHasToken")
    @AuthToken
    public JsonData testHasToken(){
        return JsonData.buildSuccess("成功访问");
    }

    @GetMapping("adminInfo")
    public JsonData testAdminInfo(){
        Admin admin = adminService.findAdminByUsername("admin");
        return JsonData.buildSuccess(admin);
    }
}
