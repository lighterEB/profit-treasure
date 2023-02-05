package com.tosix7.dataservice.service.internal;

import com.tosix7.info.UserInfo;

public interface IUserService {

    UserInfo findUserByPhone(String phoneNum);
}
