package com.tosix7.dataservice.service.external;

import com.github.pagehelper.Page;
import com.tosix7.api.service.ProductService;
import com.tosix7.dataservice.service.internal.IProductService;
import com.tosix7.param.PageParam;
import com.tosix7.result.DubboResult;
import com.tosix7.result.PageResult;
import org.apache.dubbo.config.annotation.DubboService;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.HashMap;

@DubboService
@SuppressWarnings("all")
public class ProductServiceImpl implements ProductService {

    @Autowired
    IProductService productService;


    @Override
    public DubboResult<PageResult> getProductByType(PageParam pageParam, Integer prodType) {
        PageResult pageResult = productService.findProductByType(pageParam, prodType);
        return DubboResult.success(pageResult);
    }
}
