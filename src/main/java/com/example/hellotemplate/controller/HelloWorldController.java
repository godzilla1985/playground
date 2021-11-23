package com.example.hellotemplate.controller;

import com.example.hellotemplate.config.TestBean;
import com.example.hellotemplate.model.ConfigurationMailProperties;
import com.example.hellotemplate.model.HelloWorld;
import com.example.hellotemplate.service.HelloWorldInterface;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("api")
@RequiredArgsConstructor
@Slf4j
public class HelloWorldController {

    private final HelloWorldInterface helloWorldInterface;

    private final ConfigurationMailProperties configurationMailProperties;

    private final TestBean testBean;

    @GetMapping("greeting")
    public HelloWorld greeting() {
        return helloWorldInterface.getInstance();
    }

    @GetMapping("simpleproperties")
    public ConfigurationMailProperties getProperties() {
        log.info("This is the content of the injected bean :"+testBean);
        ConfigurationMailProperties response = new ConfigurationMailProperties();
        response.setFrom(configurationMailProperties.getFrom());
        response.setPort(configurationMailProperties.getPort());
        response.setHostName(configurationMailProperties.getHostName());
        response.setCredentials(configurationMailProperties.getCredentials());
        response.setValues(configurationMailProperties.getValues());
        return response;
    }

}
