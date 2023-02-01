package com.tosix7.dataservice.mapper;

import com.tosix7.info.ProductInfo;

import java.math.BigDecimal;

public interface ProductMapper {
//    int deleteByPrimaryKey(Integer id);
//
//    int insert(ProductInfo record);
//
//    int insertSelective(ProductInfo record);

    ProductInfo selectByPrimaryKey(Integer id);

//    int updateByPrimaryKeySelective(ProductInfo record);
//
//    int updateByPrimaryKey(ProductInfo record);

    /**
     * 获取年化收益率
     * @return
     */
    BigDecimal findAvgRate();
}
