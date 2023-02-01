package com.tosix7.dataservice.mapper;

import com.tosix7.info.BidInfo;

import java.math.BigDecimal;

public interface BidMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(BidInfo record);

    int insertSelective(BidInfo record);

    BidInfo selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(BidInfo record);

    int updateByPrimaryKey(BidInfo record);

    /**
     * 总投资金额
     */
    BigDecimal findCountBidMoney();
}
