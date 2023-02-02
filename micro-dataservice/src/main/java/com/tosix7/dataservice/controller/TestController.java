package com.tosix7.dataservice.controller;

import com.tosix7.result.DubboResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("/api/demo2")
public class TestController {
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
