package com.automation.SpringConcepts.beanscope;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class Fresher {

    @Autowired
    private Increment increment;

    public Increment getIncrement() {
        return increment;
    }

    public void setAmount(int amount){
        this.increment.setAmount(amount);
    }

}
