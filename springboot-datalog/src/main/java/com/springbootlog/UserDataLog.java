package com.springbootlog;

import java.lang.annotation.*;

import static java.lang.annotation.ElementType.METHOD;

@Documented
@Target(METHOD)
@Retention(RetentionPolicy.RUNTIME)
public @interface UserDataLog {
    String operation() default "";
    String msg() default "";
    Constant[] constant() default {};
}
