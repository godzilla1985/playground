package com.example.hellotemplate.model;


import com.example.hellotemplate.factory.YamlPropertySourceFactory;
import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.context.annotation.PropertySources;

import java.util.List;
import java.util.Map;


@Configuration
@PropertySources({@PropertySource(value = "classpath:application-policy.yaml", factory = YamlPropertySourceFactory.class)})
@ConfigurationProperties(prefix = "mail")
@Data
public class ConfigurationMailProperties {

    private String hostName;
    private int port;
    private String from;
    private List<Credentials> credentials;
    private Map<String, Credentials> values;
}
