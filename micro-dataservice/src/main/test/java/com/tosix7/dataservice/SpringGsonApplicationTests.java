package com.tosix7.dataservice;

import com.tosix7.dataservice.mapper.ProductMapper;
import com.tosix7.info.ProductInfo;
import com.tosix7.result.DubboResult;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

@SpringBootTest
@RequestMapping("/api/demo2")
class DataServiceApplicationTests {
    private static final HashMap<String,Object> INFO;
    static {
        INFO = new HashMap<>();
        INFO.put("name", "张三");
        INFO.put("age", "25");
    }
    @Test
    void contextLoads() {

    }
    @Test

    @GetMapping("/getInfo")
    public Map<String, Object> getInfo() {
        return INFO;
    }
    @GetMapping("/getInfoResult")
    public DubboResult<Map<String, Object>> getInfoResult() {
        return DubboResult.success(INFO);
    }

}
