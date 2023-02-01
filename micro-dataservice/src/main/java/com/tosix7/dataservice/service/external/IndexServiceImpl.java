package com.tosix7.dataservice.service.external;

import com.tosix7.constant.ConstantKey;
import com.tosix7.dataservice.mapper.BidMapper;
import com.tosix7.dataservice.mapper.ProductMapper;
import com.tosix7.dataservice.mapper.UserMapper;
import com.tosix7.info.ProductInfo;
import com.tosix7.result.impl.DubboResult;
import com.tosix7.api.service.IndexService;
import org.apache.dubbo.config.annotation.DubboService;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.beans.factory.annotation.Autowired;

import java.math.BigDecimal;
import java.util.HashMap;
import java.util.List;

@DubboService
@Mapper
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
     * @return
     */

    @Override
    public DubboResult<HashMap<String, BigDecimal>> getHotData() {
        HashMap<String, BigDecimal> data = new HashMap<>();
        DubboResult<HashMap<String, BigDecimal>> result = new DubboResult<>();
        BigDecimal countUser = BigDecimal.valueOf(userMapper.getCountUser());
        BigDecimal avgRate = productMapper.findAvgRate();
        BigDecimal countBidMoney = bidMapper.findCountBidMoney();
        data.put(ConstantKey.HOT_RATE_KEY, avgRate);
        data.put(ConstantKey.HOT_COUNT_USER_KEY, countUser);
        data.put(ConstantKey.HOT_COUNT_BID_MONEY_KEY, countBidMoney);
        result.setData(data);
        return result;
    }

    @Override
    public DubboResult<HashMap<String, List<ProductInfo>>> getProductData() {
        return null;
    }
}
