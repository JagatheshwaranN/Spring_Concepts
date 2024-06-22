package com.automation.SpringConcepts.resource;

import com.automation.SpringConcepts.SpringTestNGTest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.ResourceLoader;
import org.springframework.core.io.support.PropertiesLoaderUtils;
import org.testng.annotations.Test;

import java.io.IOException;
import java.util.Properties;

public class PropertyLoaderTest extends SpringTestNGTest {

    @Autowired
    private ResourceLoader resourceLoader;

    @Test
    public void propertyLoaderTest() {

        try {
            Properties properties = PropertiesLoaderUtils.loadProperties(resourceLoader.getResource("data/test.properties"));
            System.out.println(properties);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

}
