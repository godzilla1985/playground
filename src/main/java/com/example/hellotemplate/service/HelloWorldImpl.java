package com.example.hellotemplate.service;

import com.example.hellotemplate.model.HelloWorld;
import org.springframework.stereotype.Service;

@Service
public class HelloWorldImpl implements HelloWorldInterface {

    @Override
    public HelloWorld getInstance() {
        return new HelloWorld();
    }
}
