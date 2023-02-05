package com.tosix7.api.service;

import com.tosix7.info.UserInfo;
import com.tosix7.result.DubboResult;

public interface LoginService {

    DubboResult<UserInfo> getUserByPhone(String phoneNum);
}
