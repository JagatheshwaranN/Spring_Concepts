package com.automation.SpringConcepts.core.service;

import org.openqa.selenium.WebDriver;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.stereotype.Service;

@Service
public class SwitchWindow {

    @Autowired
    ApplicationContext applicationContext;

    public void switchWindowByTitle(String windowTitle){
        WebDriver driver = this.applicationContext.getBean(WebDriver.class);
        driver.getWindowHandles()
                .stream()
                .map(handle -> driver.switchTo().window(handle).getTitle())
                .filter(title -> title.startsWith(windowTitle))
                .findFirst()
                .orElseThrow(()-> new RuntimeException("No Such Window!"));
    }

    public void switchWindowByIndex(int windowIndex){
        WebDriver driver = this.applicationContext.getBean(WebDriver.class);
        String[] handles = driver.getWindowHandles().toArray(new String[0]);
        driver.switchTo().window(handles[windowIndex]);
    }

}
