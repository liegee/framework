package com.ligee.client.user.service;

import com.ligee.client.user.mapper.UserMapper;
import com.ligee.client.user.model.bean.UserBean;
import com.ligee.client.user.model.request.LoginRequest;
import com.ligee.client.user.model.request.RegisterRequest;
import com.ligee.client.user.model.response.TokenResponse;
import com.ligee.common.result.Code;
import com.ligee.common.result.SingleResult;
import com.ligee.common.service.BaseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * Author: 李杰
 * Date: 2018/12/7 6:23 PM
 */
@Transactional(rollbackFor = Exception.class)
@Service
public class UserService extends BaseService {

    private UserMapper userMapper;

    @Autowired
    public UserService(UserMapper userMapper){
        this.userMapper = userMapper;
    }

    public SingleResult<TokenResponse> login(LoginRequest request){
        List<UserBean> userList = userMapper.selectUser(request.getMobile(),request.getPassword());
        if(null != userList && userList.size() > 0){
            String token = getToken(request.getMobile(),request.getPassword());
            TokenResponse response = new TokenResponse();
            response.setToken(token);
            return SingleResult.buildSuccess(response);
        }else {
            return SingleResult.buildFailure(Code.ERROR,"手机号或密码输入不正确！");
        }
    }

    public SingleResult<TokenResponse> register(RegisterRequest request){
        List<UserBean> userList = userMapper.selectUser(request.getMobile());
        if(null != userList && userList.size() > 0){
            String token = getToken(request.getMobile(),request.getPassword());
            TokenResponse response = new TokenResponse();
            response.setToken(token);
            return SingleResult.buildSuccess(response);
        }else {
            return SingleResult.buildFailure(Code.ERROR,"手机号或密码输入不正确！");
        }
    }
}
