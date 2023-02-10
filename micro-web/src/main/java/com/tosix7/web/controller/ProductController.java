package com.tosix7.web.controller;

import com.tosix7.param.PageParam;
import com.tosix7.result.ResponseResult;
import com.tosix7.web.service.RequestService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.web.bind.annotation.*;

/**
 * 产品控制器
 */
@RestController
public class ProductController {
    @Autowired
    RequestService requestService;
    @GetMapping("/indexProduct")
    @Cacheable(value = "sys:index:product")
    public ResponseResult<?> findProduct() {
        return ResponseResult.failure();
    }
}
