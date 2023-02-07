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

    public ResponseResult() {
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
        return new ResponseResult<>(ResponseResultEnum.RESPONSE_SUCCESS, null);
    }

    /**
     * 响应成功结果-有数据
     * @param data 数据对象
     * @return
     * @param <T>
     */

    public static <T> ResponseResult<T> success(T data){
        return new ResponseResult<>(ResponseResultEnum.RESPONSE_SUCCESS, data);
    }

    /**
     * 响应失败结果
     * @return
     */
    public static ResponseResult<String> failure(){
        return new ResponseResult<>(ResponseResultEnum.RESPONSE_FAILED, "");
    }

    /**
     * 登录成功响应
     */
    public static<UserInfo> ResponseResult<UserInfo> loginSuccess(UserInfo userInfo) {
        return new ResponseResult<>(ResponseResultEnum.RESPONSE_LOGIN_SUCCESS, userInfo);
    }

    /**
     * 登录失败响应
     */
    public static<Void> ResponseResult<Void> loginFailed() {
        return new ResponseResult<Void>(ResponseResultEnum.RESPONSE_LOGIN_FAILED, null);
    }

    /**
     * 用户不存在响应
     */
    public static<Void> ResponseResult<Void> userNotFound() {
        return new ResponseResult<Void>(ResponseResultEnum.RESPONSE_USER_NOT_FOUND, null);
    }
}
