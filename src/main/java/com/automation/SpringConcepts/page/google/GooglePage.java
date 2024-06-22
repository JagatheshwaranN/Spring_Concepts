package com.automation.SpringConcepts.page.google;


import com.automation.SpringConcepts.annotation.Page;
import com.automation.SpringConcepts.page.Base;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;


@Page
public class GooglePage extends Base {

    @Autowired
    private Search search;

    @Autowired
    private SearchResult searchResult;

    @Value("${application.url}")
    private String appURL;

    public void launch() {
        this.webDriver.manage().window().maximize();
        this.webDriver.get(appURL);
    }

    public Search getSearch() {
        return search;
    }

    public SearchResult getSearchResult() {
        return searchResult;
    }

    @Override
    public boolean isAt() {
        return this.search.isAt();
    }

    public void closeBrowser() {
        this.webDriver.quit();
    }

}
