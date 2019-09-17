package com.radebit.intbarsys.provider;

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
}
