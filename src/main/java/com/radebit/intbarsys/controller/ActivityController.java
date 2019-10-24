package com.radebit.intbarsys.controller;

import cn.hutool.core.lang.Assert;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.radebit.intbarsys.domain.JsonData;
import com.radebit.intbarsys.model.po.Activity;
import com.radebit.intbarsys.service.ActivityService;
import io.swagger.annotations.Api;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.sql.Timestamp;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

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
    public JsonData pageActivity(@RequestParam(value = "page", defaultValue = "1") int page,
                                 @RequestParam(value = "size", defaultValue = "10") int size) {
        PageHelper.startPage(page, size);
        List<Activity> list = activityService.findAll();
        PageInfo<Activity> pageInfo = new PageInfo<>(list);
        Map<String, Object> data = new HashMap<>();
        data.put("total_size", pageInfo.getTotal());//总条数
        data.put("total_page", pageInfo.getPages());//总页数
        data.put("current_page", page);//当前页
        data.put("data", pageInfo.getList());//数据
        return JsonData.buildSuccess(data);
    }

    @PostMapping("addActivity")
    public JsonData addActivity(@RequestParam(value = "title", required = true) String title,
                                @RequestParam(value = "category", required = true) int category,
                                @RequestParam(value = "reg_method", required = true) int regMethod,
                                @RequestParam(value = "format", required = true) int format,
                                @RequestParam(value = "contact", required = false) String contact,
                                @RequestParam(value = "phone", required = false) String phone,
                                @RequestParam(value = "start_time", required = true) String startTime,
                                @RequestParam(value = "end_time", required = true) String endTime,
                                @RequestParam(value = "place", required = false) String place,
                                @RequestParam(value = "reward_first", required = false) String rewardFirst,
                                @RequestParam(value = "reward_second", required = false) String rewardSecond,
                                @RequestParam(value = "reward_third", required = false) String rewardThird,
                                @RequestParam(value = "reward_other", required = false) String rewardOther,
                                @RequestParam(value = "details", required = false) String details,
                                @RequestParam(value = "attention", required = false) String attention,
                                @RequestParam(value = "logo", required = false) String logo,
                                @RequestParam(value = "banner", required = false) String banner,
                                @RequestParam(value = "rules", required = false) String rules) {
        Activity activity = new Activity();
        activity.setTitle(title);
        activity.setCategory(category);
        activity.setRegMethod(regMethod);
        activity.setFormat(format);
        activity.setContact(contact);
        activity.setPhone(phone);
        activity.setStartTime(Timestamp.valueOf(startTime));
        activity.setEndTime(Timestamp.valueOf(endTime));
        activity.setPlace(place);
        activity.setRewardFirst(rewardFirst);
        activity.setRewardSecond(rewardSecond);
        activity.setRewardThird(rewardThird);
        activity.setRewardOther(rewardOther);
        activity.setDetails(details);
        activity.setAttention(attention);
        activity.setLogo(logo);
        activity.setBanner(banner);
        activity.setRules(rules);

        if (activityService.save(activity) == 1) {
            return JsonData.buildSuccess("创建比赛活动成功！");
        }
        return JsonData.buildError("创建比赛失败！");
    }

    @GetMapping("getActivity")
    public JsonData getActivity(@RequestParam(value = "id",required = true) int id){
        Activity activity = activityService.findActivityById(id);
        if (activity==null){
            return JsonData.buildError("没有找到相关比赛！");
        }
        return JsonData.buildSuccess(activity);
    }

    @DeleteMapping("deleteActivity")
    public JsonData deleteActivity(@RequestParam(value = "id",required = true) int id){
        Assert.notNull(id);
        if (activityService.delete(id)==1){
            return JsonData.buildSuccess(null,"删除成功！");
        }
        return JsonData.buildError("删除失败！",300);
    }

    @PutMapping("updateActivity")
    public JsonData updateActivity(@RequestParam(value = "id", required = true) int id,
                                @RequestParam(value = "title", required = false) String title,
                                @RequestParam(value = "category", required = false) int category,
                                @RequestParam(value = "reg_method", required = false) int regMethod,
                                @RequestParam(value = "format", required = false) int format,
                                @RequestParam(value = "contact", required = false) String contact,
                                @RequestParam(value = "phone", required = false) String phone,
                                @RequestParam(value = "start_time", required = false) String startTime,
                                @RequestParam(value = "end_time", required = false) String endTime,
                                @RequestParam(value = "place", required = false) String place,
                                @RequestParam(value = "reward_first", required = false) String rewardFirst,
                                @RequestParam(value = "reward_second", required = false) String rewardSecond,
                                @RequestParam(value = "reward_third", required = false) String rewardThird,
                                @RequestParam(value = "reward_other", required = false) String rewardOther,
                                @RequestParam(value = "details", required = false) String details,
                                @RequestParam(value = "attention", required = false) String attention,
                                @RequestParam(value = "logo", required = false) String logo,
                                @RequestParam(value = "banner", required = false) String banner,
                                @RequestParam(value = "rules", required = false) String rules) {
        Assert.notNull(id);

        Activity activity = activityService.findActivityById(id);
        if (activity==null){
            return JsonData.buildError("比赛活动不存在",301);
        }
        activity.setId(id);
        activity.setTitle(title);
        activity.setCategory(category);
        activity.setRegMethod(regMethod);
        activity.setFormat(format);
        activity.setContact(contact);
        activity.setPhone(phone);
        activity.setStartTime(Timestamp.valueOf(startTime));
        activity.setEndTime(Timestamp.valueOf(endTime));
        activity.setPlace(place);
        activity.setRewardFirst(rewardFirst);
        activity.setRewardSecond(rewardSecond);
        activity.setRewardThird(rewardThird);
        activity.setRewardOther(rewardOther);
        activity.setDetails(details);
        activity.setAttention(attention);
        activity.setLogo(logo);
        activity.setBanner(banner);
        activity.setRules(rules);

        if (activityService.update(activity)==1){
            Activity newActivity = activityService.findActivityById(id);
            return JsonData.buildSuccess(newActivity,"编辑成功！");
        }

        return JsonData.buildError("编辑失败！");
    }
}
