package com.tosix7.api.service;


import com.tosix7.param.PageParam;
import com.tosix7.result.DubboResult;
import com.tosix7.result.PageResult;

/**
 * 产品接口
 */

public interface ProductService {

    /**
     * 根据产品类型查询产品信息并分页
     * @param pageParam
     * @param prodType 产品类型
     * @return 返回DubboResult<PageResult>
     */
    DubboResult<PageResult> getProductByType(PageParam pageParam, Integer prodType);
}
