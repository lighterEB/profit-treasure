package com.tosix7.result;

import com.tosix7.enumerate.ResponseResultEnum;

import java.io.Serializable;

/**
 * Web响应给Vue页面结果
 */
public class ResponseResult<T> implements Serializable {

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
    private T data;

    public ResponseResult(ResponseResultEnum responseResultEnum, T data) {
        this.code = responseResultEnum.getStatusCode();
        this.message = responseResultEnum.getMessage();
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

    public void setData(T data) {
        this.data = data;
    }


    /**
     * 响应成功结果-无数据
     * @return
     */
    public static ResponseResult<Void> success(){
        return new ResponseResult<Void>(ResponseResultEnum.RESPONSE_SUCCESS, null);
    }

    /**
     * 响应成功结果-有数据
     * @param data 数据对象
     * @return
     * @param <T>
     */

    public static <T> ResponseResult<T> success(T data){
        return new ResponseResult<T>(ResponseResultEnum.RESPONSE_SUCCESS, data);
    }

    /**
     * 响应失败结果
     * @return
     */
    public static ResponseResult<String> failure(){
        return new ResponseResult<String>(ResponseResultEnum.RESPONSE_FAILED, "");
    }
}
