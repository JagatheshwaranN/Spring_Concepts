package com.automation.SpringConcepts.window;

import com.automation.SpringConcepts.SpringTestNGTest;
import com.automation.SpringConcepts.core.service.SwitchWindow;
import com.automation.SpringConcepts.page.window.FirstPage;
import com.automation.SpringConcepts.page.window.MainPage;
import com.automation.SpringConcepts.page.window.SecondPage;
import com.automation.SpringConcepts.page.window.ThirdPage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class SwitchWindowTest extends SpringTestNGTest {

    @Autowired
    private MainPage mainPage;

    @Autowired
    private FirstPage firstPage;

    @Autowired
    private SecondPage secondPage;

    @Autowired
    private ThirdPage thirdPage;

    @Autowired
    private SwitchWindow switchWindow;

    @Value("${window.url}")
    private String url;

    @BeforeClass
    public void setup() {
        mainPage.launch(url);
        mainPage.isAt();
        mainPage.openAllWindows();
    }

    @Test
    public void switchWindowTest() {
        this.switchWindow.switchWindowByTitle("Page A");
        this.firstPage.enterMessage("Hi First Page");
        this.switchWindow.switchWindowByIndex(2);
        this.secondPage.enterMessage("Hello Second Page");
    }

}
