package com.tosix7.web.handler;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.tosix7.result.ResponseResult;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.web.authentication.AuthenticationFailureHandler;
import org.springframework.stereotype.Component;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@Component
public class MyFailureHandler implements AuthenticationFailureHandler {
    @Override
    public void onAuthenticationFailure(HttpServletRequest request, HttpServletResponse response, AuthenticationException exception) throws IOException, ServletException {
        ResponseResult<Object> result;
        if (exception.getMessage().equals("Cannot pass null or empty values to constructor")) {
            result = ResponseResult.userNotFound();
        } else {
            result = ResponseResult.loginFailed();
        }
        ObjectMapper mapper = new ObjectMapper();
        String jsonResult = mapper.writeValueAsString(result);
        response.getWriter().write(jsonResult);
        response.getWriter().close();
    }
}
