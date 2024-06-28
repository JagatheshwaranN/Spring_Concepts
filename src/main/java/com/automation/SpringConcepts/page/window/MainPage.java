package com.automation.SpringConcepts.page.window;

import com.automation.SpringConcepts.core.annotation.Page;
import com.automation.SpringConcepts.page.Base;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;

import java.util.List;

@Page
public class MainPage extends Base {

    @FindBy(tagName = "a")
    List<WebElement> links;

    public void launch(String url) {
        this.webDriver.get(url);
    }

    public void openAllWindows() {

        //this.links.forEach(WebElement::click);
        for (int i = 0; i < links.size(); i++) {
            links.get(i).click();
            this.webDriverWait.until(ExpectedConditions.numberOfWindowsToBe(i + 2));
        }
    }

    @Override
    public boolean isAt() {
        return this.webDriverWait.until(driver -> !this.links.isEmpty());
    }
}
