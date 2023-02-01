package com.tosix7.dataservice.mapper;

import com.tosix7.info.UserInfo;

public interface UserMapper {
//    int deleteByPrimaryKey(Integer id);
//
//    int insert(UserInfo record);
//
//    int insertSelective(UserInfo record);

    UserInfo selectByPrimaryKey(Integer id);

    Integer getCountUser();


//    int updateByPrimaryKeySelective(UserInfo record);
//
//    int updateByPrimaryKey(UserInfo record);
}
