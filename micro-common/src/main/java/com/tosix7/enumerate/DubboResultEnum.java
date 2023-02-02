package com.tosix7.enumerate;

import com.tosix7.constant.DubboKey;

/**
 * Dubbo服务返回状态枚举类
 */
public enum DubboResultEnum {
    DUBBO_SUCCESS(DubboKey.DUBBO_SUCCESS_CODE, DubboKey.DUBBO_SUCCESS_MSG),
    DUBBO_FAILED(DubboKey.DUBBO_FAILED_CODE, DubboKey.DUBBO_FAILED_MSG)
    ;

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

    DubboResultEnum(Integer statusCode, String message) {
        this.statusCode = statusCode;
        this.message = message;
    }
}
