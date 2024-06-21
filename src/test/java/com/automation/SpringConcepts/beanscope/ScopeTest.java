package com.automation.SpringConcepts.beanscope;

import com.automation.SpringConcepts.SpringTestNGTest;
import org.springframework.beans.factory.annotation.Autowired;
import org.testng.annotations.Test;

public class ScopeTest extends SpringTestNGTest {

    @Autowired
    Fresher fresher;

    @Autowired
    Experienced experienced;

    @Test
    public void scopeTest() {
        this.fresher.setAmount(100);
        System.out.println("Fresher Salary : "+ this.fresher.getIncrement().getAmount());
        this.experienced.setAmount(200);
        System.out.println("Experienced Salary : "+ this.experienced.getIncrement().getAmount());
        System.out.println("Fresher Salary : "+ this.fresher.getIncrement().getAmount());
    }
}
