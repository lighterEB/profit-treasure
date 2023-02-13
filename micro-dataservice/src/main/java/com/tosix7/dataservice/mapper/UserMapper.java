package com.tosix7.dataservice.mapper;

import com.tosix7.info.UserInfo;
import org.apache.ibatis.annotations.Select;

public interface UserMapper {
//    int deleteByPrimaryKey(Integer id);
//
//    int insert(UserInfo record);
//
//    int insertSelective(UserInfo record);

    UserInfo selectByPrimaryKey(Integer id);

    @Select("SELECT count(*) FROM u_user")
    Integer getCountUser();

    UserInfo selectByPhoneNumber(String phoneNum);

    UserInfo getUserDetailsByPhone(String phone);

    Integer updateUserDetailsByPhone(String phone, String name, String idCard, String uid);


//    int updateByPrimaryKeySelective(UserInfo record);
//
//    int updateByPrimaryKey(UserInfo record);
}
