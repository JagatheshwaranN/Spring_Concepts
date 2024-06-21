package com.automation.SpringConcepts.condition;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.autoconfigure.condition.ConditionalOnExpression;
import org.springframework.stereotype.Component;

@Component
// @ConditionalOnExpression("${car.speed} <= 100")
@Qualifier("BMW")
public class BMW implements Car {
    @Override
    public void run() {
        System.out.println("This is BMW. The Speed is 100 Km-ph");
    }

}
