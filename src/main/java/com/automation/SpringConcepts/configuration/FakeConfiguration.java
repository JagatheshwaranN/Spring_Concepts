package com.automation.SpringConcepts.configuration;

import com.github.javafaker.Faker;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class FakeConfiguration {

    @Bean
    public Faker getFaker(){
        return new Faker();
    }
}
