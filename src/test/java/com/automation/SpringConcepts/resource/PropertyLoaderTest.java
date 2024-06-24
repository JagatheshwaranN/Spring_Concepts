package com.automation.SpringConcepts.resource;

import com.automation.SpringConcepts.SpringTestNGTest;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.ResourceLoader;
import org.springframework.core.io.support.PropertiesLoaderUtils;
import org.testng.annotations.Test;

import java.io.IOException;
import java.util.Properties;

public class PropertyLoaderTest extends SpringTestNGTest {

    private static final Logger logger = LoggerFactory.getLogger(PropertyLoaderTest.class);

    @Autowired
    private ResourceLoader resourceLoader;

    @Test
    public void propertyLoaderTest() {

        try {
            Properties properties = PropertiesLoaderUtils.loadProperties(resourceLoader.getResource("data/test.properties"));
            logger.info(String.valueOf(properties));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

}
