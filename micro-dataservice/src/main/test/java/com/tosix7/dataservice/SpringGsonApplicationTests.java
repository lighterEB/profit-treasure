package com.tosix7.dataservice;

import org.apache.dubbo.config.annotation.DubboService;
import org.apache.dubbo.config.spring.context.annotation.EnableDubbo;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import java.io.IOException;

@SpringBootTest
@EnableDubbo
class DataServiceApplicationTests {

    @Test
    void contextLoads() throws IOException {
        System.out.println("Dubbo Provider started successfully...");
        System.in.read();
    }

}
