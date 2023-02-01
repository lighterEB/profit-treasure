package com.tosix7.result;

import com.tosix7.constant.ResultStatusImpl;

import java.io.Serializable;
import java.util.HashMap;
import java.util.List;

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

    public DubboResult(ResultStatusImpl resultStatus, Object data) {
        this.code = resultStatus.errorCode();
        this.message = resultStatus.errorMsg();
        this.data = data;
    }

    public static DubboResult<Void> success(){
        return new DubboResult<Void>(ResultStatusImpl.SUCCESS, null);
    }
}
