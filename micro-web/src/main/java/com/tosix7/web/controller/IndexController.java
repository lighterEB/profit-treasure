package com.tosix7.web.controller;

import com.tosix7.api.service.IndexService;
import com.tosix7.result.ResultStatus;
import com.tosix7.result.impl.DubboResult;
import com.tosix7.result.impl.ResponseResult;
import org.apache.dubbo.config.annotation.DubboReference;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.math.BigDecimal;
import java.util.HashMap;
import java.util.Objects;

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
    public String findHot(){
        ResponseResult<HashMap> result;
        DubboResult<HashMap<String, BigDecimal>> hotData = indexService.getHotData();
        return hotData.toString();
    }
}
