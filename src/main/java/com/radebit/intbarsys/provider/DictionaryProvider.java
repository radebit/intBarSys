package com.radebit.intbarsys.provider;

import com.radebit.intbarsys.model.po.Dictionary;
import org.apache.ibatis.jdbc.SQL;

/**
 * @Author Rade
 * @Date 2019-09-08 13:39
 * 说明：字典数据动态更新
 */
public class DictionaryProvider {

    public String updateDictionary(final Dictionary dictionary) {
        return new SQL() {{

            UPDATE("r_dictionary");

            //条件写法.
            if (dictionary.getKey() != null) {
                SET("key=#{key}");
            }
            if (dictionary.getValue() != null) {
                SET("value=#{value}");
            }
            if (dictionary.getAttach() != null) {
                SET("attach=#{attach}");
            }
            if (dictionary.getNote() != null) {
                SET("note=#{note}");
            }

            WHERE("id=#{id}");

        }}.toString();
    }
}
