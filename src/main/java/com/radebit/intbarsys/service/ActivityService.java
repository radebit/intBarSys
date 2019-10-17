package com.radebit.intbarsys.service;

import com.radebit.intbarsys.model.po.Activity;

import java.util.List;

/**
 * @Author Rade
 * @Date 2019-10-17 14:35
 * 说明：比赛活动业务接口
 */
public interface ActivityService {

    Activity findActivityById(int id);

    List<Activity> findActivityListByTitle(String title);

    Integer update(Activity activity);

    Integer delete(int id);

    Integer save(Activity activity);
}
