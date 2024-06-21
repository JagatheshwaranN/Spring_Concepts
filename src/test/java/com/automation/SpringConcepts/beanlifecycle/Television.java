package com.automation.SpringConcepts.beanlifecycle;

import jakarta.annotation.PostConstruct;
import jakarta.annotation.PreDestroy;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
public class Television {

    @Value("${tv.name:LG}")
    private String tvName;

    public Television(){
        System.out.println("Inside the Constructor : "+ this.tvName);

    }

    @PostConstruct
    public void setup() {
         System.out.println("Inside the Initialize Method : "+ this.tvName);
         System.out.println("TV is turned ON");
    }

    public void playChannel(){
        for(int i = 0; i < 5; i++){
            System.out.println("Watching Channel " + i);
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
    }

    @PreDestroy
    public void tearDown() {
         System.out.println("TV is turned OFF");
    }

}
