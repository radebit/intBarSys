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
     * 通过ID找管理员账号
     * @param id
     * @return
     */
    @Select("select * from r_admin where id = #{id}")
    Admin findAdminById(int id);

    /**
     * 更新管理员信息
     * @param admin
     * @return
     */
    @UpdateProvider(type = UpdateProvider.class,method = "updateAdmin")
    int update(Admin admin);


}
