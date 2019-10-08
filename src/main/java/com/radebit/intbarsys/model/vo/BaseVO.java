package com.radebit.intbarsys.model.vo;

import java.io.Serializable;

/**
 * @Author Rade
 * @Date 2019-10-01 17:55
 * 说明：基础字段信息
 */
public class BaseVO implements Serializable {

    private String additional;

    public String getAdditional() {
        return additional;
    }

    public void setAdditional(String additional) {
        this.additional = additional;
    }
}
