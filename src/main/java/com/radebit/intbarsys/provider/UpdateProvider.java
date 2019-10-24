package com.radebit.intbarsys.provider;

import com.radebit.intbarsys.model.po.Activity;
import com.radebit.intbarsys.model.po.Admin;
import com.radebit.intbarsys.model.po.Dictionary;
import org.apache.ibatis.jdbc.SQL;

/**
 * @Author Rade
 * @Date 2019-09-08 13:39
 * 说明：更新数据动态更新
 */
public class UpdateProvider {

    /**
     * 字典表条件更新
     *
     * @param dictionary
     * @return
     */
    public String updateDictionary(final Dictionary dictionary) {
        return new SQL() {{

            UPDATE("r_dictionary");

            //条件写法.
            if (dictionary.getDicKey() != null) {
                SET("dic_key = #{dicKey}");
            }
            if (dictionary.getDicValue() != null) {
                SET("dic_value = #{dicValue}");
            }
            if (dictionary.getDicAttach() != null) {
                SET("dic_attach = #{dicAttach}");
            }
            if (dictionary.getDicNote() != null) {
                SET("dic_note = #{dicNote}");
            }

            WHERE("id = #{id}");

        }}.toString();
    }

    /**
     * 管理员表条件动态更新
     *
     * @param admin
     * @return
     */
    public String updateAdmin(final Admin admin) {
        return new SQL() {{

            UPDATE("r_admin");

            if (admin.getUsername() != null) {
                SET("username = #{username}");
            }
            if (admin.getPassword() != null) {
                SET("password = #{password}");
            }
            if (admin.getLastLoginTime() != null) {
                SET("last_login_time = #{lastLoginTime}");
            }
            if (admin.getLastLoginIp() != null) {
                SET("last_login_ip = #{lastLoginIp}");
            }

            WHERE("id = #{id}");
        }}.toString();
    }

    /**
     * 比赛活动表条件动态更新
     *
     * @param activity
     * @return
     */
    public String updateActivity(final Activity activity) {
        return new SQL() {{
            UPDATE("r_activity");

            if (activity.getTitle() != null) {
                SET("title = #{title}");
            }
            if (activity.getCategory() != null) {
                SET("category = #{category}");
            }
            if (activity.getRegMethod() != null) {
                SET("reg_method = #{regMethod}");
            }
            if (activity.getFormat() != null) {
                SET("format = #{format}");
            }
            if (activity.getContact() != null) {
                SET("contact = #{contact}");
            }
            if (activity.getPhone() != null) {
                SET("phone = #{phone}");
            }
            if (activity.getStartTime() != null) {
                SET("start_time = #{startTime}");
            }
            if (activity.getEndTime() != null) {
                SET("end_time = #{endTime}");
            }
            if (activity.getPlace() != null) {
                SET("place = #{place}");
            }
            if (activity.getRewardFirst() != null) {
                SET("reward_first = #{rewardFirst}");
            }
            if (activity.getRewardSecond() != null) {
                SET("reward_second = #{rewardSecond}");
            }
            if (activity.getRewardThird() != null) {
                SET("reward_third = #{rewardThird}");
            }
            if (activity.getRewardOther() != null) {
                SET("reward_other = #{rewardOther}");
            }
            if (activity.getDetails() != null) {
                SET("details = #{details}");
            }
            if (activity.getAttention() != null) {
                SET("attention = #{attention}");
            }
            if (activity.getLogo() != null) {
                SET("logo = #{logo}");
            }
            if (activity.getBanner() != null) {
                SET("banner = #{banner}");
            }
            if (activity.getRules() != null) {
                SET("rules = #{rules}");
            }

            WHERE("id = #{id}");
        }}.toString();
    }
}
