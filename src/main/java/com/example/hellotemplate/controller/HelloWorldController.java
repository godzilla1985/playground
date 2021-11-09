package com.example.hellotemplate.controller;

import com.example.hellotemplate.dto.RequestDto;
import com.example.hellotemplate.model.HelloWorld;
import com.example.hellotemplate.service.HelloWorldInterface;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("api")
@RequiredArgsConstructor
public class HelloWorldController {

    private final HelloWorldInterface helloWorldInterface;

    @GetMapping("greeting")
    public HelloWorld greeting() {
        return helloWorldInterface.getInstance();
    }

    @PostMapping("handling")
    public String postFormatDataHandling(@ModelAttribute RequestDto object){
        return object.toString();
    }

}
