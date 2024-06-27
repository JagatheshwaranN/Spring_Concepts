package com.automation.SpringConcepts.bdd.runner;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;
import org.testng.annotations.DataProvider;

@CucumberOptions(
        features = "classpath:features",
        glue = "com.automation.SpringConcepts.bdd.steps",
        tags = "@visa",
        plugin = {
                "pretty",
                "html:D://Environment_Collection//Intellij_Env//SpringConcepts//SpringConcepts//cucumber-report.html"
        },
        publish = true
)
public class CucumberRunnerTest extends AbstractTestNGCucumberTests {

        @Override
        @DataProvider(parallel = true)
        public Object[][] scenarios() {
                return super.scenarios();
        }
}

