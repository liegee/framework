package com.ligee.client.user.model.response;

import com.ligee.common.model.response.BaseResponse;

/**
 * Author: 李杰
 * Date: 2018/12/7 6:22 PM
 */
public class TokenResponse extends BaseResponse {

    private String token;

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }
}
