package com.jforj.redistest.annotation;

import java.lang.annotation.*;

@Target(ElementType.METHOD)
@Retention(RetentionPolicy.RUNTIME)
@Documented
@Inherited
public @interface MyCacheable {
    String value() default "";

    String key() default "";

    String condition() default "";

    int expire() default 3600;
}
