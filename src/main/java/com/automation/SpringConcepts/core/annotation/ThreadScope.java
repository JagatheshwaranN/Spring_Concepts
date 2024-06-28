package com.automation.SpringConcepts.core.annotation;


import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Scope;


import java.lang.annotation.*;


@Documented
@Retention(RetentionPolicy.RUNTIME)
@Target({ElementType.METHOD})
@Bean
@Scope("browser-scope")
public @interface ThreadScope {
}
