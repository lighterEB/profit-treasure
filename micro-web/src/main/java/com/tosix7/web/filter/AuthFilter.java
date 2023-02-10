package com.tosix7.web.filter;


import com.fasterxml.jackson.databind.ObjectMapper;
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
    String[] fxpath = {
            "/sms/smsAli", "/hot", "/indexProduct"
    };

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {

        HttpServletRequest request = (HttpServletRequest) servletRequest;
        HttpServletResponse response = (HttpServletResponse) servletResponse;
        response.setCharacterEncoding("utf-8");
        response.setContentType("text/html;charset=utf-8");
        if (isPassed(request.getRequestURI())) {
            filterChain.doFilter(request, response);
            return;
        }

        // 如果不是认证请求验证token
        if ("/login".equals(request.getRequestURI())){

            String phone = request.getParameter("uname");
            String code = request.getParameter("code");

            String redisCode = stringRedisTemplate.opsForValue().get(phone);

            if ( !(code ==null || redisCode==null ) && redisCode.equals(code)) {
                filterChain.doFilter(request, response);
            }else {
                ResponseResult<String> result = ResponseResult.failure();
                ObjectMapper mapper = new ObjectMapper();
                String jsonResult = mapper.writeValueAsString(result);
                response.getWriter().write(jsonResult);
                response.getWriter().close();
                return;
            }
        }else {
            // 请求需要校验token
            String token = request.getHeader("token");
            boolean signed = false;
            if (token != null && JWTUtils.getClaims(token) != null) {
               signed = JWTUtils.isSigned(token);
            }
            if (signed) {
                Object phone = JWTUtils.getClaims(token).get("phone");
                UsernamePasswordAuthenticationToken u = new UsernamePasswordAuthenticationToken(phone, "", new ArrayList<>());
                SecurityContextHolder.getContext().setAuthentication(u);
                filterChain.doFilter(request,response);
            }else {
                ResponseResult<String> result = ResponseResult.noLogin();
                ObjectMapper mapper = new ObjectMapper();
                String jsonResult = mapper.writeValueAsString(result);
                response.getWriter().write(jsonResult);
                response.getWriter().close();
            }
        }

    }

    private boolean isPassed(String requestURI) {
        for (String s : fxpath) {
            if (s.equals(requestURI)) {
                return true;
            }
        }
        return false;
    }
}
