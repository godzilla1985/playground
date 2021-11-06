package com.example.hellotemplate.controller;

import com.example.hellotemplate.model.ConfigurationMailProperties;
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

    private final ConfigurationMailProperties configurationMailProperties;

    @GetMapping("greeting")
    public HelloWorld greeting() {
        return helloWorldInterface.getInstance();
    }

    @GetMapping("simpleproperties")
    public ConfigurationMailProperties getProperties() {
        ConfigurationMailProperties response = new ConfigurationMailProperties();
        response.setFrom(configurationMailProperties.getFrom());
        response.setPort(configurationMailProperties.getPort());
        response.setHostName(configurationMailProperties.getHostName());
        response.setCredentials(configurationMailProperties.getCredentials());
        response.setValues(configurationMailProperties.getValues());
        return response;
    }

}
