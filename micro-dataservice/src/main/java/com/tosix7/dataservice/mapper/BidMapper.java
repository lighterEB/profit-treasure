package com.tosix7.dataservice.mapper;

import com.tosix7.info.BidInfo;
import org.apache.ibatis.annotations.Select;

import java.math.BigDecimal;

public interface BidMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(BidInfo record);

    int insertSelective(BidInfo record);

    @Select("select * from b_bid_info where id = #{id}")
    BidInfo selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(BidInfo record);

    int updateByPrimaryKey(BidInfo record);

    /**
     * 总投资金额
     */
    @Select("SELECT sum(bid_money) from b_bid_info")
    BigDecimal findCountBidMoney();
}
