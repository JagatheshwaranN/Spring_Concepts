package com.automation.SpringConcepts.util;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Component;
import org.springframework.util.FileCopyUtils;

import java.io.File;
import java.io.IOException;
import java.nio.file.Path;

@Lazy
@Component
public class ScreenCapture {

    @Autowired
    private TakesScreenshot takesScreenshot;

    @Value("${screen.path}")
    private Path path;


    public void captureScreenshot(String fileName) {
        File src = this.takesScreenshot.getScreenshotAs(OutputType.FILE);
        try {
            FileCopyUtils.copy(src, path.resolve(fileName).toFile());
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
