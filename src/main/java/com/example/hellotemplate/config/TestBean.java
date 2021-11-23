package com.example.hellotemplate.config;

import com.example.hellotemplate.model.ConfigurationMailProperties;
import lombok.Data;

import java.util.Map;

@Data
public class TestBean {

    private Map<String, ConfigurationMailProperties> map;

}
