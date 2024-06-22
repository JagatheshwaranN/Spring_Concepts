package com.automation.SpringConcepts.google;

import com.automation.SpringConcepts.SpringTestNGTest;
import com.automation.SpringConcepts.core.annotation.LazyAutowired;
import com.automation.SpringConcepts.page.google.GooglePage;
import com.automation.SpringConcepts.core.service.ScreenCapture;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Lazy;
import org.testng.Assert;
import org.testng.annotations.Test;

public class GoogleApp2Test extends SpringTestNGTest {

    @LazyAutowired
    private GooglePage googlePage;

    @LazyAutowired
    private ScreenCapture screenCapture;

    @Test
    public void validateGoogleTest2() {
        this.googlePage.launch();
        Assert.assertTrue(this.googlePage.isAt());
        this.googlePage.getSearch().search("Selenium");
        Assert.assertTrue(this.googlePage.getSearchResult().isAt());
        Assert.assertTrue(this.googlePage.getSearchResult().getResultCount() > 10);
        this.screenCapture.captureScreenshot();
        this.googlePage.closeBrowser();
    }

}
