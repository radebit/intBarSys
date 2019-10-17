package com.radebit.intbarsys.mapper;

import com.radebit.intbarsys.model.po.Activity;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Options;
import org.apache.ibatis.annotations.Select;

import java.util.List;

/**
 * @Author Rade
 * @Date 2019-10-17 10:00
 * 说明：
 */
public interface ActivityMapper {

    @Select("select * from r_activity where id = #{id}")
    Activity findActivityById(int id);

    @Select("select * from r_activity where title like '%#{title}%'")
    List<Activity> findActivityListByTitle(String title);

    @org.apache.ibatis.annotations.UpdateProvider(type = com.radebit.intbarsys.provider.UpdateProvider.class,method = "updateActivity")
    Integer update(Activity activity);

    @Delete("delete from r_activity where id = #{id}")
    Integer delete(int id);

    @Insert("INSERT INTO r_activity(`title`, `category`, `reg_method`, `format`, `contact`, `phone`, `start_time`, `end_time`, `place`, `reward_first`, `reward_second`, `reward_third`, `reward_other`, `details`, `attention`, `logo`, `banner`, `rules`) VALUES (#{title},#{category},#{reg_method},#{format},#{contact},#{phone},#{start_time},#{end_time},#{place},#{reward_first},#{reward_second},#{reward_third},#{reward_other},#{details},#{attention},#{logo},#{banner},#{rules})")
    @Options(useGeneratedKeys = true,keyProperty = "id",keyColumn = "id")
    Integer save(Activity activity);

}
