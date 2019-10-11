package com.radebit.intbarsys.mapper;

import com.radebit.intbarsys.model.po.Admin;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Options;
import org.apache.ibatis.annotations.Select;

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
     * 通过用户名查找密码
     * @param username
     * @return
     */
    @Select("select password from r_admin where username = #{username}")
    String findPasswordByUsername(String username);

    /**
     * 更新管理员信息
     * @param admin
     * @return
     */
    @org.apache.ibatis.annotations.UpdateProvider(type = com.radebit.intbarsys.provider.UpdateProvider.class,method = "updateAdmin")
    Integer update(Admin admin);

    /**
     * 删除管理员
     * @param id
     * @return
     */
    @Delete("delete from r_admin where id = #{id}")
    Integer delete(int id);

    /**
     * 新增管理员
     * @param admin
     * @return
     */
    @Insert("INSERT INTO `intbarsys`.`r_admin`( `username`, `password`, `last_login_time`, `last_login_ip`) VALUES ( #{username},#{password},#{lastLoginTime},#{lastLoginIp});")
    @Options(useGeneratedKeys = true,keyProperty = "id",keyColumn = "id")
    Integer save(Admin admin);


}
