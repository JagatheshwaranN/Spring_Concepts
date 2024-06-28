package com.automation.SpringConcepts.core.service;

import com.github.javafaker.Faker;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
import org.springframework.util.FileCopyUtils;

import java.io.File;
import java.io.IOException;
import java.nio.file.Path;

@Lazy
@Service
public class ScreenCapture {

    @Autowired
    ApplicationContext applicationContext;

    @Autowired
    Faker faker;

    @Value("${screen.path}")
    Path path;


    public void captureScreenshot() {
        File src = this.applicationContext.getBean(TakesScreenshot.class).getScreenshotAs(OutputType.FILE);
        try {
            FileCopyUtils.copy(src, path.resolve(faker.random().nextInt(1001, 9999) +".png").toFile());
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public byte[] captureScreenshotByte() {
        return this.applicationContext.getBean(TakesScreenshot.class).getScreenshotAs(OutputType.BYTES);
    }

}
