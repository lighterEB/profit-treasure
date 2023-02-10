package com.tosix7.dataservice.service.internal;

import com.tosix7.info.UserInfo;
import org.apache.catalina.User;

public interface IUserService {

    UserInfo findUserByPhone(String phoneNum);

    UserInfo findUserDetailByPhone(String phone);
}
