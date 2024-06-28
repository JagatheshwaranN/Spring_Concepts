package com.automation.SpringConcepts.beanlifecycle;


import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class BeanCycleTest {

	@Autowired
	Television television;

	@Test
	void validateTelevision() {
		television.playChannel();
	}

}
