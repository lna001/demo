package com.demo.annotation;

import java.lang.annotation.*;

/**
 * Created by user on 2018/1/18.
 * 在类或方法上添加@Auth就验证登录
 */
@Target({ElementType.TYPE, ElementType.METHOD})
@Retention(RetentionPolicy.RUNTIME)
@Documented
public @interface Auth {
}
