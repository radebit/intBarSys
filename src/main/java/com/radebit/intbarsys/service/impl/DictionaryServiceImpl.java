package com.radebit.intbarsys.service.impl;

import com.radebit.intbarsys.mapper.DictionaryMapper;
import com.radebit.intbarsys.model.po.Dictionary;
import com.radebit.intbarsys.service.DictionaryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @Author Rade
 * @Date 2019-09-08 11:37
 * 说明：字典接口实现
 */
@Service
public class DictionaryServiceImpl implements DictionaryService {

    @Autowired
    private DictionaryMapper dictionaryMapper;

    @Override
    public Dictionary findDicById(int id) {
        return dictionaryMapper.findDicById(id);
    }

    @Override
    public String findDicByKey(String dicKey) {
        Dictionary dic = dictionaryMapper.findDicByKey(dicKey);
        return dic.getDicValue();
    }

    @Override
    public int update(Dictionary dictionary) {
        return dictionaryMapper.update(dictionary);
    }

    @Override
    public int delete(int id) {
        return dictionaryMapper.delete(id);
    }

    @Override
    public int save(Dictionary dictionary) {
        return dictionaryMapper.save(dictionary);
    }
}
