package com.wellness;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan(basePackages = "com.wellness.")
public class App {

    @Value("${test.property}")
    String testProp;

    public static void main(String[] args) {
        SpringApplication.run(App.class, args);
    }
}
