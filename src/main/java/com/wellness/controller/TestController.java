package com.wellness.controller;

import org.springframework.http.HttpEntity;
import org.springframework.security.core.context.SecurityContext;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TestController {

    @GetMapping("/test")
    HttpEntity<String> testApp() {
        SecurityContext securityContext = SecurityContextHolder.getContext();
        System.out.println("Principal " + securityContext.getAuthentication().getPrincipal());
        System.out.println("Authorities " + securityContext.getAuthentication().getAuthorities());
        return new HttpEntity<>("hi there");
    }

    @GetMapping("/login")
    HttpEntity<String> testLogin() {
        return new HttpEntity<>("I'm logged in");
    }

    @GetMapping("/login/customer")
    HttpEntity<String> testCustomer() {
        return new HttpEntity<>("I am a customer");
    }

    @GetMapping("/login/admin")
    HttpEntity<String> testAdmin() {
        return new HttpEntity<>("I am an admin");
    }

    @GetMapping("/login/trainer")
    HttpEntity<String> testTrainer() {
        return new HttpEntity<>("I am a trainer");
    }
}
