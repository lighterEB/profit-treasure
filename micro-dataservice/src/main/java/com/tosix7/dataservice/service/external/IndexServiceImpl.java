package com.tosix7.dataservice.service.external;

import com.tosix7.dataservice.service.internal.impl.IHotServiceImpl;
import com.tosix7.info.ProductInfo;
import com.tosix7.result.DubboResult;
import com.tosix7.api.service.IndexService;
import org.apache.dubbo.config.annotation.DubboService;
import org.springframework.beans.factory.annotation.Autowired;
import java.math.BigDecimal;
import java.util.HashMap;
import java.util.List;

@DubboService
@SuppressWarnings("all")
public class IndexServiceImpl implements IndexService {

    @Autowired
    IHotServiceImpl hotService;

    @Override
    public DubboResult<HashMap<String, BigDecimal>> getHotData() {
        HashMap<String,BigDecimal> data = hotService.findHotData();
        if (data==null){
            return DubboResult.failure();
        }else{
            return DubboResult.success(data);
        }

    }

    @Override
    public DubboResult<HashMap<String, List<ProductInfo>>> getProductData() {
        return null;
    }
}
