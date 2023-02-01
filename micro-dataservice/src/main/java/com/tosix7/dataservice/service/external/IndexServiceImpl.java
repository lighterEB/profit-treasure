package com.tosix7.dataservice.service.external;

import com.tosix7.info.ProductInfo;
import com.tosix7.result.DubboResult;
import com.tosix7.api.service.IndexService;
import org.apache.dubbo.config.annotation.DubboService;

import java.math.BigDecimal;
import java.util.HashMap;
import java.util.List;

@DubboService
public class IndexServiceImpl implements IndexService {

    @Override
    public DubboResult<HashMap<String, BigDecimal>> getHotData() {
        return null;
    }

    @Override
    public DubboResult<HashMap<String, List<ProductInfo>>> getProductData() {
        return null;
    }
}
