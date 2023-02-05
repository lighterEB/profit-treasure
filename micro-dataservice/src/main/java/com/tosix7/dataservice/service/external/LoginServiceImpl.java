package com.tosix7.dataservice.service.external;

import com.tosix7.api.service.LoginService;
import com.tosix7.dataservice.service.internal.IUserService;
import com.tosix7.info.UserInfo;
import com.tosix7.result.DubboResult;
import org.apache.dubbo.config.annotation.DubboService;
import org.springframework.beans.factory.annotation.Autowired;

@DubboService
@SuppressWarnings("all")
public class LoginServiceImpl implements LoginService {

    @Autowired
    IUserService iUserService;
    @Override
    public DubboResult getUserByPhone(String phoneNum) {
        return DubboResult.success(iUserService.findUserByPhone(phoneNum));
    }
}
