package com.example.demo.annotation;

import java.lang.annotation.Documented;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.Target;

import static java.lang.annotation.RetentionPolicy.RUNTIME;

@Target({ElementType.METHOD,ElementType.TYPE})
@Retention(RUNTIME)
@Documented
public @interface AnnotationForUs {
    String name() default ("AnnotationForUs,name默认值");
}
