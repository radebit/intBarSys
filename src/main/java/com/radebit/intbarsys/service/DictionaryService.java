package com.radebit.intbarsys.service;

import com.radebit.intbarsys.model.po.Dictionary;


/**
 * @Author Rade
 * @Date 2019-09-08 11:27
 * 说明：字典接口
 */
public interface DictionaryService {

    /**
     * 通过ID找字典
     * @param id
     * @return
     */
    Dictionary findDicById(int id);

    /**
     * 通过Key拿Value
     * @param key
     * @return
     */
    String findDicByKey(String key);

    /**
     * 更新字典
     * @param dictionary
     * @return
     */
    int update(Dictionary dictionary);

    /**
     * 删除字典
     * @param id
     * @return
     */
    int delete(int id);

    /**
     * 保存字典
     * @param dictionary
     * @return
     */
    int save(Dictionary dictionary);


}
