package com.tosix7.dataservice.mapper;

import com.tosix7.info.IncomeRecordInfo;

public interface IncomeRecordMapper {
//    int deleteByPrimaryKey(Integer id);
//
//    int insert(IncomeRecordInfo record);
//
//    int insertSelective(IncomeRecordInfo record);

    IncomeRecordInfo selectByPrimaryKey(Integer id);

//    int updateByPrimaryKeySelective(IncomeRecordInfo record);
//
//    int updateByPrimaryKey(IncomeRecordInfo record);
}
