package com.tosix7.web.service.impl;

import com.github.pagehelper.PageInfo;
import com.tosix7.api.service.IndexService;
import com.tosix7.api.service.ProductService;
import com.tosix7.api.service.UserService;
import com.tosix7.constant.ProductKey;
import com.tosix7.info.UserInfo;
import com.tosix7.param.PageParam;
import com.tosix7.result.DubboResult;
import com.tosix7.result.PageResult;
import com.tosix7.result.ResponseResult;
import com.tosix7.web.info.UserDetails;
import com.tosix7.web.service.RequestService;
import org.apache.dubbo.config.annotation.DubboReference;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.HashMap;
import java.util.Map;

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
     * @param pageParam
     * @param prodType
     * @return
     */

    @Override
    public ResponseResult<?> requestProduct(PageParam pageParam, Integer prodType) {
        DubboResult<PageResult> dubboResult = productService.getProductByType(pageParam, prodType);
        if (dubboResult.getData() != null){
            return ResponseResult.success(dubboResult.getData());
        }else {
            return ResponseResult.failure();
        }
    }

    /**
     * 获取首页产品展示
     * @return
     */

    @Override
    public ResponseResult<?> requestIndexProduct() {
        PageParam pageParam = new PageParam(1, 3, null);
        DubboResult<PageResult> bulk = productService.getProductByType(pageParam, ProductKey.BULK_CARGO);
        DubboResult<PageResult> preferred = productService.getProductByType(pageParam, ProductKey.PREFERRED_PRODUCT);
        pageParam.setPageSize(1);
        DubboResult<PageResult> newbie = productService.getProductByType(pageParam, ProductKey.NEWBIE_TREASURE);
        if (bulk.getData() != null || preferred.getData() != null || newbie.getData() != null) {
            Map<String, Object> map = new HashMap<>();
            map.put("newbie", newbie.getData());
            map.put("preferred", preferred.getData());
            map.put("bulk", bulk.getData());
            return ResponseResult.success(map);
        }else {
            return ResponseResult.failure();
        }

    }

    /**
     * 登录请求
     * @param userInfo
     * @return
     */
    public ResponseResult<?> requestLogin(UserInfo userInfo) {
        DubboResult<UserInfo> dubboResult = userService.getUserDetailByPhone(userInfo.getPhone());
        if (dubboResult.getData() != null){
            return ResponseResult.loginSuccess(dubboResult.getData());
        }else{
            return ResponseResult.userNotFound();
        }
    }

    @Override
    public ResponseResult<?> requestUpdateUser(UserDetails userDetails) {
        return null;
    }


}
