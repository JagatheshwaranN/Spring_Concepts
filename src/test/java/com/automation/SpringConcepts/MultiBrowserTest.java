package com.automation.SpringConcepts;

import org.openqa.selenium.WebDriver;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.testng.annotations.Test;

public class MultiBrowserTest extends SpringTestNGTest {

    @Autowired
    ApplicationContext applicationContext;

    @Test
    public void multiBrowserTest() {
        this.applicationContext.getBean("chromeDriver", WebDriver.class).get("https://www.google.com/");
        this.applicationContext.getBean("firefoxDriver", WebDriver.class).get("https://www.yahoo.com/");
    }
}
