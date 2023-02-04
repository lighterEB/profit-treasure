package com.tosix7.dataservice.controller;

import com.tosix7.dataservice.service.internal.IProductService;
import com.tosix7.dataservice.service.internal.impl.IProductServiceImpl;
import com.tosix7.info.ProductInfo;
import com.tosix7.param.PageParam;
import com.tosix7.result.DubboResult;
import com.tosix7.result.ResponseResult;
import org.apache.dubbo.config.bootstrap.DubboBootstrap;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("/api/demo2")
public class TestController {


    @Autowired
    private IProductService iProductService;
    private static final HashMap<String,Object> INFO;
    static {
        INFO = new HashMap<>();
        INFO.put("name", "张三");
        INFO.put("age", "25");
    }
    @GetMapping("/getInfo")
    public Map<String, Object> getInfo() {
        return INFO;
    }
    @GetMapping("/getInfoResult")
    public DubboResult<Map<String, Object>> getInfoResult() {
        return DubboResult.success(INFO);
    }

}
