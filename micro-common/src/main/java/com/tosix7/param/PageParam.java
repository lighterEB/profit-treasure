package com.tosix7.param;

import java.io.Serializable;
import java.util.HashMap;
import java.util.Map;

/**
 * 分页请求
 */
public class PageParam implements Serializable {

    private int pageNum = 1;

    private int pageSize = 5;

    @Override
    public String toString() {
        return "PageParam{" +
                "pageNum=" + pageNum +
                ", pageSize=" + pageSize +
                ", params=" + params +
                '}';
    }

    private Map<String, Object> params = new HashMap<>();

    public PageParam(int pageNum, int pageSize, Map<String, Object> params) {
        this.pageNum = pageNum;
        this.pageSize = pageSize;
        this.params = params;
    }

    public PageParam() {
    }

    public int getPageNum() {
        return pageNum;
    }

    public void setPageNum(int pageNum) {
        this.pageNum = pageNum;
    }

    public int getPageSize() {
        return pageSize;
    }

    public void setPageSize(int pageSize) {
        this.pageSize = pageSize;
    }

    public Map<String, Object> getParams() {
        return params;
    }

    public void setParams(Map<String, Object> params) {
        this.params = params;
    }
}
