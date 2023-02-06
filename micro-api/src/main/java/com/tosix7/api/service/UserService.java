package com.tosix7.api.service;

import com.tosix7.info.UserInfo;
import com.tosix7.result.DubboResult;

public interface UserService {

    /**
     * 根据手机号查找用户信息--登录需求
     * @param phoneNum 手机号
     * @return DubboResult<UserInfo>
     */
    DubboResult<UserInfo> getUserByPhone(String phoneNum);
}
