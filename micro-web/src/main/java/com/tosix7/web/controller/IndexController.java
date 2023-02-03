package com.tosix7.web.controller;

import com.tosix7.result.ResponseResult;
import com.tosix7.web.service.impl.RequestServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.math.BigDecimal;
import java.util.HashMap;

@RestController
public class IndexController {

    @Autowired
    RequestServiceImpl requestService;
    @GetMapping("/hot")
    public ResponseResult<?> findHot(){
        return requestService.requestHot();
    }
}
