package com.tosix7.web.filter;


import com.fasterxml.jackson.databind.ObjectMapper;
import com.tosix7.constant.RedisKey;
import com.tosix7.result.ResponseResult;
import com.tosix7.web.utils.JWTUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Component;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;


/**
 * 认证过滤器
 */
@WebFilter
@Component
public class AuthFilter implements Filter {

    @Autowired
    StringRedisTemplate stringRedisTemplate;

    // 无token访问的路由
    String[] passPath = {
            "/sms/smsAli", "/hot", "/indexProduct"
    };

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {

        HttpServletRequest request = (HttpServletRequest) servletRequest;
        HttpServletResponse response = (HttpServletResponse) servletResponse;
        response.setCharacterEncoding("utf-8");
        response.setContentType("text/html;charset=utf-8");
        // 放行路由
        if (isPassed(request.getRequestURI())) {
            filterChain.doFilter(request, response);
            return;
        }

        // 如果不是认证请求验证token
        if ("/login".equals(request.getRequestURI())){

            /**
             * 前端入参数
             * @phone 用户电话
             * @code 手机验证码
             */
            String phone = request.getParameter("phone");
            String code = request.getParameter("code");

            // redis获取对应手机验证码
            String redisCode = stringRedisTemplate.opsForValue().get(RedisKey.SMS_CODE + phone);

            // 手机验证码一致执行security配置流程
            if ( !(code ==null || redisCode==null ) && redisCode.equals(code)) {
                filterChain.doFilter(request, response);
            }else { // 否则返回登录失败响应
                ResponseResult<String> result = ResponseResult.failure();
                ObjectMapper mapper = new ObjectMapper();
                String jsonResult = mapper.writeValueAsString(result);
                response.getWriter().write(jsonResult);
                response.getWriter().close();
            }
        }else {
            // 请求需要校验token
            // 获取头文件中的token
            String token = request.getHeader("token");
            boolean signed = false;
            // 校验token
            if (token != null && JWTUtils.getClaims(token) != null) {
               signed = JWTUtils.isSigned(token);
            }
            // 如果是已签token 放行
            if (signed) {
                Object phone = JWTUtils.getClaims(token).get("phone");
                UsernamePasswordAuthenticationToken u = new UsernamePasswordAuthenticationToken(phone, "", new ArrayList<>());
                SecurityContextHolder.getContext().setAuthentication(u);
                filterChain.doFilter(request,response);
            }else { // 否则拦截并返回未登录响应
                ResponseResult<String> result = ResponseResult.noLogin();
                ObjectMapper mapper = new ObjectMapper();
                String jsonResult = mapper.writeValueAsString(result);
                response.getWriter().write(jsonResult);
                response.getWriter().close();
            }
        }

    }


    /**
     * 判断URI是否在放行路由数组内
     * @param requestURI
     * @return
     */
    private boolean isPassed(String requestURI) {
        for (String s : passPath) {
            if (s.equals(requestURI)) {
                return true;
            }
        }
        return false;
    }
}
