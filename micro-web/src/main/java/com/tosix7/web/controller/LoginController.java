package com.tosix7.web.controller;

import com.tosix7.result.ResponseResult;
import com.tosix7.web.info.UserDetails;
import com.tosix7.web.service.RequestService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class LoginController {

    @Autowired
    RequestService requestService;
    @RequestMapping("/login")
    public ResponseResult<?> login(@RequestBody UserDetails userDetails){
        System.out.printf(userDetails.toString());
        return requestService.requestLogin(userDetails);
    }
}
