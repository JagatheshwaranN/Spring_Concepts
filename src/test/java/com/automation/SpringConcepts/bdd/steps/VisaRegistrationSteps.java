package com.automation.SpringConcepts.bdd.steps;

import com.automation.SpringConcepts.core.annotation.LazyAutowired;
import com.automation.SpringConcepts.page.visa.VisaRegistrationPage;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.cucumber.spring.CucumberContextConfiguration;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.test.context.SpringBootTest;
import org.testng.Assert;

import java.time.LocalDate;

public class VisaRegistrationSteps {

    @LazyAutowired
    VisaRegistrationPage visaRegistrationPage;

    @Value("${visa.url}")
    String url;

    @Given("I am on the Visa Registration home page")
    public void iAmOnTheVisaRegistrationHomePage() {
        this.visaRegistrationPage.launch(url);
        Assert.assertTrue(this.visaRegistrationPage.isAt());
    }

    @When("I enter {string} and {string} on the name details section")
    public void iEnterAndOnTheNameDetailsSection(String firstName, String lastName) {
        this.visaRegistrationPage.fillName(firstName, lastName);
    }

    @And("I select {string} and {string} on the country details section")
    public void iSelectAndOnTheCountryDetailsSection(String fromCountry, String toCountry) {
        this.visaRegistrationPage.selectCountries(fromCountry, toCountry);
    }

    @And("I select {string} on the birth date details section")
    public void iSelectOnTheBirthDateDetailsSection(String birthDate) {
        this.visaRegistrationPage.fillBirthDate(LocalDate.parse(birthDate));
    }

    @And("I type {string} and {string} on the contact details section")
    public void iTypeAndOnTheContactDetailsSection(String userEmail, String phoneNumber) {
        this.visaRegistrationPage.fillContactDetails(userEmail, phoneNumber);
    }

    @And("I type {string} on the additional comments section")
    public void iTypeOnTheAdditionalCommentsSection(String comments) {
        this.visaRegistrationPage.fillComments(comments);
    }

    @And("I click on submit application button")
    public void iClickOnSubmitApplicationButton() {
        this.visaRegistrationPage.submitForm();
    }

    @Then("I should see the visa registration confirmation number")
    public void iShouldSeeTheVisaRegistrationConfirmationNumber() {
        System.out.println(this.visaRegistrationPage.getConfirmationNumber());
    }

}
