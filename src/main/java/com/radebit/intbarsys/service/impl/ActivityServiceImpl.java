package com.radebit.intbarsys.service.impl;

import com.radebit.intbarsys.model.po.Activity;
import com.radebit.intbarsys.service.ActivityService;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @Author Rade
 * @Date 2019-10-17 14:37
 * 说明：
 */
@Service
public class ActivityServiceImpl implements ActivityService {
    @Override
    public Activity findActivityById(int id) {
        return null;
    }

    @Override
    public List<Activity> findActivityListByTitle(String title) {
        return null;
    }

    @Override
    public Integer update(Activity activity) {
        return null;
    }

    @Override
    public Integer delete(int id) {
        return null;
    }

    @Override
    public Integer save(Activity activity) {
        return null;
    }
}
