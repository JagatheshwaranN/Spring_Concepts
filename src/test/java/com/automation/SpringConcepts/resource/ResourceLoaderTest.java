package com.automation.SpringConcepts.resource;

import com.automation.SpringConcepts.SpringTestNGTest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.io.Resource;
import org.springframework.core.io.ResourceLoader;
import org.springframework.util.FileCopyUtils;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;

public class ResourceLoaderTest extends SpringTestNGTest {

    @Autowired
    ResourceLoader resourceLoader;

    @Value("classpath:data/link.csv")
    private Resource resource;

    @Value("${download.path}")
    private Path path;

    @Test(dataProvider = "getData")
    public void resourceLoaderTest(String url, String file) throws IOException {
        FileCopyUtils.copy(resourceLoader.getResource(url).getInputStream(),
                Files.newOutputStream(path.resolve(file)));
    }

    @DataProvider
    public Object[][] getData() throws IOException {
        return Files.readAllLines(resource.getFile().toPath())
                .stream()
                .map(content -> content.split(","))
                .toArray(Object[][]::new);
    }
}
