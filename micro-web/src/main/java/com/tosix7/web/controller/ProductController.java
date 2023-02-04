package com.tosix7.web.controller;

import com.tosix7.result.ResponseResult;
import com.tosix7.web.service.RequestService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * 产品控制器
 */
@RestController
public class ProductController {
    @Autowired
    RequestService requestService;
    @PostMapping("/findProduct")
    public ResponseResult<?> findProduct(@RequestParam Integer pageNum,@RequestParam Integer pageSize, @RequestParam Integer prodType){
        return requestService.requestProduct(pageNum, pageSize, prodType);
    }
}
