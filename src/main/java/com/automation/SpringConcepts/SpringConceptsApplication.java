package com.automation.SpringConcepts;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.mongo.MongoAutoConfiguration;

@SpringBootApplication(exclude = MongoAutoConfiguration.class)
public class SpringConceptsApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringConceptsApplication.class, args);
	}

}
