package com.automation.SpringConcepts.page.window;

import com.automation.SpringConcepts.core.annotation.Page;
import com.automation.SpringConcepts.core.annotation.Window;
import com.automation.SpringConcepts.page.Base;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

@Window("Page C")
public class ThirdPage extends Base {

    @FindBy(id = "area")
    WebElement textArea;

    public void enterMessage(String message){
        this.textArea.sendKeys(message);
    }

    @Override
    public boolean isAt() {
        return this.webDriverWait.until(driver -> !this.textArea.isDisplayed());
    }
}
