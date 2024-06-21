package com.automation.SpringConcepts.di;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

@SpringBootTest
public class DependencyInjectionTest {

    @Autowired
    private UserViaConstructor user;

    @Autowired
    private UserViaSetter userViaSetter;

    @Autowired
    private UserViaField userViaField;

    @Value("${name:Test}")
    private String name;

    @Value("${timeout}")
    private int timeout;

    @Value("${browsers}")
    private List<String> browsers;

    @Test
    void validateUserViaConstructorTest() {
        user.printUserDetails();
    }

    @Test
    void validateUserViaSetterTest() {
        userViaSetter.printUserDetails();
    }

    @Test
    void validateUserViaFieldTest() {
        userViaField.printUserDetails();
    }

    @Test
    void validateValuesInjection() {
        System.out.println(this.name);
        System.out.println(this.timeout);
        System.out.println(this.browsers);
    }


}
