package com.tosix7.dataservice;

import com.tosix7.dataservice.mapper.ProductMapper;
import com.tosix7.info.ProductInfo;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.io.IOException;

@SpringBootTest
class DataServiceApplicationTests {

    @Autowired
    ProductMapper productMapper;

    @Test
    void contextLoads() {
        ProductInfo productInfo = productMapper.selectByPrimaryKey(1);

        System.out.printf(productInfo.toString());
    }

}
