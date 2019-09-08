package com.radebit.intbarsys.mapper;
import com.radebit.intbarsys.model.po.Dictionary;
import com.radebit.intbarsys.provider.DictionaryProvider;
import org.apache.ibatis.annotations.*;

import java.util.List;
/**
 * @Author Rade
 * @Date 2019-09-08 11:39
 * 说明：字典表Mapper
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
    Dictionary findDicById(int id);

    /**
     * 通过Key找字典
     * @param key
     * @return
     */
    @Select("select * from r_dictionary where dic_key = #{dicKey}")
    Dictionary findDicByKey(String key);

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
    @Insert("INSERT INTO `intbarsys`.`r_dictionary`(`dic_key`, `dic_value`, `dic_attach`, `dic_note`) VALUES (#{dicKey}, #{dicValue}, #{dicAttach}, #{dicNote});")
    @Options(useGeneratedKeys=true, keyProperty="id", keyColumn="id")
    int save(Dictionary dictionary);

}
