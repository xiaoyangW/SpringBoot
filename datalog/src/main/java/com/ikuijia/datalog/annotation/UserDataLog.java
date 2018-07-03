package com.ikuijia.datalog.annotation;

import java.lang.annotation.*;


@Documented
@Target({ElementType.TYPE, ElementType.METHOD, ElementType.FIELD})
@Retention(RetentionPolicy.RUNTIME)
public @interface UserDataLog {
    String operation() default "";
    String msg() default "";
}
