package com.tosix7.result;

import com.tosix7.enumerate.DubboResultEnum;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.HashMap;

/**
 * 统一duboo接口调用服务类
 * @param <T>
 */
public class DubboResult<T> implements Serializable {

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

    public DubboResult(DubboResultEnum dubboResultEnum, T data) {
        this.code = dubboResultEnum.getStatusCode();
        this.message = dubboResultEnum.getMessage();
        this.data = data;
    }

    public DubboResult() {
    }

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

    public Object getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }


    /**
     * 回调成功静态方法无数据
     * @return
     */

    public static DubboResult<Void> success(){
        return new DubboResult<Void>(DubboResultEnum.DUBBO_SUCCESS, null);
    }


    /**
     * 回调成功静态方法有数据
     * @return
     */

    public static <T> DubboResult<T> success(T data){
        return new DubboResult<>(DubboResultEnum.DUBBO_SUCCESS, data);
    }

    public static <T> DubboResult<T> failure(){
        return new DubboResult<T>(DubboResultEnum.DUBBO_FAILED, null);
    }
}
