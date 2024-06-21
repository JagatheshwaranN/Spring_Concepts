package com.automation.SpringConcepts.configuration;

import org.springframework.context.annotation.Configuration;

import org.openqa.selenium.Platform;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.autoconfigure.condition.ConditionalOnMissingBean;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Lazy;
import org.springframework.context.annotation.Profile;

import java.net.MalformedURLException;
import java.net.URI;

@Lazy
@Configuration
@Profile("remote")
public class RemoteWebDriverConfiguration {

    @Value("${selenium.grid.url}")
    private String url;

    @Value("${browser}")
    private String browser;

    DesiredCapabilities capabilities = new DesiredCapabilities();

    @Bean
    @ConditionalOnProperty(name = "browser", havingValue = "firefox")
    public WebDriver remoteFirefoxDriver() {
        System.setProperty("webdriver.http.factory", "jdk-http-client");
        capabilities.setPlatform(Platform.ANY);
        capabilities.setBrowserName("Firefox");
        FirefoxOptions options = new FirefoxOptions();
        // #14125 - Selenium 4.21.0 version bug - Unable to launch session with Grid without below parameter
        options.setEnableDownloads(true);
        options.merge(capabilities);
        try {
            return new RemoteWebDriver(URI.create(url).toURL(), capabilities);
        } catch (MalformedURLException e) {
            throw new RuntimeException(e);
        }
    }

    @Bean
    @ConditionalOnMissingBean
    public WebDriver remoteChromeDriver() throws MalformedURLException {
        ChromeOptions chromeOptions = null;
        System.setProperty("webdriver.http.factory", "jdk-http-client");
        capabilities.setPlatform(Platform.WINDOWS);
        capabilities.setBrowserName(browser);
        chromeOptions = new ChromeOptions();
        // Selenium 4.21.0 version bug - Unable to launch session with Grid without below parameter
        chromeOptions.setEnableDownloads(true);
        chromeOptions.merge(capabilities);
        return new RemoteWebDriver((URI.create(url).toURL()), capabilities);

    }

}
