package com.tosix7.web.config;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.tosix7.result.ResponseResult;
import com.tosix7.web.filter.AuthFilter;
import com.tosix7.web.handler.MyFailureHandler;
import com.tosix7.web.handler.MySuccessHandler;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;

import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

import java.util.HashMap;
import java.util.Map;

@Configuration
@EnableGlobalMethodSecurity(prePostEnabled = true) // 开启权限注解，如：PreAuthorize注解
public class WebSecurityConfig {


    @Autowired
    private AuthFilter authFilter;
    @Autowired
    private MySuccessHandler mySuccessHandler;

    @Autowired
    private MyFailureHandler myFailureHandler;


    @Bean
    SecurityFilterChain filterChain(HttpSecurity httpSecurity) throws Exception {
        httpSecurity.addFilterBefore(authFilter, UsernamePasswordAuthenticationFilter.class);
        httpSecurity.exceptionHandling().accessDeniedHandler((request, response, accessDeniedException) -> {
            Map<String, String> result = new HashMap<>();
            ObjectMapper mapper = new ObjectMapper();
            result.put("code", "2004");
            result.put("msg", "没有权限");
            String jsonResult = mapper.writeValueAsString(result);
            response.getWriter().write(jsonResult);
            response.getWriter().close();
        });

        httpSecurity.formLogin()
                .loginProcessingUrl("/login")
                .usernameParameter("phone")
                .passwordParameter("password")
                .successHandler(mySuccessHandler)
                .failureHandler(myFailureHandler);
        httpSecurity.authorizeHttpRequests()
                .antMatchers("/login", "/sms/smsAli", "/hot", "/indexProduct").permitAll()
                .anyRequest().authenticated();

        httpSecurity.csrf().disable();
        httpSecurity.cors();
        httpSecurity.sessionManagement().sessionCreationPolicy(SessionCreationPolicy.STATELESS);
        return httpSecurity.build();
    }

    @Bean
    public PasswordEncoder getPe() {
        return new BCryptPasswordEncoder();
    }
}
