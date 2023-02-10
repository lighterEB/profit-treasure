package com.tosix7.web.controller;

import com.google.code.kaptcha.impl.DefaultKaptcha;
import com.tosix7.constant.RedisKey;
import com.tosix7.constant.ResponseKey;
import com.tosix7.result.ResponseResult;
import com.tosix7.web.service.RequestService;
import com.tosix7.web.service.impl.RequestServiceImpl;
import org.apache.tomcat.util.http.fileupload.IOUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.imageio.ImageIO;
import javax.servlet.ServletException;
import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.awt.image.BufferedImage;
import java.io.IOException;


@RestController
public class IndexController {

    @Autowired
    RequestService requestService;

    @Autowired
    DefaultKaptcha defaultKaptcha;
    @GetMapping("/hot")
    @Cacheable(value = RedisKey.INDEX_PRODUCT )
    public ResponseResult<?> findHot(){
        return requestService.requestHot();
    }

    @GetMapping("/indexProduct")
    @Cacheable(value = RedisKey.INDEX_HOT)
    public ResponseResult<?> indexProduct(){
        return requestService.requestIndexProduct();
    }

    @GetMapping("/code")
    public void captcha(HttpServletResponse response, HttpServletRequest request) throws ServletException, IOException {
        response.setHeader("Cache-Control", "no-store, no-cache");
        response.setContentType("image/jpeg");
        // 生成文字验证码
        String text = defaultKaptcha.createText();
        // 生成图片验证码
        BufferedImage image = defaultKaptcha.createImage(text);
        // 保存验证码到session
        request.getSession().setAttribute(ResponseKey.KAPTCHA_SESSION_KEY, text);
        ServletOutputStream outputStream = response.getOutputStream();
        ImageIO.write(image, "jpg", outputStream);
        IOUtils.closeQuietly(outputStream);
    }

}
