package com.tosix7.dataservice.service.internal;

import java.math.BigDecimal;
import java.util.HashMap;

/**
 * 热点查询接口
 */
public interface IHotService {
    HashMap<String, BigDecimal> findHotData();
}
