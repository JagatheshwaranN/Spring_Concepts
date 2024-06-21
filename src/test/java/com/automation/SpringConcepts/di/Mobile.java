package com.automation.SpringConcepts.di;

import com.github.javafaker.Faker;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
public class Mobile {

    @Value("${phone}")
    private String phone;

    @Autowired
    private Faker faker;

    public String getPhone() {
        return this.faker.phoneNumber().cellPhone();
    }

}
