package com.automation.SpringConcepts.resource;

import com.automation.SpringConcepts.SpringTestNGTest;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.io.Resource;
import org.springframework.util.FileCopyUtils;
import org.testng.annotations.Test;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;

public class ResourceTest extends SpringTestNGTest {

    @Value("classpath:data/user.csv")
    private Resource userFile;

    @Value("file:D:\\Environment_Collection\\Intellij_Env\\SpringConcepts\\user_external.csv")
    private Resource userExternalFile;

    @Value("https://opensource-demo.orangehrmlive.com/web/index.php")
    private Resource webPageResource;

    @Value("https://www.rfc-editor.org/rfc/rfc4021.txt")
    private Resource webContent;

    @Value("${download.path}/web-file.txt")
    private Path path;

    @Test(enabled = false)
    public void testProjectFile(){
        try {
            Files.readAllLines(userFile.getFile().toPath()).forEach(System.out::println);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    @Test(enabled = false)
    public void testExternalFile(){
        try {
            Files.readAllLines(userFile.getFile().toPath()).forEach(System.out::println);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    @Test(enabled = false)
    public void testWebPage(){
        try {
            System.out.println(new String(webPageResource.getInputStream().readAllBytes()));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    @Test
    public void testDownloadWebPageContent(){
        try {
            FileCopyUtils.copy(webContent.getInputStream(), Files.newOutputStream(path));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

}
