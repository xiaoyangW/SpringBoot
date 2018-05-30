package com.springbootlog;

import java.lang.annotation.*;


@Documented
@Target({ElementType.METHOD,ElementType.TYPE,ElementType.FIELD,ElementType.PARAMETER})
@Retention(RetentionPolicy.RUNTIME)
public @interface UserDataLog {
    String operation() default "";
    String msg() default "";
    Constant[] constant() default {};
}
