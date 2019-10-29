package com.radebit.intbarsys.utils;

import org.springframework.stereotype.Component;

/**
 * @Author Rade
 * @Date 2019-10-29 10:34
 * 说明：
 */

@Component
public interface TokenGenerator {

    public String generate(String... strings);

}