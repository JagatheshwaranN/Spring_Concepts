package com.automation.SpringConcepts.di;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
public class Address {

    @Value("${location}")
    String location;

    public String getAddress(){
        return location;
    }

}
