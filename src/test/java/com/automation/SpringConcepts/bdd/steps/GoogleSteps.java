package com.automation.SpringConcepts.bdd.steps;

import com.automation.SpringConcepts.core.annotation.LazyAutowired;
import com.automation.SpringConcepts.page.google.GooglePage;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.cucumber.spring.CucumberContextConfiguration;
import org.springframework.boot.test.context.SpringBootTest;
import org.testng.Assert;

@CucumberContextConfiguration
@SpringBootTest
//@TestPropertySource(properties = "browser=chrome")
public class GoogleSteps {

    @LazyAutowired
    GooglePage googlePage;

    @Given("I am on the google home page")
    public void launchGoogleSite() {
        this.googlePage.launch();
        Assert.assertTrue(this.googlePage.isAt());
    }

    @When("I type {string} and click on search button")
    public void searchOnGoogle(String keyword) {
        this.googlePage.getSearch().search(keyword);
        Assert.assertTrue(this.googlePage.getSearch().isAt());
    }

    @Then("I should see at least {int} search results")
    public void verifySearchResult(int count) {
        Assert.assertTrue(this.googlePage.getSearchResult().getResultCount() >= count);
    }

}
