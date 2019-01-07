package com.ligee.common.annotation;

import java.lang.annotation.*;

/**
 * Author: 李杰
 * Date: 2018/12/7 6:32 PM
 * 禁用加解密
 */
@Target(ElementType.METHOD)
@Retention(RetentionPolicy.RUNTIME)
@Documented
public @interface DisabledEncrypt {
}
