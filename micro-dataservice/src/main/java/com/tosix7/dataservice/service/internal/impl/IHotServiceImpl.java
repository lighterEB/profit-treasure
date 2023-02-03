package com.tosix7.dataservice.service.internal.impl;

import com.tosix7.constant.ResponseKey;
import com.tosix7.dataservice.mapper.BidMapper;
import com.tosix7.dataservice.mapper.ProductMapper;
import com.tosix7.dataservice.mapper.UserMapper;
import com.tosix7.dataservice.service.internal.IHotService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.HashMap;

/**
 * 热点查询接口实现类
 */

@Service
public class IHotServiceImpl implements IHotService {

    @Autowired
    private BidMapper bidMapper;

    @Autowired
    private ProductMapper productMapper;

    @Autowired
    private UserMapper userMapper;

    /**
     * 查询首页热点数据 --
     * 用户总数
     * 历史年化收益率
     * 总投资金额
     *
     * @return HashMap<String, BigDecimal>
     */
    @Override
    public HashMap<String, BigDecimal> findHotData() {
        HashMap<String, BigDecimal> data = new HashMap<>();
        Integer hotCountUser = userMapper.getCountUser();
        BigDecimal hotRate = productMapper.findAvgRate();
        BigDecimal hotCountBidMoney = bidMapper.findCountBidMoney();
        if (hotCountUser == null || hotRate == null || hotCountBidMoney == null){
            return null;
        }else {
            data.put(ResponseKey.HOT_RATE, hotRate);
            data.put(ResponseKey.HOT_COUNT_USER, BigDecimal.valueOf(hotCountUser));
            data.put(ResponseKey.HOT_COUNT_BID_MONEY, hotCountBidMoney);
            return data;
        }
    }
}
