package com.example.hellotemplate.controller;

import com.example.hellotemplate.model.HelloWorld;
import com.example.hellotemplate.service.HelloWorldInterface;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("api")
@RequiredArgsConstructor
public class HelloWorldController {

    private final HelloWorldInterface helloWorldInterface;

    @GetMapping("greeting")
    public HelloWorld greeting() {
        return helloWorldInterface.getInstance();
    }

}
