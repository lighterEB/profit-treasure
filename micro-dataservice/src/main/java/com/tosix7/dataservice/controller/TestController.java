package com.tosix7.dataservice.controller;

import com.tosix7.api.service.UserService;
import com.tosix7.result.DubboResult;
import org.apache.dubbo.config.annotation.DubboReference;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("/api/demo2")
public class TestController {

    @DubboReference(check = false)
    UserService userService;

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

    @PostMapping("/login")
    public DubboResult<?> login(@RequestParam String phoneNum){
        return userService.getUserByPhone(phoneNum);
    }

}
