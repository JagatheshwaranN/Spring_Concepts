package com.automation.SpringConcepts.google;

import com.automation.SpringConcepts.SpringTestNGTest;
import com.automation.SpringConcepts.core.annotation.LazyAutowired;
import com.automation.SpringConcepts.page.google.GooglePage;
import com.automation.SpringConcepts.core.service.ScreenCapture;
import com.google.common.util.concurrent.Uninterruptibles;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Lazy;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

public class GoogleApp1Test extends SpringTestNGTest {

    @LazyAutowired
    GooglePage googlePage;

    @LazyAutowired
    ScreenCapture screenCapture;

    @Test
    public void validateGoogleTest1() {
        this.googlePage.launch();
        Assert.assertTrue(this.googlePage.isAt());
        Uninterruptibles.sleepUninterruptibly(3, TimeUnit.SECONDS);
        this.googlePage.getSearch().search("Spring Boot");
        Assert.assertTrue(this.googlePage.getSearchResult().isAt());
        Assert.assertTrue(this.googlePage.getSearchResult().getResultCount() > 10);
        this.screenCapture.captureScreenshot();
        this.googlePage.closeBrowser();
    }

}
