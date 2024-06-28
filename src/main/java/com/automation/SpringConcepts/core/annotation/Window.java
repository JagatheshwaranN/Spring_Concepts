package com.automation.SpringConcepts.core.annotation;


import java.lang.annotation.*;

@Documented
@Retention(RetentionPolicy.RUNTIME)
@Target({ElementType.TYPE})
@Page
public @interface Window {
    String value() default "";
}
