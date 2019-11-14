package com.radebit.intbarsys.controller;

import com.radebit.intbarsys.controller.annotation.AdminToken;
import com.radebit.intbarsys.domain.JsonData;
import com.radebit.intbarsys.model.po.Dictionary;
import com.radebit.intbarsys.service.DictionaryService;
import io.swagger.annotations.Api;
import org.apache.ibatis.annotations.Delete;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * @Author Rade
 * @Date 2019-11-14 08:54
 * 说明：字典模块控制器
 */
@Api(value = "字典模块")
@RestController
@RequestMapping("/api/v1/dictionary")
public class DictionaryController {

    @Autowired
    private DictionaryService dictionaryService;

    @GetMapping("DicId")
    public JsonData getDicById(int id){
        return JsonData.buildSuccess(dictionaryService.findDicById(id));
    }

    @GetMapping("DicName")
    public JsonData getDicByName(String name){
        return JsonData.buildSuccess(dictionaryService.findDicByKey(name));
    }

    @AdminToken()
    @DeleteMapping("delete")
    public JsonData deleteDic(int id){
        if (dictionaryService.delete(id) == 1){
            return JsonData.buildSuccess("删除成功！");
        }else {
            return JsonData.buildSuccess("删除失败！");
        }
    }

    @AdminToken
    @PostMapping("add")
    public JsonData addDic(@RequestParam(value = "dic_key")String dicKey,
                           @RequestParam(value = "dic_value")String dicValue,
                           @RequestParam(value = "dic_attach",required = false)String dicAttach,
                           @RequestParam(value = "dic_note")String dicNote){

        if (dicKey.isEmpty() || dicValue.isEmpty()){
            return JsonData.buildError("键值不能为空");
        }

        Dictionary dictionary = new Dictionary();
        dictionary.setDicKey(dicKey);
        dictionary.setDicValue(dicValue);
        dictionary.setDicAttach(dicAttach);
        dictionary.setDicNote(dicNote);

        if (dictionaryService.save(dictionary) == 1){
            return JsonData.buildSuccess("添加成功！");
        }else {
            return JsonData.buildError("添加失败！");
        }
    }
}
