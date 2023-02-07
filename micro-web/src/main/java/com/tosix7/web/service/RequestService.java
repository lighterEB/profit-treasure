package com.tosix7.web.service;

import com.tosix7.result.DubboResult;
import com.tosix7.result.ResponseResult;
import com.tosix7.web.info.UserDetails;

public interface RequestService {

    ResponseResult<?> requestHot();

    ResponseResult<?> requestProduct(Integer pageNum, Integer pageSize, Integer prodType);

    ResponseResult<?> requestLogin(UserDetails userDetails);
}
