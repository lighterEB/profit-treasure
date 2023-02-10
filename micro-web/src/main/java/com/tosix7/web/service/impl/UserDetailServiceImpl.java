package com.tosix7.web.service.impl;

import com.tosix7.api.service.UserService;
import com.tosix7.info.UserInfo;
import com.tosix7.result.DubboResult;
import com.tosix7.result.ResponseResult;
import org.apache.dubbo.config.annotation.DubboReference;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.ArrayList;

@Service
public class UserDetailServiceImpl extends RequestServiceImpl implements UserDetailsService {

    @Override
    public UserDetails loadUserByUsername(String phone) throws UsernameNotFoundException {
        DubboResult<UserInfo> result = userService.getUserByPhone(phone);
        UserDetails userDetails;
        if (result.getData() != null) {
            UserInfo info = (UserInfo) result.getData();
            userDetails = new User(info.getPhone() + "#" + info.getId(), info.getLoginPassword(), new ArrayList<>());
        }else {
            userDetails = new User(phone,"",new ArrayList<>());
        }
        return userDetails;
    }

    /**
     * 登录请求
     * @param userInfo
     * @return
     */
    public ResponseResult<?> requestLogin(UserInfo userInfo) {
        DubboResult<UserInfo> dubboResult = userService.getUserDetailByPhone(userInfo.getPhone());
        if (dubboResult.getData() != null){
            return ResponseResult.loginSuccess(dubboResult.getData());
        }else{
            return ResponseResult.userNotFound();
        }
    }
}
