package com.tosix7.result;

import java.io.Serializable;

/**
 * 统一duboo接口调用服务类
 * @param <T>
 */
public class DubboResult<T> implements Serializable {

    /**
     * 结果状态码
     */
    private Integer code;

    /**
     * 结果信息
     */
    private String message;

    /**
     * 返回的数据
     */
    private T data;

    @Override
    public String toString() {
        return "DubboResult{" +
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

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }

    public DubboResult(Integer code, String message, T data) {
        this.code = code;
        this.message = message;
        this.data = data;
    }

    public DubboResult() {
    }
}
