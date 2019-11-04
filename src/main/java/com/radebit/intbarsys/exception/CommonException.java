package com.radebit.intbarsys.exception;

/**
 * @Author Rade
 * @Date 2019-11-04 18:38
 * 说明：通用自定义异常类
 */
public class CommonException extends RuntimeException {

    private Integer code;   //状态码
    private String message; //异常信息

    public CommonException(int code, String message) {
        super(message);
        this.code = code;
        this.message = message;
    }

    public Integer getCode() {
        return code;
    }

    public void setCode(Integer code) {
        this.code = code;
    }

    @Override
    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}
