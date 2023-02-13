package com.tosix7.web.controller;

import com.tosix7.result.ResponseResult;
import com.tosix7.web.info.UserDetails;
import com.tosix7.web.service.RequestService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * 用户认证
 */

@RestController
public class AttestationController {

    @Autowired
    RequestService requestService;
    @RequestMapping("/attestationUser")
    public ResponseResult attestationUser(@RequestBody UserDetails userDetails) {
        return requestService.requestUpdateUser(userDetails);
    }
}
