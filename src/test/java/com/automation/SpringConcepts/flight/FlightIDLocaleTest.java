package com.automation.SpringConcepts.flight;

import org.springframework.test.context.TestPropertySource;

@TestPropertySource(properties = {"app.locale=id", "browser=firefox"})
public class FlightIDLocaleTest extends FlightTest {

}
