package com.tosix7.web.controller;

import com.tosix7.info.UserInfo;
import com.tosix7.result.ResponseResult;
import com.tosix7.web.service.impl.UserDetailServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class LoginController {

    @Autowired
    UserDetailServiceImpl requestService;
    @RequestMapping("/login")
    public ResponseResult<?> login(@RequestBody UserInfo userInfo){
        return requestService.requestLogin(userInfo);
    }
}
