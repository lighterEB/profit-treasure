package com.tosix7.utils;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.tosix7.param.PageParam;
import com.tosix7.result.PageResult;
import org.springframework.util.ReflectionUtils;

import java.lang.reflect.Method;
import java.util.List;

/**
 * 分页查询助手
 */

public class MybatisPageHelper {

    public static final String findPage = "findPage";

    public static PageResult findPage(PageParam pageParam, Object mapper) {
        return findPage(pageParam, mapper, findPage);
    }

    @SuppressWarnings({ "unchecked", "rawtypes" })
    public static PageResult findPage(PageParam pageParam, Object mapper, String queryMethodName, Object... args){
        // 设置分页参数
        int pageNum = pageParam.getPageNum();
        int pageSize = pageParam.getPageSize();
        PageHelper.startPage(pageNum, pageSize);

        Object result = ReflectionUtils.invoke(mapper, queryMethodName, args);
        return getPageResult(pageParam, new PageInfo((List) result));
    }

    private static PageResult getPageResult(PageParam pageParam, PageInfo<?> pageInfo) {
        PageResult pageResult = new PageResult();
        pageResult.setPageNum(pageInfo.getPageNum());
        pageResult.setPageSize(pageInfo.getPageSize());
        pageResult.setTotalSize(pageInfo.getTotal());
        pageResult.setTotalPages(pageInfo.getPages());
        pageResult.setContent(pageInfo.getList());

        return pageResult;
    }
}
