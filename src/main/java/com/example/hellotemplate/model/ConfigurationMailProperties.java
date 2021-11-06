package com.example.hellotemplate.model;


import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;

import java.util.List;
import java.util.Map;

@Configuration
@ConfigurationProperties(prefix = "mail")
@Data
public class ConfigurationMailProperties {

    private String hostName;
    private int port;
    private String from;
    private List<Credentials> credentials;
    private Map<String,Credentials> values;
}
