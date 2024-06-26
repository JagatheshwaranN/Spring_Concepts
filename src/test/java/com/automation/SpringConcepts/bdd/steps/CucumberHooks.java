package com.automation.SpringConcepts.bdd.steps;

import com.automation.SpringConcepts.core.annotation.LazyAutowired;
import com.automation.SpringConcepts.core.service.ScreenCapture;
import io.cucumber.java.After;
import io.cucumber.java.AfterStep;
import io.cucumber.java.Scenario;
import org.openqa.selenium.WebDriver;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.ApplicationContext;

import java.nio.file.Path;

public class CucumberHooks {

    @LazyAutowired
    ApplicationContext applicationContext;

    @LazyAutowired
    private ScreenCapture screenCapture;

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
