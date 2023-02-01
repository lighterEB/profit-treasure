package com.tosix7.dataservice.mapper;

import com.tosix7.info.FinanceAccountInfo;

public interface FinanceAccountMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(FinanceAccountInfo record);

    int insertSelective(FinanceAccountInfo record);

    FinanceAccountInfo selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(FinanceAccountInfo record);

    int updateByPrimaryKey(FinanceAccountInfo record);
}
