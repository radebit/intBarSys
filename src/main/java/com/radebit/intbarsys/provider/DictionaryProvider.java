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
            if (dictionary.getDicKey() != null) {
                SET("dic_key=#{dicKey}");
            }
            if (dictionary.getDicValue() != null) {
                SET("dic_value=#{dicValue}");
            }
            if (dictionary.getDicAttach() != null) {
                SET("dic_attach=#{dicAttach}");
            }
            if (dictionary.getDicNote() != null) {
                SET("dic_note=#{dicNote}");
            }

            WHERE("id=#{id}");

        }}.toString();
    }
}
