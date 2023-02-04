package com.tosix7.dataservice.service.external;

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
    public DubboResult<PageResult> getProductByType(Integer pageNum, Integer pageSize, Integer prodType) {
        PageResult pageResult = productService.findProductByType(pageNum, pageSize, prodType);
        return DubboResult.success(pageResult);
    }
}
