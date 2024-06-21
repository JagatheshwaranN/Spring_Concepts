package com.automation.SpringConcepts.page.google;

import com.automation.SpringConcepts.page.Base;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class SearchResult extends Base {

    @FindBy(tagName = "h3")
    private List<WebElement> searchResult;

    public int getResultCount() {
        return this.searchResult.size();
    }

    @Override
    public boolean isAt() {
        return this.webDriverWait.until((driver) -> !this.searchResult.isEmpty());
    }

}
