package com.ligee.common.properties;

import org.springframework.boot.context.properties.ConfigurationProperties;

/**
 * Author: 李杰
 * Date: 2018/12/7 6:43 PM
 */
@ConfigurationProperties(prefix = "api.encrypt")
public class EncryptProperties {

    private String key;

    private String charset = "UTF-8";

    public String getCharset() {
        return charset;
    }

    public void setCharset(String charset) {
        this.charset = charset;
    }

    public String getKey() {
        return key;
    }

    public void setKey(String key) {
        this.key = key;
    }
}
