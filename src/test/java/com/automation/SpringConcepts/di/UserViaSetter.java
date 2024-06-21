package com.automation.SpringConcepts.di;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class UserViaSetter {

    private Address address;

    private Salary salary;

    private Mobile mobile;

    @Autowired
    public void setAddress(Address address) {
        this.address = address;
    }

    @Autowired
    public void setSalary(Salary salary) {
        this.salary = salary;
    }

    @Autowired
    public void setMobile(Mobile mobile) {
        this.mobile = mobile;
    }

    public void printUserDetails() {
        System.out.println(address.getAddress());
        System.out.println(salary.getSalary());
        System.out.println(mobile.getPhone());
    }

}
