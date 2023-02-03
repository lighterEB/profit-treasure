package com.tosix7.dataservice.service.internal;

import com.tosix7.param.PageParam;
import com.tosix7.result.PageResult;
import org.springframework.http.HttpStatus;

import java.util.List;

/**
 * 通用CURD接口
 */
public interface CurdService<T> {

    /**
     * 保存操作
     * @param record
     * @return
     */
    int save(T record);

    /**
     * 删除操作
     * @param record
     * @return
     */
    int delete(T record);

    /**
     * 批量删除
     * @param records
     * @return
     */
    int delete(List<T> records);

    /**
     * 根据ID查询
     * @param id
     * @return
     */
    T findById(Long id);


    /**
     * 分页查询
     * @param pageParam
     * @return
     */
    PageResult findPage(PageParam pageParam);
}
