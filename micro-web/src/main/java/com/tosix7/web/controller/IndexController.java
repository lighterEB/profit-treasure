package com.tosix7.web.controller;

import com.tosix7.result.ResponseResult;
import com.tosix7.web.service.RequestService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
public class IndexController {

    @Autowired
    RequestService requestService;
    @GetMapping("/hot")
    public ResponseResult<?> findHot(){
        return requestService.requestHot();
    }
}
