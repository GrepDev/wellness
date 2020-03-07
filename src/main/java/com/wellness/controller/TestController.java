package com.wellness.controller;

import org.springframework.http.HttpEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TestController {

    @GetMapping("/test")
    HttpEntity<String> testApp() {
        return new HttpEntity<>("hi there");
    }
}
