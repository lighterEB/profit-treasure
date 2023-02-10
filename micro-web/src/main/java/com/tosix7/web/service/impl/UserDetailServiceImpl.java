package com.tosix7.web.service.impl;

import com.tosix7.api.service.UserService;
import com.tosix7.info.UserInfo;
import com.tosix7.result.DubboResult;
import com.tosix7.result.ResponseResult;
import org.apache.dubbo.config.annotation.DubboReference;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.ArrayList;

@Service
public class UserDetailServiceImpl implements UserDetailsService {

    @DubboReference(check = false)
    UserService userService;

    @Resource
    private PasswordEncoder passwordEncoder;

    @Override
    public UserDetails loadUserByUsername(String phone) throws UsernameNotFoundException {
        DubboResult<UserInfo> result = userService.getUserByPhone(phone);
        UserInfo userInfo = (UserInfo) result.getData();
        UserDetails userDetails;
        if (userInfo != null) {
            userDetails = User.builder()
                    .username(userInfo.getPhone() + "#" + userInfo.getId())
                    .password(userInfo.getLoginPassword())
                    .build();
        }else {
            userDetails =  User.builder().build();
        }
        return userDetails;
    }

}
