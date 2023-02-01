package com.tosix7.param;

import java.io.Serializable;

public class DubboParam<T> implements Serializable {
    private T param;

    @Override
    public String toString() {
        return "DubboParam{" +
                "param=" + param +
                '}';
    }

    public T getParam() {
        return param;
    }

    public void setParam(T param) {
        this.param = param;
    }

    public DubboParam() {
    }

    public DubboParam(T param) {
        this.param = param;
    }
}
