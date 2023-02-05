package com.tosix7.dataservice.service.internal.impl;

import com.tosix7.dataservice.mapper.UserMapper;
import com.tosix7.dataservice.service.internal.IUserService;
import com.tosix7.info.UserInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class IUserServiceImpl implements IUserService {
    @Autowired
    UserMapper userMapper;


    @Override
    public UserInfo findUserByPhone(String phoneNum) {
        return userMapper.selectByPhoneNumber(phoneNum);
    }
}
