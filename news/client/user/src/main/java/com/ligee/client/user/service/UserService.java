package com.ligee.client.user.service;

import com.ligee.client.user.model.request.LoginRequest;
import com.ligee.client.user.model.request.RegisterRequest;
import com.ligee.client.user.model.response.TokenResponse;
import com.ligee.common.result.SingleResult;

/**
 * Author: 李杰
 * Date: 2018/12/7 6:23 PM
 */
public interface UserService{

    /**
     * 登录
     * @param request
     * @return
     */
    SingleResult<TokenResponse> login(LoginRequest request);

    /**
     * 注册
     * @param request
     * @return
     */
    SingleResult<TokenResponse> register(RegisterRequest request);
}
