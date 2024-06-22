package com.automation.SpringConcepts.core.configuration;

import com.automation.SpringConcepts.core.annotation.ThreadScope;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.springframework.boot.autoconfigure.condition.ConditionalOnMissingBean;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;
import org.springframework.context.annotation.Scope;

@Configuration
@Profile("!remote")
public class DriverConfiguration {

    @ThreadScope
    //@ConditionalOnProperty(name = "browser", havingValue = "firefox")
    // @Primary
    public WebDriver firefoxDriver() {
        return new FirefoxDriver();
    }

    @ThreadScope
    //@ConditionalOnMissingBean
    //@ConditionalOnProperty(name = "browser", havingValue = "chrome")
    public WebDriver chromeDriver() {
        return new ChromeDriver();
    }

}
