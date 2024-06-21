package com.automation.SpringConcepts.configuration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.autoconfigure.condition.ConditionalOnMissingBean;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.context.annotation.Profile;

import java.time.Duration;

@Configuration
@Profile("!remote")
public class WebDriverConfiguration {

    @Bean
    // @Primary
    @ConditionalOnProperty(name = "browser", havingValue = "firefox")
    public WebDriver firefoxDriver() {
        return new FirefoxDriver();
    }

    @Bean
    //@ConditionalOnProperty(name = "browser", havingValue = "chrome")
    @ConditionalOnMissingBean
    public WebDriver chromeDriver() {
        return new ChromeDriver();
    }

}
