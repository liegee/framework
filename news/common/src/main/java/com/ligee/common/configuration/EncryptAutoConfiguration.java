package com.ligee.common.configuration;

import com.ligee.common.advice.EncryptRequestBodyAdvice;
import com.ligee.common.advice.EncryptResponseBodyAdvice;
import com.ligee.common.properties.EncryptProperties;
import org.springframework.boot.SpringBootConfiguration;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;

/**
 * Author: 李杰
 * Date: 2018/12/7 6:35 PM
 */
@SpringBootConfiguration
@Component
@EnableAutoConfiguration
@EnableConfigurationProperties(EncryptProperties.class)
public class EncryptAutoConfiguration {

    /**
     * 配置请求解密
     * @return
     */
    @Bean
    public EncryptResponseBodyAdvice encryptResponseBodyAdvice() {
        return new EncryptResponseBodyAdvice();
    }

    /**
     * 配置请求加密
     * @return
     */
    @Bean
    public EncryptRequestBodyAdvice encryptRequestBodyAdvice() {
        return new EncryptRequestBodyAdvice();
    }
}

