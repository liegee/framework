package com.ligee.client.user.controller;

import com.ligee.client.user.model.request.LoginRequest;
import com.ligee.client.user.model.request.RegisterRequest;
import com.ligee.client.user.model.response.TokenResponse;
import com.ligee.client.user.service.UserService;
import com.ligee.common.controller.BaseController;
import com.ligee.common.result.SingleResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

/**
 * Author: 李杰
 * Date: 2018/12/7 6:17 PM
 */
@RestController
public class UserController extends BaseController {

    private UserService userService;

    @Autowired
    public UserController(UserService userService){
        this.userService = userService;
    }

    @PostMapping("login")
    public SingleResult<TokenResponse> login(@Valid @RequestBody LoginRequest request, BindingResult result){
        validate(result);
        return userService.login(request);
    }

    @PostMapping("register")
    public SingleResult<TokenResponse> register(@Valid @RequestBody RegisterRequest request, BindingResult result){
        validate(result);
        return userService.register(request);
    }

}
