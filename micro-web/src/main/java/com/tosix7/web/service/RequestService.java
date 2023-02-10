package com.tosix7.web.service;

import com.tosix7.info.UserInfo;
import com.tosix7.param.PageParam;
import com.tosix7.result.ResponseResult;

public interface RequestService {

    ResponseResult<?> requestHot();

    ResponseResult<?> requestProduct(PageParam pageParam, Integer prodType);

    ResponseResult<?> requestIndexProduct();

    ResponseResult<?> requestLogin(UserInfo userInfo);
}
