package com.radebit.intbarsys.mapper;

import com.radebit.intbarsys.model.po.Admin;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.UpdateProvider;

/**
 * @Author Rade
 * @Date 2019-09-14 14:27
 * 说明：管理员用户表Mapper
 */
public interface AdminMapper {

    /**
     * 通过ID找管理员
     * @param id
     * @return
     */
    @Select("select * from r_admin where id = #{id}")
    Admin findAdminById(int id);

    /**
     * 通过用户名找管理员
     * @param username
     * @return
     */
    @Select("select * from r_admin where username = #{username}")
    Admin findAdminByUsername(String username);

    /**
     * 更新管理员信息
     * @param admin
     * @return
     */
    @org.apache.ibatis.annotations.UpdateProvider(type = com.radebit.intbarsys.provider.UpdateProvider.class,method = "updateAdmin")
    int update(Admin admin);


}
