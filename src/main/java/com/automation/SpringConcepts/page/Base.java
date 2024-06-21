package com.automation.SpringConcepts.page;

import jakarta.annotation.PostConstruct;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.springframework.beans.factory.annotation.Autowired;

public abstract class Base {

        @Autowired
        protected WebDriver webDriver;

        @Autowired
        protected WebDriverWait webDriverWait;

        @PostConstruct
        private void init(){
            PageFactory.initElements(this.webDriver, this);
        }

        public abstract boolean isAt();


}
