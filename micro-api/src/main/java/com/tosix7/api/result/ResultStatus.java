package com.tosix7.api.result;

public interface ResultStatus {

    /**
     * 状态码
     * @return
     */
    Integer errorCode();

    /**
     * 异常信息
     * @return
     */
    String errorMsg();
}
