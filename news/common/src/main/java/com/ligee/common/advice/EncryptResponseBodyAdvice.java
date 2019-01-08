package com.ligee.common.advice;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.ligee.common.annotation.DisabledEncrypt;
import com.ligee.common.properties.EncryptProperties;
import com.ligee.common.utils.AesEncryptUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.MethodParameter;
import org.springframework.http.MediaType;
import org.springframework.http.converter.HttpMessageConverter;
import org.springframework.http.server.ServerHttpRequest;
import org.springframework.http.server.ServerHttpResponse;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.servlet.mvc.method.annotation.ResponseBodyAdvice;

/**
 * Author: 李杰
 * Date: 2018/12/7 6:31 PM
 */
@ControllerAdvice
public class EncryptResponseBodyAdvice implements ResponseBodyAdvice<Object> {

    @Autowired
    private EncryptProperties encryptProperties;

    private ObjectMapper objectMapper = new ObjectMapper();

    @Override
    public boolean supports(MethodParameter parameter, Class<? extends HttpMessageConverter<?>> aClass) {
        return !parameter.getMethod().isAnnotationPresent(DisabledEncrypt.class);
    }

    @Override
    public Object beforeBodyWrite(Object body, MethodParameter parameter, MediaType mediaType, Class<? extends HttpMessageConverter<?>> aClass, ServerHttpRequest serverHttpRequest, ServerHttpResponse serverHttpResponse) {
        try {
            String content = objectMapper.writerWithDefaultPrettyPrinter().writeValueAsString(body);
            if (!StringUtils.hasText(encryptProperties.getKey())) {
                throw new NullPointerException("请配置api.encrypt.key");
            }
            System.out.println("--------EncryptResponseBodyAdvice------->>" + content);
            return AesEncryptUtils.aesEncrypt(content, encryptProperties.getKey());
        } catch (Exception e) {
            e.printStackTrace();
            throw new RuntimeException("加密失败！");
        }
    }
}
