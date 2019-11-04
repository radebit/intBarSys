package com.radebit.intbarsys.exception;

import com.radebit.intbarsys.domain.JsonData;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * @Author Rade
 * @Date 2019-11-04 18:43
 * 说明：全局异常处理控制器
 */
@ControllerAdvice
public class CommonExceptionHandler {

    @ExceptionHandler(value = Exception.class)
    @ResponseBody
    public JsonData Handler(Exception e) {
        if (e instanceof CommonException) {
            CommonException commonException = (CommonException) e;
            return JsonData.buildError(commonException.getMessage(), commonException.getCode());
        } else {
            return JsonData.buildError("未知错误！");
        }

    }
}
