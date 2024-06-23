package com.automation.SpringConcepts.page.window;

import com.automation.SpringConcepts.core.annotation.Page;
import com.automation.SpringConcepts.page.Base;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

@Page
public class SecondPage extends Base {

    @FindBy(id = "area")
    private WebElement textArea;

    public void enterMessage(String message){
        this.textArea.sendKeys(message);
    }

    @Override
    public boolean isAt() {
        return this.webDriverWait.until(driver -> !this.textArea.isDisplayed());
    }
}
