package com.ligee.client.user.model.bean;

import com.ligee.common.model.BaseModel;

/**
 * Author: 李杰
 * Date: 2018/12/7 6:19 PM
 */
public class UserBean extends BaseModel {

    private String mobile;

    private String password;

    public String getMobile() {
        return mobile;
    }

    public void setMobile(String mobile) {
        this.mobile = mobile;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
