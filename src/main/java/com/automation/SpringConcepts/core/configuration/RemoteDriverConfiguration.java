package com.automation.SpringConcepts.core.configuration;

import org.openqa.selenium.edge.EdgeOptions;
import org.springframework.context.annotation.Configuration;

import org.openqa.selenium.Platform;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Lazy;
import org.springframework.context.annotation.Profile;

import java.net.MalformedURLException;
import java.net.URI;

@Lazy
@Configuration
@Profile("remote")
public class RemoteDriverConfiguration {

    @Value("${selenium.grid.url}")
    String url;

    @Value("${browser}")
    String browser;

    DesiredCapabilities capabilities = new DesiredCapabilities();

    @Bean
    public WebDriver remoteDriver() throws MalformedURLException {
        if (browser.equalsIgnoreCase("chrome")) {
            System.setProperty("webdriver.http.factory", "jdk-http-client");
            capabilities.setPlatform(Platform.WINDOWS);
            capabilities.setBrowserName(browser);
            ChromeOptions chromeOptions = new ChromeOptions();
            // Selenium 4.21.0 version bug - Unable to launch session with Grid without below parameter
            chromeOptions.setEnableDownloads(true);
            chromeOptions.merge(capabilities);
        } else if (browser.equalsIgnoreCase("firefox")) {
            System.setProperty("webdriver.http.factory", "jdk-http-client");
            capabilities.setPlatform(Platform.WINDOWS);
            capabilities.setBrowserName(browser);
            FirefoxOptions options = new FirefoxOptions();
            // Selenium 4.21.0 version bug - Unable to launch session with Grid without below parameter
            options.setEnableDownloads(true);
            options.merge(capabilities);
        } else if (browser.equalsIgnoreCase("edge")) {
            System.setProperty("webdriver.http.factory", "jdk-http-client");
            capabilities.setPlatform(Platform.WINDOWS);
            capabilities.setBrowserName("MicrosoftEdge");
            EdgeOptions options = new EdgeOptions();
            // Selenium 4.21.0 version bug - Unable to launch session with Grid without below parameter
            options.setEnableDownloads(true);
            options.merge(capabilities);
        }
        return new RemoteWebDriver((URI.create(url).toURL()), capabilities);
    }

}
