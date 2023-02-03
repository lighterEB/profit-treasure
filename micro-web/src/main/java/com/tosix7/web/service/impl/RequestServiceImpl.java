package com.tosix7.web.service.impl;

import com.tosix7.api.service.IndexService;
import com.tosix7.result.DubboResult;
import com.tosix7.result.ResponseResult;
import com.tosix7.web.service.RequestService;
import org.apache.dubbo.config.annotation.DubboReference;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.HashMap;

@Service
public class RequestServiceImpl implements RequestService {

    @DubboReference(check = false)
    IndexService indexService;

    /**
     * 获取首页热点数据
     *
     * @return ResponseResult
     */
    @Override
    public ResponseResult<?> requestHot() {
        DubboResult<HashMap<String, BigDecimal>> hotData = indexService.getHotData();
        if (hotData.getData() != null){
            return ResponseResult.success(hotData.getData());
        }else {
            return ResponseResult.failure();
        }
    }
}
