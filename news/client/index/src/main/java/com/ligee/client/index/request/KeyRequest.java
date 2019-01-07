package com.ligee.client.index.request;

import javax.validation.constraints.NotNull;

/**
 * Author: 李杰
 * Date: 2018/12/7 6:09 PM
 * 私钥输入参数（其实就是客户端通过服务端返回的公钥加密后的客户端自己生成的公钥）
 */
public class KeyRequest {

    /**
     * 客户端自己生成的加密后公钥
     */
    @NotNull
    private String clientEncryptPublicKey;

    public String getClientEncryptPublicKey() {
        return clientEncryptPublicKey;
    }

    public void setClientEncryptPublicKey(String clientEncryptPublicKey) {
        this.clientEncryptPublicKey = clientEncryptPublicKey;
    }
}
