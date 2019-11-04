package com.radebit.intbarsys.service.impl;

import cn.hutool.core.lang.Assert;
import cn.hutool.crypto.SecureUtil;
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
        return adminMapper.findAdminById(id);
    }

    @Override
    public Admin findAdminByUsername(String username) {
        return adminMapper.findAdminByUsername(username);
    }

    @Override
    public String findPasswordByUsername(String username) {
        return adminMapper.findPasswordByUsername(username);
    }

    @Override
    public boolean checkPassword(String username, String password) {
        String relPassword = adminMapper.findPasswordByUsername(username);
        String md5Password = SecureUtil.md5(password);
        if (relPassword == null){
            return false;
        }
        return relPassword.equals(md5Password);
    }

    @Override
    public Integer update(Admin admin) {
        return adminMapper.update(admin);
    }

    @Override
    public Integer delete(int id) {
        return adminMapper.delete(id);
    }

    @Override
    public Integer save(Admin admin) {
        return adminMapper.save(admin);
    }
}
