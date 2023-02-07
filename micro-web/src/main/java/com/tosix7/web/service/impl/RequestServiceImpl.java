package com.tosix7.web.service.impl;

import com.tosix7.api.service.IndexService;
import com.tosix7.api.service.ProductService;
import com.tosix7.api.service.UserService;
import com.tosix7.info.UserInfo;
import com.tosix7.result.DubboResult;
import com.tosix7.result.PageResult;
import com.tosix7.result.ResponseResult;
import com.tosix7.web.info.UserDetails;
import com.tosix7.web.service.RequestService;
import org.apache.dubbo.config.annotation.DubboReference;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.HashMap;

@Service
public class RequestServiceImpl implements RequestService {

    @DubboReference(check = false)
    IndexService indexService;

    @DubboReference(check = false)
    ProductService productService;

    @DubboReference(check = false)
    UserService userService;

    /**
     * 获取首页热点数据
     *
     * @return ResponseResult
     */
    @Override
    public ResponseResult<?> requestHot() {
        DubboResult<HashMap<String, BigDecimal>> hotData = indexService.getHotData();
        if (hotData.getData() != null){
            return (ResponseResult.success(hotData.getData()));
        }else {
            return ResponseResult.failure();
        }
    }

    /**
     * 获取产品分页数据
     * @param pageNum
     * @param pageSize
     * @param prodType
     * @return
     */

    @Override
    public ResponseResult<?> requestProduct(Integer pageNum, Integer pageSize, Integer prodType) {
        DubboResult<PageResult> dubboResult = productService.getProductByType(pageNum, pageSize, prodType);
        if (dubboResult.getData() != null){
            return ResponseResult.success(dubboResult.getData());
        }else {
            return ResponseResult.failure();
        }
    }

    @Override
    public ResponseResult<?> requestLogin(UserDetails userDetails) {
        DubboResult<UserInfo> dubboResult = userService.getUserByPhone(userDetails.getPhoneNum());
        if (dubboResult.getData() != null){
            return ResponseResult.loginSuccess(dubboResult.getData());
        }else{
            return ResponseResult.userNotFound();
        }
    }


}
