package com.automation.SpringConcepts.di;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class UserViaField {

    @Autowired
    Address address;

    @Autowired
    Salary salary;

    @Autowired
    Mobile mobile;

    public void printUserDetails() {
        System.out.println(address.getAddress());
        System.out.println(salary.getSalary());
        System.out.println(mobile.getPhone());
    }

}
