package com.radebit.intbarsys.mapper;
import com.radebit.intbarsys.model.po.Dictionary;
import com.radebit.intbarsys.provider.DictionaryProvider;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.UpdateProvider;

import java.util.List;
/**
 * @Author Rade
 * @Date 2019-09-08 11:39
 * 说明：
 */
public interface DictionaryMapper {

    /**
     * 查找所有字典
     * @return
     */
    @Select("select * from r_dictionary")
    List<Dictionary> findAll();

    /**
     * 通过ID找字典
     * @param id
     * @return
     */
    @Select("select * from r_dictionary where id = #{id}")
    Dictionary findDicMapById(int id);

    /**
     * 通过Key找字典
     * @param key
     * @return
     */
    @Select("select * from r_dictionary where key = #{key}")
    String findDicByKey(String key);

    /**
     * 更新字典
     * @param dictionary
     * @return
     */
    @UpdateProvider(type = DictionaryProvider.class,method = "updateDictionary")
    int update(Dictionary dictionary);

    /**
     * 删除字典
     * @param id
     * @return
     */
    @Delete("DELETE FROM r_dictionary WHERE id =#{id}")
    int delete(int id);

    /**
     * 保存字典
     * @param dictionary
     * @return
     */
    int save(Dictionary dictionary);

}
