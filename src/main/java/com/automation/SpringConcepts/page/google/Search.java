package com.automation.SpringConcepts.page.google;

import com.automation.SpringConcepts.page.Base;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class Search extends Base {

    @FindBy(name = "q")
    private WebElement searchBar;

    @FindBy(name="btnK")
    private List<WebElement> searchButtons;

    public void search(String value){
        this.searchBar.sendKeys(value);
        this.searchBar.sendKeys(Keys.TAB);
        this.searchButtons.stream()
                .filter(ele -> ele.isDisplayed() &&  ele.isEnabled())
                .findFirst()
                .ifPresent(WebElement::click);
    }

    @Override
    public boolean isAt() {
        return this.webDriverWait.until((driver) -> this.searchBar.isDisplayed());
    }
}
