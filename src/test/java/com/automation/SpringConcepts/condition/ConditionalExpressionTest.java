package com.automation.SpringConcepts.condition;

import com.automation.SpringConcepts.SpringTestNGTest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.testng.annotations.Test;

public class ConditionalExpressionTest extends SpringTestNGTest {

    @Autowired
    @Qualifier("Audi")
    private Car car;

    @Test
    public void validateCarTest() {
        this.car.run();
    }

}
