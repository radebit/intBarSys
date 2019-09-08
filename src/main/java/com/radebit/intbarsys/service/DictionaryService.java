package com.radebit.intbarsys.service;

import com.radebit.intbarsys.model.po.RDictionary;

import java.util.Map;

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
    Map<String, String> findDicMapById(int id);

    /**
     * 通过Key拿Value
     * @param key
     * @return
     */
    String findDicByKey(String key);

    /**
     * 更新字典
     * @param rDictionary
     * @return
     */
    int update(RDictionary rDictionary);

    /**
     * 删除字典
     * @param id
     * @return
     */
    int delete(int id);

    /**
     * 保存字典
     * @param rdictionary
     * @return
     */
    int save(RDictionary rdictionary);


}
