package com.tosix7.api.service;


import com.tosix7.result.DubboResult;
import com.tosix7.result.PageResult;

/**
 * 产品接口
 */

public interface ProductService {

    /**
     * 根据产品类型查询产品信息并分页
     * @param pageNum 页码
     * @param pageSize 页面数据条数
     * @param prodType 产品类型
     * @return 返回DubboResult<PageResult>
     */
    DubboResult<PageResult> getProductByType(Integer pageNum, Integer pageSize, Integer prodType);
}
