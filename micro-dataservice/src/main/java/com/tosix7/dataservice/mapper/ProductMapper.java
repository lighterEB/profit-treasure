package com.tosix7.dataservice.mapper;

import com.tosix7.info.ProductInfo;
import org.apache.ibatis.annotations.Select;

import java.math.BigDecimal;
import java.util.List;

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
    @Select("SELECT AVG(rate) FROM b_product_info")
    BigDecimal findAvgRate();

    List<ProductInfo> findProductByType(Integer productType);
}
