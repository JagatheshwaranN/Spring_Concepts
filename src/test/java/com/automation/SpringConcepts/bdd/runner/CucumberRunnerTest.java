package com.automation.SpringConcepts.bdd.runner;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

@CucumberOptions(
        features = "classpath:features/GoogleSearch.feature",
        glue = "com.automation.SpringConcepts.bdd.steps",
        plugin = {
                "pretty",
                "html:D://Environment_Collection//Intellij_Env//SpringConcepts//SpringConcepts//report.html"
        },
        publish = true
)
public class CucumberRunnerTest extends AbstractTestNGCucumberTests {
}
