package com.ligee.common.annotation;

import com.ligee.common.configuration.EncryptAutoConfiguration;
import org.springframework.context.annotation.Import;

import java.lang.annotation.*;

/**
 * Author: 李杰
 * Date: 2018/12/7 6:33 PM
 */
@Target({ElementType.TYPE})
@Retention(RetentionPolicy.RUNTIME)
@Documented
@Inherited
@Import({EncryptAutoConfiguration.class})
public @interface EnableEncrypt {
}
