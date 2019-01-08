package com.ligee.client.user.service.impl;

import com.ligee.client.user.mapper.UserMapper;
import com.ligee.client.user.model.bean.UserBean;
import com.ligee.client.user.model.request.LoginRequest;
import com.ligee.client.user.model.request.RegisterRequest;
import com.ligee.client.user.model.response.TokenResponse;
import com.ligee.client.user.service.UserService;
import com.ligee.common.result.Code;
import com.ligee.common.result.ResultMessage;
import com.ligee.common.result.SingleResult;
import com.ligee.common.service.BaseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.ObjectUtils;

/**
 * Author: 李杰
 * Date: 2019/1/7 5:08 PM
 */
@Transactional(rollbackFor = Exception.class)
@Service
public class UserServiceImpl extends BaseService implements UserService {

    private UserMapper userMapper;

    @Autowired
    public UserServiceImpl(UserMapper userMapper){
        this.userMapper = userMapper;
    }

    /**
     * 登录
     * @param request
     * @return
     */
    @Override
    public SingleResult<TokenResponse> login(LoginRequest request){
        UserBean user = userMapper.selectUser(request.getMobile(),request.getPassword());
        if(!ObjectUtils.isEmpty(user)){
            return SingleResult.buildSuccess(getTokenResponse(request.getMobile(), request.getPassword()));
        }else {
            return SingleResult.buildFailure(Code.ERROR, ResultMessage.PHONEORPASSWORDERROR);
        }
    }

    /**
     * 注册
     * @param request
     * @return
     */
    @Override
    public SingleResult<TokenResponse> register(RegisterRequest request){
        UserBean user = userMapper.findUserByMobile(request.getMobile());
        if(!ObjectUtils.isEmpty(user)){
            return SingleResult.buildFailure(Code.ERROR, ResultMessage.PHONEHASREGISTER);
        }else {
            user = new UserBean();
            user.setMobile(request.getMobile());
            user.setPassword(request.getPassword());
            userMapper.insertUser(user);
            return SingleResult.buildSuccess(Code.SUCCESS, ResultMessage.REGISTERSUCCESS);
        }
    }

    private TokenResponse getTokenResponse(String mobile, String password){
        String token = getToken(mobile, password);
        TokenResponse response = new TokenResponse();
        response.setToken(token);
        return response;
    }
}
