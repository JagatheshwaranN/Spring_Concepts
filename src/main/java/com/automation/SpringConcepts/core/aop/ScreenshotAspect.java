package com.automation.SpringConcepts.core.aop;

import com.automation.SpringConcepts.core.annotation.Screenshot;
import com.automation.SpringConcepts.core.service.ScreenCapture;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class ScreenshotAspect {

    @Autowired
    private ScreenCapture screenCapture;

    @After("@annotation(screenshot)")
    public void after(Screenshot screenshot){
        this.screenCapture.captureScreenshot();
    }

}
