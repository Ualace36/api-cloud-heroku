package com.ualace36.apicloud.controller;


import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloController {
    @GetMapping("/{hello}")
    public String hello(){
        return "Hello Controller, estou  na área iuiu, pivete.";
    }
}
