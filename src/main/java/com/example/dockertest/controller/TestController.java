package com.example.dockertest.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TestController {

    @GetMapping
    public String test() {
        return "test0114 테스트333333_new_new";
    }
}
