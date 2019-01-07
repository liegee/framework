package com.ligee.common.service;

import com.ligee.common.encryption.Algorithm;
import com.ligee.common.encryption.MessageDigestUtils;

/**
 * Author: 李杰
 * Date: 2018/12/7 6:48 PM
 */
public abstract class BaseService {

    /**
     * 密码加密算法
     * @param password
     * @return
     */
    protected String encryptPassword(String password){
        return MessageDigestUtils.encrypt(password, Algorithm.SHA1);
    }

    /**
     * 生成API鉴权的Token
     * @param mobile
     * @param password
     * @return
     */
    protected String getToken(String mobile,String password){
        return MessageDigestUtils.encrypt(mobile+password, Algorithm.SHA1);
    }
}
