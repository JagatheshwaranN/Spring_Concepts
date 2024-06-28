package com.automation.SpringConcepts.di;

import com.github.javafaker.Faker;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class Mobile {

    @Autowired
    Faker faker;

    public String getPhone() {
        return this.faker.phoneNumber().cellPhone();
    }

}
