package com.tosix7.result;

import com.tosix7.enumerate.DubboResultEnum;
import com.tosix7.result.impl.ResultStatusImpl;

import java.io.Serializable;

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
    private Object data;

    public DubboResult(DubboResultEnum dubboResultEnum, Object data) {
        this.code = dubboResultEnum.getStatusCode();
        this.message = dubboResultEnum.getMessage();
        this.data = data;
    }

    public DubboResult() {
        this.code = ResultStatus.RESPONSE_SUCCESS_CODE;
        this.message = ResultStatus.DUBBO_SUCCESS_MSG;
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

    public void setData(Object data) {
        this.data = data;
    }

    public static DubboResult<Void> success(){
        return new DubboResult<Void>(DubboResultEnum.DUBBO_SUCCESS, null);
    }

    public static <T> DubboResult<T> success(T data){
        return new DubboResult<T>(DubboResultEnum.DUBBO_SUCCESS, data);
    }

    public static DubboResult<Void> failure(){
        return new DubboResult<Void>(DubboResultEnum.DUBBO_FAILED, null);
    }
}
