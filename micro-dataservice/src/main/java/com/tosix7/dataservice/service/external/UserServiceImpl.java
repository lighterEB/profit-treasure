package com.tosix7.dataservice.service.external;

import com.tosix7.api.service.UserService;
import com.tosix7.dataservice.service.internal.IUserService;
import com.tosix7.info.UserInfo;
import com.tosix7.result.DubboResult;
import com.tosix7.result.ResponseResult;
import org.apache.dubbo.config.annotation.DubboService;
import org.springframework.beans.factory.annotation.Autowired;

@DubboService
@SuppressWarnings("all")
public class UserServiceImpl implements UserService {

    @Autowired
    IUserService iUserService;
    @Override
    public DubboResult getUserByPhone(String phone) {
        return DubboResult.success(iUserService.findUserByPhone(phone));
    }

    @Override
    public DubboResult<UserInfo> getUserDetailByPhone(String phone) {
        return DubboResult.success(iUserService.findUserDetailByPhone(phone));
    }

    @Override
    public DubboResult<UserInfo> setUserDetailByPhone(String phone, String name, String idCard, String uid) {
        Integer res =  iUserService.updateUserDetailByPhone(phone,name,idCard, uid);
        if (res < 1) {
            return DubboResult.failure();
        }else {
            UserInfo userInfo = iUserService.findUserDetailByPhone(phone);
            return DubboResult.success(userInfo);
        }
    }

}
