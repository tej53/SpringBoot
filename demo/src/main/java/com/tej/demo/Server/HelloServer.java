package com.tej.demo.Server;

import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloServer {
    @GetMapping("/hello")
    public String hello(){
        return "Hello Tej";
    }
}