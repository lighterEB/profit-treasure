package com.tosix7.web.service.impl;

import com.tosix7.api.service.UserService;
import com.tosix7.info.UserInfo;
import com.tosix7.result.DubboResult;
import com.tosix7.result.ResponseResult;
import org.apache.dubbo.config.annotation.DubboReference;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.math.RoundingMode;
import java.util.ArrayList;

@Service
public class UserDetailServiceImpl implements UserDetailsService {

    @DubboReference(check = false)
    UserService userService;

    @Override
    public UserDetails loadUserByUsername(String phone) throws UsernameNotFoundException {
        DubboResult<UserInfo> result = userService.getUserDetailByPhone(phone);
        UserInfo userInfo = (UserInfo) result.getData();
        UserDetails userDetails;
        if (userInfo != null) {
            String money = userInfo.getMoney().setScale(2, RoundingMode.HALF_DOWN).toString();
            userDetails = User.builder()
                    .username(phone + "#" + userInfo.getId() + "#" + money + "#" + userInfo.getName() +"#"+userInfo.getIdCard())
                    .password(userInfo.getLoginPassword())
                    .authorities("all") // 必须添加权限，不能使用空权限建立userDetail对象
                    .build();
        }else {
            userDetails =  User.builder().build();
        }
        return userDetails;
    }

}
