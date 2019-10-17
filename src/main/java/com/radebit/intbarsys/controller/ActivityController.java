package com.radebit.intbarsys.controller;

import com.radebit.intbarsys.domain.JsonData;
import com.radebit.intbarsys.service.ActivityService;
import io.swagger.annotations.Api;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Author Rade
 * @Date 2019-10-17 09:51
 * 说明：比赛活动控制器
 */

@Api(value = "比赛活动模块")
@RestController
@RequestMapping("/api/v1/activity")
public class ActivityController {

    @Autowired
    private ActivityService activityService;

    @GetMapping()
    public JsonData pageActivity(@RequestParam(value = "page",defaultValue = "1")int page,
                                 @RequestParam(value = "size",defaultValue = "10")int size){
        return null;
    }

}
