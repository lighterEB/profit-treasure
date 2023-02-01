package com.tosix7.result.impl;

import com.tosix7.result.ResultStatus;

/**
 * Web响应给Vue页面结果
 */
public class ResponseResult<T> {

    /**
     * 返回状态码
     */
    private Integer code;
    /**
     * 返回结果信息
     */
    private String message;
    /**
     * 返回的数据
     */
    private Object data;

    public ResponseResult(ResultStatusImpl resultStatus, Object data) {
        this.code = resultStatus.errorCode();
        this.message = resultStatus.errorMsg();
        this.data = data;
    }

    @Override
    public String toString() {
        return "ResponseResult{" +
                "code=" + code +
                ", message='" + message + '\'' +
                ", data=" + data +
                '}';
    }

    public Integer getCode() {
        return code;
    }

    public void setCode(Integer code) {
        this.code = code;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public Object getData() {
        return data;
    }

    public void setData(Object data) {
        this.data = data;
    }

    public static ResponseResult<Void> success(){
        return new ResponseResult<Void>(ResultStatusImpl.SUCCESS, null);
    }

    public static <T> ResponseResult<T> success(T data){
        return new ResponseResult<T>(ResultStatusImpl.SUCCESS, data);
    }

    public ResponseResult() {
        this.code = ResultStatus.RESPONSE_SUCCESS_CODE;
        this.message = ResultStatus.RESPONSE_SUCCESS_MSG;
    }
}
