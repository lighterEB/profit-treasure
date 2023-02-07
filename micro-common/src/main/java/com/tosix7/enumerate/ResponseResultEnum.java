package com.tosix7.enumerate;

import com.tosix7.constant.ResponseKey;

/**
 * 前端业务请求返回状态结果枚举类
 */
public enum ResponseResultEnum {

    RESPONSE_SUCCESS(ResponseKey.REQUEST_SUCCESS_CODE, ResponseKey.REQUEST_SUCCESS_MSG),
    RESPONSE_FAILED(ResponseKey.REQUEST_FAILED_CODE, ResponseKey.REQUEST_FAILED_MSG),
    RESPONSE_LOGIN_SUCCESS(ResponseKey.LOGIN_SUCCESS_CODE, ResponseKey.LOGIN_SUCCESS),
    RESPONSE_LOGIN_FAILED(ResponseKey.LOGIN_FAILED_CODE, ResponseKey.LOGIN_FAILED),
    RESPONSE_USER_NOT_FOUND(ResponseKey.USER_NOT_FOUND_CODE, ResponseKey.USER_NOT_FOUND);

    private Integer statusCode;
    private String message;

    public Integer getStatusCode() {
        return statusCode;
    }

    public void setStatusCode(Integer statusCode) {
        this.statusCode = statusCode;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    ResponseResultEnum(Integer statusCode, String message) {
        this.statusCode = statusCode;
        this.message = message;
    }
}
