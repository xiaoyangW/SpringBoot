package com.springbootlog;

import java.lang.annotation.*;

@Target({ElementType.METHOD})
@Retention(RetentionPolicy.RUNTIME)
@Documented
public @interface UserDataLog {
    String operation() default "";
    String msg() default "";
    Constant[] constant() default {};
}
