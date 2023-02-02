package com.tosix7.dataservice.service.external;

import com.tosix7.constant.ResponseKey;
import com.tosix7.dataservice.mapper.BidMapper;
import com.tosix7.dataservice.mapper.ProductMapper;
import com.tosix7.dataservice.mapper.UserMapper;
import com.tosix7.info.ProductInfo;
import com.tosix7.result.DubboResult;
import com.tosix7.api.service.IndexService;
import org.apache.dubbo.config.annotation.DubboService;
import org.springframework.beans.factory.annotation.Autowired;

import java.math.BigDecimal;
import java.util.HashMap;
import java.util.List;

@DubboService
public class IndexServiceImpl implements IndexService {

    @Autowired
    BidMapper bidMapper;

    @Autowired
    ProductMapper productMapper;

    @Autowired
    UserMapper userMapper;

    /**
     * 查询首页热点数据 --
     * 用户总数
     * 历史年化收益率
     * 总投资金额
     *
     * @return
     */

    @Override
    public DubboResult<HashMap<String, BigDecimal>> getHotData() {
        HashMap<String, BigDecimal> data = new HashMap<>();
        BigDecimal hotCountUser = BigDecimal.valueOf(userMapper.getCountUser());
        BigDecimal hotRate = productMapper.findAvgRate();
        BigDecimal hotCountBidMoney = bidMapper.findCountBidMoney();
        if (hotRate == null || hotCountBidMoney == null){
            return DubboResult.failure();
        }else{
            data.put(ResponseKey.HOT_RATE, hotRate);
            data.put(ResponseKey.HOT_COUNT_USER, hotCountUser);
            data.put(ResponseKey.HOT_COUNT_BID_MONEY, hotCountBidMoney);
            return DubboResult.success(data);
        }

    }

    @Override
    public DubboResult<HashMap<String, List<ProductInfo>>> getProductData() {
        return null;
    }
}
