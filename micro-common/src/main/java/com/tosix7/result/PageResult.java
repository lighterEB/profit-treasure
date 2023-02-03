package com.tosix7.result;

import java.util.List;

/**
 * 分页返回数据
 */
public class PageResult {
    /**
     * 当前页码
     */
    private int pageNum;

    /**
     * 每页数量
     */
    private int pageSize;


    /**
     * 记录总数
     */
    private long totalSize;

    public PageResult() {
    }

    public PageResult(int pageNum, int pageSize, long totalSize, int totalPages, List<?> content) {
        this.pageNum = pageNum;
        this.pageSize = pageSize;
        this.totalSize = totalSize;
        this.totalPages = totalPages;
        this.content = content;
    }

    @Override
    public String toString() {
        return "PageResult{" +
                "pageNum=" + pageNum +
                ", pageSize=" + pageSize +
                ", totalSize=" + totalSize +
                ", totalPages=" + totalPages +
                ", content=" + content +
                '}';
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

    public long getTotalSize() {
        return totalSize;
    }

    public void setTotalSize(long totalSize) {
        this.totalSize = totalSize;
    }

    public int getTotalPages() {
        return totalPages;
    }

    public void setTotalPages(int totalPages) {
        this.totalPages = totalPages;
    }

    public List<?> getContent() {
        return content;
    }

    public void setContent(List<?> content) {
        this.content = content;
    }

    /**
     * 页码总数
     */
    private int totalPages;

    /**
     * 分页数据
     */
    private List<?> content;
}
