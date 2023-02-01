package com.tosix7.constant;


import com.tosix7.api.result.ResultStatus;

/**
 * 系统常量类
 */
public enum ResultStatusImpl implements ResultStatus {
    /**
     * 状态码及对应信息
     */
    //成功状态码
    SUCCESS(0, "请求执行成功"),
    FAILED(-1,"请求执行失败");
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
