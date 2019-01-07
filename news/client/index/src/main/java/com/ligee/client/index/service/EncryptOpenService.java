package com.ligee.client.index.service;

import com.ligee.client.index.request.KeyRequest;
import com.ligee.client.index.response.KeyResponse;
import com.ligee.client.index.response.RSAResponse;
import com.ligee.common.result.SingleResult;
import com.ligee.common.utils.RSAUtils;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

/**
 * Author: 李杰
 * Date: 2018/12/7 6:13 PM
 */
@Service
public class EncryptOpenService{

    @Value("${rsa.publicKey}")
    private String publicKey;
    @Value("${rsa.privateKey}")
    private String privateKey;
    @Value("${api.encrypt.key}")
    private String key;

    public SingleResult<RSAResponse> getRSA() {
        RSAResponse response = RSAResponse.options()
                .setServerPublicKey(publicKey)
                .build();
        return SingleResult.buildSuccess(response);
    }

    public SingleResult<KeyResponse> getKey(KeyRequest request)throws Exception {
        String clientPublicKey = RSAUtils.privateDecrypt(request.getClientEncryptPublicKey(), RSAUtils.getPrivateKey(privateKey));
        String encryptKey = RSAUtils.publicEncrypt(key,RSAUtils.getPublicKey(clientPublicKey));
        KeyResponse response = KeyResponse.options()
                .setKey(encryptKey)
                .build();
        return SingleResult.buildSuccess(response);
    }
}
