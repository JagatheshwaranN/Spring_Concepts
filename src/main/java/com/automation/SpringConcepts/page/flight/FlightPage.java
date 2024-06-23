package com.automation.SpringConcepts.page.flight;

import com.automation.SpringConcepts.core.annotation.Page;
import com.automation.SpringConcepts.page.Base;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.List;
import java.util.stream.Collectors;

@Page
public class FlightPage extends Base {


    @FindBy(css = ".P6Wwdb.OE019d  .VfPpkd-dgl2Hf-ppHlrf-sM5MNb .VfPpkd-vQzf8d")
    private List<WebElement> topNavBars;

    public void launch(String url) {
        this.webDriver.manage().window().maximize();
        this.webDriver.get(url);
    }

    public List<String> getTopNavLabels() {
        return this.topNavBars
                .stream()
                .map(WebElement::getText)
                .map(String::trim)
                .collect(Collectors.toList());
    }

    @Override
    public boolean isAt() {
        return this.webDriverWait.until((driver) -> !topNavBars.isEmpty());
    }


    public void close() {
        this.webDriver.quit();
    }

}
