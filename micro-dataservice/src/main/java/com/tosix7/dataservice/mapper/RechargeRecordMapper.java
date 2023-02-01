package com.tosix7.dataservice.mapper;

import com.tosix7.info.RechargeRecordInfo;

public interface RechargeRecordMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(RechargeRecordInfo record);

    int insertSelective(RechargeRecordInfo record);

    RechargeRecordInfo selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(RechargeRecordInfo record);

    int updateByPrimaryKey(RechargeRecordInfo record);
}
