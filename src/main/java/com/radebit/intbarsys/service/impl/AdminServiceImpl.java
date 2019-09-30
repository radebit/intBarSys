package com.radebit.intbarsys.service.impl;

import com.radebit.intbarsys.mapper.AdminMapper;
import com.radebit.intbarsys.model.po.Admin;
import com.radebit.intbarsys.service.AdminService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @Author Rade
 * @Date 2019-09-14 14:27
 * 说明：管理员接口实现
 */
@Service
public class AdminServiceImpl implements AdminService {
    @Autowired
    private AdminMapper adminMapper;

    @Override
    public Admin findAdminById(int id) {
        return null;
    }

    @Override
    public Admin findAdminByUsername(String username) {
        return null;
    }

    @Override
    public boolean checkPassword(String username, String password) {
        return false;
    }

    @Override
    public Admin update(Admin admin) {
        return null;
    }

    @Override
    public int delete(int id) {
        return 0;
    }

    @Override
    public int save(Admin admin) {
        return 0;
    }
}
