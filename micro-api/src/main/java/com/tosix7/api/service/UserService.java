package com.tosix7.api.service;

import com.tosix7.info.UserInfo;
import com.tosix7.result.DubboResult;
import com.tosix7.result.ResponseResult;

public interface UserService {

    /**
     * 根据手机号查找用户信息--登录需求
     * @param phone 手机号
     * @return DubboResult<UserInfo>
     */
    DubboResult<UserInfo> getUserByPhone(String phone);

    DubboResult<UserInfo> getUserDetailByPhone(String phone);

    DubboResult<UserInfo> setUserDetailByPhone(String phone, String name, String idCard, String uid);
}
