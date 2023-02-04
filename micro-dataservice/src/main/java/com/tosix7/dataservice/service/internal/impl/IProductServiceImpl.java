package com.tosix7.dataservice.service.internal.impl;

import com.tosix7.constant.MethodKey;
import com.tosix7.dataservice.mapper.ProductMapper;
import com.tosix7.dataservice.service.internal.IProductService;
import com.tosix7.info.ProductInfo;
import com.tosix7.param.PageParam;
import com.tosix7.result.PageResult;
import com.tosix7.utils.MybatisPageHelper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;

/**
 * 产品查询接口实现类
 */

@Service
public class IProductServiceImpl implements IProductService {

    @Autowired
    ProductMapper productMapper;
    @Override
    public int save(ProductInfo record) {
        return 0;
    }

    @Override
    public int delete(ProductInfo record) {
        return 0;
    }

    @Override
    public int delete(List<ProductInfo> records) {
        return 0;
    }

    @Override
    public ProductInfo findById(Long id) {
        return null;
    }

    @Override
    public PageResult findPage(PageParam pageParam) {
        return MybatisPageHelper.findPage(pageParam, productMapper);
    }

    @Override
    public PageResult findProductByType(Integer pageNum, Integer pageSize, Integer prodType) {
        PageParam pageParam = new PageParam();
        pageParam.setPageNum(pageNum);
        pageParam.setPageSize(pageSize);
        return MybatisPageHelper.findPage(pageParam, productMapper, MethodKey.FIND_BY_PRODUCT_TYPE, prodType);
    }
}
