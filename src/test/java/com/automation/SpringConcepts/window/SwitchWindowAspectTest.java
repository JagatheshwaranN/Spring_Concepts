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
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class SwitchWindowAspectTest extends SpringTestNGTest {

    @Autowired
    private MainPage mainPage;

    @Autowired
    private FirstPage firstPage;

    @Autowired
    private SecondPage secondPage;

    @Autowired
    private ThirdPage thirdPage;

    @Value("${window.url}")
    private String url;

    @BeforeClass
    public void setup() {
        mainPage.launch(url);
        mainPage.isAt();
        mainPage.openAllWindows();
    }

    @Test(dataProvider = "getData")
    public void switchWindowTest(int number) {
        this.firstPage.enterMessage(number + "\n");
        this.secondPage.enterMessage((number * 2) + "\n");
        this.thirdPage.enterMessage((number * 3) + "\n");
    }

    @DataProvider
    public Object[] getData() {
        return new Object[]{
                2, 4, 6, 8, 10
        };
    }

}
