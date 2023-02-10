package com.tosix7.constant;

public class ResponseKey {

    /**
     * 请求成功状态码
     */
    public static final Integer REQUEST_SUCCESS_CODE = 200;

    /**
     * 请求成功信息
     */
    public static final String REQUEST_SUCCESS_MSG = "请求成功";

    /**
     * 请求失败状态码
     */
    public static final Integer REQUEST_FAILED_CODE = 500;

    /**
     * 请求失败信息
     */
    public static final String REQUEST_FAILED_MSG = "请求失败";

    /**
     * 热点年化收益率
     */
    public static final String HOT_RATE = "hotRate";

    /**
     * 热点总投资金额
     */
    public static final String HOT_COUNT_BID_MONEY = "hotCountBidMoney";

    /**
     * 热点用户统计
     */
    public static final String HOT_COUNT_USER = "hotCountUser";

    /**
     * 用户不存在
     */
    public static final String USER_NOT_FOUND = "用户不存在";

    /**
     * 用户不存在状态码
     */
    public static final Integer USER_NOT_FOUND_CODE = 2001;

    /**
     * 登录成功
     */
    public static final String LOGIN_SUCCESS="登录成功";

    /**
     * 登录成功状态码
     */
    public static final Integer LOGIN_SUCCESS_CODE= 1000;

    /**
     * 登录失败
     */
    public static final String LOGIN_FAILED="登录失败";

    /**
     * 登录失败状态码
     */
    public static final Integer LOGIN_FAILED_CODE= 2000;

    /**
     * 验证码
     */
    public static final String KAPTCHA_SESSION_KEY = "kaptcha";

    /**
     * 未登录或token失效
     */
    public static final String NO_LOGIN = "未登录或认证失效请重新登录";

    /**
     * 未登录或token失效状态码
     */
    public static final Integer NO_LOGIN_CODE = 2002;
}
