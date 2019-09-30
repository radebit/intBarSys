package com.radebit.intbarsys.service;

import com.radebit.intbarsys.model.po.Admin;

/**
 * @Author Rade
 * @Date 2019-09-14 14:26
 * 说明：管理员业务接口
 */
public interface AdminService {

    Admin findAdminById(int id);

    Admin findAdminByUsername(String username);

    boolean checkPassword(String username,String password);

    Admin update(Admin admin);

    int delete(int id);

    int save(Admin admin);
}
