package com.automation.SpringConcepts.page.visa;

import com.automation.SpringConcepts.core.annotation.Page;
import com.automation.SpringConcepts.page.Base;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.Select;

import java.time.LocalDate;
import java.util.Objects;

@Page
public class VisaRegistrationPage extends Base {

    @FindBy(id = "first_4")
    private WebElement firstName;

    @FindBy(id = "last_4")
    private WebElement lastName;

    @FindBy(id = "input_46")
    private WebElement fromCountry;

    @FindBy(id = "input_47")
    private WebElement toCountry;

    @FindBy(id = "input_24_month")
    private WebElement birthMonth;

    @FindBy(id = "input_24_day")
    private WebElement birthDay;

    @FindBy(id = "input_24_year")
    private WebElement birthYear;

    @FindBy(id = "input_6")
    private WebElement userEmail;

    @FindBy(id = "input_27_phone")
    private WebElement phoneNumber;

    @FindBy(id = "input_45")
    private WebElement comments;

    @FindBy(id = "submitBtn")
    private WebElement submit;

    @FindBy(id = "requestnumber")
    private WebElement requestNumber;

    public void launch(String url) {
        this.webDriver.manage().window().maximize();
        this.webDriver.get(url);
    }

    public void fillName(String fName, String lName) {
        this.firstName.sendKeys(fName);
        this.lastName.sendKeys(lName);
    }

    public void selectCountries(String fromCountry, String toCountry) {
        new Select(this.fromCountry).selectByValue(fromCountry);
        new Select(this.toCountry).selectByValue(toCountry);
    }

    public void fillBirthDate(LocalDate localDate) {
        new Select(this.birthYear).selectByVisibleText(String.valueOf(localDate.getYear()));
        new Select(this.birthDay).selectByVisibleText(String.valueOf(localDate.getDayOfMonth()));
        new Select(this.birthMonth).selectByValue(localDate.getMonth().toString());
    }

    public void fillContactDetails(String email, String phone) {
        this.userEmail.sendKeys(email);
        this.phoneNumber.sendKeys(phone);
    }

    public void fillComments(String comment) {
        this.comments.sendKeys(Objects.toString(comment, ""));
    }

    public void submitForm() {
        this.submit.click();
    }

    public String getConfirmationNumber() {
        this.webDriverWait.until(driver -> this.requestNumber.isDisplayed());
        return this.requestNumber.getText();
    }

    @Override
    public boolean isAt() {
        return this.webDriverWait.until(driver -> this.firstName.isDisplayed());
    }

    public void close() {
        this.webDriver.quit();
    }

}
