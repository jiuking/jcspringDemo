package com.hjc.index.annotation;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Target(ElementType.METHOD)
@Retention(RetentionPolicy.RUNTIME)
public @interface LogAdvice {
    String value() default "";

    Type type() default Type.FIRST;

    enum Type{
        FIRST("第一步"),SECOND("第二步");
        String value = "";

        Type(String value) {
            this.value = value;
        }

        public String getValue() {
            return value;
        }
    }
}
