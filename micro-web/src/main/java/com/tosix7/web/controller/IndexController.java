package com.tosix7.web.controller;

import com.tosix7.api.service.IndexService;
import com.tosix7.result.DubboResult;
import com.tosix7.result.ResponseResult;
import org.apache.dubbo.config.annotation.DubboReference;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.math.BigDecimal;
import java.util.HashMap;

@RestController
public class IndexController {

    @DubboReference(check = false)
    IndexService indexService;

    /**
     * 获取首页热点数据
     *
     * @return
     */
    @GetMapping("/hot")
    public ResponseResult<?> findHot(){
        DubboResult<HashMap<String, BigDecimal>> hotData = indexService.getHotData();
        if (hotData.getData() != null){
            return ResponseResult.success(hotData.getData());
        }else {
            return ResponseResult.failure();
        }
    }
}
