package com.springbootlog;

import java.lang.annotation.*;


@Documented
@Target({ElementType.METHOD})
@Retention(RetentionPolicy.RUNTIME)
public @interface UserDataLog {
    String operation() default "";
    String msg() default "";
    Constant[] constant() default {};
}
