package com.tosix7.result;

public interface ResultStatus {

    /**
     * 错误状态码
     * @return
     */
    Integer errorCode();

    /**
     * 异常信息
     * @return
     */
    String errorMsg();

    Integer DUBBO_SUCCESS_CODE=0;

    Integer DUBBO_FAILED_CODE=-1;

    String DUBBO_SUCCESS_MSG="执行成功";

    String DUBBO_FAILED_MSG="执行失败";

    Integer RESPONSE_SUCCESS_CODE=200;
    Integer RESPONSE_FAILED_CODE=500;

    String RESPONSE_SUCCESS_MSG="请求成功";
    String RESPONSE_FAILED_MSG="请求失败";
}
