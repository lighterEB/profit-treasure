package com.tosix7.dataservice.service.internal.impl;

import com.tosix7.dataservice.mapper.UserMapper;
import com.tosix7.dataservice.service.internal.IUserService;
import com.tosix7.info.UserInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class IUserServiceImpl implements IUserService {
    @Autowired
    UserMapper userMapper;


    @Override
    public UserInfo findUserByPhone(String phone) {
        return userMapper.selectByPhoneNumber(phone);
    }

    @Override
    public UserInfo findUserDetailByPhone(String phone) {
        return userMapper.getUserDetailsByPhone(phone);
    }

    @Override
    @Transactional
    public Integer updateUserDetailByPhone(String phone, String name, String idCard, String uid) {
        return userMapper.updateUserDetailsByPhone(phone, name, idCard, uid);
    }
}
