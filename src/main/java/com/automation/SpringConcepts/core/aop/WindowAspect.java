package com.automation.SpringConcepts.core.aop;

import com.automation.SpringConcepts.core.annotation.Window;
import com.automation.SpringConcepts.core.service.SwitchWindow;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class WindowAspect {

    @Autowired
    private SwitchWindow switchWindow;

    @Before("@target(window) && within(com.automation.SpringConcepts..*)")
    public void before(Window window){
        this.switchWindow.switchWindowByTitle(window.value());
    }

    @Before("@target(window) && within(com.automation.SpringConcepts..*)")
    public void after(Window window){
        this.switchWindow.switchWindowByIndex(0);
    }

}
