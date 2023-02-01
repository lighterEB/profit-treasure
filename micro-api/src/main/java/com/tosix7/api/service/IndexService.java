package com.tosix7.api.service;

import com.tosix7.info.ProductInfo;
import com.tosix7.result.impl.DubboResult;

import java.math.BigDecimal;
import java.util.HashMap;
import java.util.List;

/**
 * 首页服务接口
 */
public interface IndexService {

    /**
     * 查询首页的热点数据
     */
    public DubboResult<HashMap<String, BigDecimal>> getHotData();

    /**
     * 查询首页的产品信息
     */
    public DubboResult<HashMap<String, List<ProductInfo>>> getProductData();

}
