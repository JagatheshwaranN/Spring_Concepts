package com.automation.SpringConcepts.flight;

import com.automation.SpringConcepts.SpringTestNGTest;
import com.automation.SpringConcepts.page.flight.FlightPage;
import org.springframework.beans.factory.annotation.Autowired;
import org.testng.Assert;
import org.testng.annotations.Test;

public class FlightTest extends SpringTestNGTest {


    @Autowired
    FlightPage flightPage;

    @Autowired
    FlightAppDetail flightAppDetail;

    @Test
    public void flightAppTest() {
        this.flightPage.launch(this.flightAppDetail.getUrl());
        Assert.assertTrue(this.flightPage.isAt());
        Assert.assertEquals(this.flightPage.getTopNavLabels(), this.flightAppDetail.getTopNavBarLabels());
        this.flightPage.close();
    }

}
