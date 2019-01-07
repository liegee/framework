package com.ligee.common.controller;

import org.springframework.util.Assert;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;

import java.util.List;

/**
 * Author: 李杰
 * Date: 2018/12/7 6:36 PM
 */
public abstract class BaseController {

    /**
     * 接口输入参数合法性校验
     * @param result
     */
    protected void validate(BindingResult result){
        if(result.hasFieldErrors()){
            List<FieldError> errorList = result.getFieldErrors();
            errorList.forEach(item -> Assert.isTrue(false, item.getDefaultMessage()));
        }
    }
}
