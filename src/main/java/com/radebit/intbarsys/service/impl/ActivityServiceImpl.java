package com.radebit.intbarsys.service.impl;

import com.radebit.intbarsys.mapper.ActivityMapper;
import com.radebit.intbarsys.model.po.Activity;
import com.radebit.intbarsys.service.ActivityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @Author Rade
 * @Date 2019-10-17 14:37
 * 说明：
 */
@Service
public class ActivityServiceImpl implements ActivityService {

    @Autowired
    private ActivityMapper activityMapper;

    @Override
    public Activity findActivityById(int id) {
        return activityMapper.findActivityById(id);
    }

    @Override
    public List<Activity> findAll() {
        return activityMapper.findAll();
    }

    @Override
    public List<Activity> findActivityListByTitle(String title) {
        return activityMapper.findActivityListByTitle(title);
    }

    @Override
    public Integer update(Activity activity) {
        return activityMapper.update(activity);
    }

    @Override
    public Integer delete(int id) {
        return activityMapper.delete(id);
    }

    @Override
    public Integer save(Activity activity) {
        return activityMapper.save(activity);
    }
}
