package com.tosix7.web.handler;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.tosix7.result.ResponseResult;
import com.tosix7.web.info.UserDetails;
import com.tosix7.web.utils.JWTUtils;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.web.authentication.AuthenticationSuccessHandler;
import org.springframework.stereotype.Component;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

@Component
public class MySuccessHandler implements AuthenticationSuccessHandler {

    @Override
    public void onAuthenticationSuccess(HttpServletRequest request, HttpServletResponse response, Authentication authentication) throws IOException, ServletException {
        UserDetails userDetails = new UserDetails();
        User user = (User) authentication.getPrincipal();
        System.out.println(user.toString());
        // 用户电话
        userDetails.setPhone(user.getUsername().split("#")[0]);
        // 用户uid
        userDetails.setUid(user.getUsername().split("#")[1]);
        // 余额
        userDetails.setMoney(user.getUsername().split("#")[2]);
        // 姓名
        userDetails.setName(user.getUsername().split("#")[3]);
        // 身份证
        userDetails.setIdCard(user.getUsername().split("#")[4]);
        // token
        Map<String, Object> clm = new HashMap<>();
        clm.put("phone", userDetails.getPhone());
        userDetails.setToken(JWTUtils.generate(clm));
        ResponseResult<UserDetails> result = ResponseResult.success(userDetails);
        ObjectMapper mapper = new ObjectMapper();
        String jsonResult = mapper.writeValueAsString(result);
        response.getWriter().write(jsonResult);
        response.getWriter().flush();
        response.getWriter().close();
    }
}
