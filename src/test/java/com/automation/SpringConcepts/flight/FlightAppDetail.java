package com.automation.SpringConcepts.flight;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.PropertySource;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
@PropertySource("lang/${app.language}.properties")
public class FlightAppDetail {

    @Value("${flight.app.url}")
    private String url;

    @Value("${flight.app.topnavbar.labels}")
    private List<String> topNavBarLabels;

    public String getUrl() {
        return url;
    }

    public List<String> getTopNavBarLabels() {
        return topNavBarLabels;
    }

}