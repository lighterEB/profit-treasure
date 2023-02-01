package com.tosix7.result.impl;


import com.tosix7.result.ResultStatus;

/**
 * 返回状态枚举类
 */
public enum ResultStatusImpl implements ResultStatus {
    /**
     * 状态码及对应信息
     */
    //成功状态码
    SUCCESS(0, "请求执行成功"),
    FAILED(-1,"请求执行失败");

    //
    private final Integer errorCode;
    private final String errorMsg;
    ResultStatusImpl(int errorCode, String errorMsg){
        this.errorCode = errorCode;
        this.errorMsg = errorMsg;
    }

    public Integer errorCode() {
        return errorCode;
    }

    public String errorMsg() {
        return errorMsg;
    }

}
