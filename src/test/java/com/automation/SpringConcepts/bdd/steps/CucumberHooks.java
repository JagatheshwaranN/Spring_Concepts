package com.automation.SpringConcepts.bdd.steps;

import com.automation.SpringConcepts.core.annotation.LazyAutowired;
import com.automation.SpringConcepts.core.service.ScreenCapture;
import io.cucumber.java.After;
import io.cucumber.java.AfterStep;
import io.cucumber.java.Scenario;
import org.openqa.selenium.WebDriver;
import org.springframework.context.ApplicationContext;


public class CucumberHooks {

    @LazyAutowired
    ApplicationContext applicationContext;

    @LazyAutowired
    ScreenCapture screenCapture;

    @AfterStep
    public void afterStep(Scenario scenario) {
        if(scenario.isFailed()){
            scenario.attach(this.screenCapture.captureScreenshotByte(), "image/png", scenario.getName());
        }

    }

    @After
    public void afterScenario() {
        this.applicationContext.getBean(WebDriver.class).quit();
    }
}
