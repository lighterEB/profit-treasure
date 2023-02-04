package com.tosix7.dataservice.service.internal;

import com.tosix7.info.ProductInfo;
import com.tosix7.param.PageParam;
import com.tosix7.result.PageResult;

/**
 * 产品查询接口
 */
public interface IProductService extends CurdService<ProductInfo>{
    PageResult findProductByType(Integer pageNum, Integer pageSize, Integer prodType);
}
