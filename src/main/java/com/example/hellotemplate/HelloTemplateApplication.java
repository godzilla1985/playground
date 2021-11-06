package com.example.hellotemplate;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.ConfigurationPropertiesScan;
import org.springframework.boot.context.properties.EnableConfigurationProperties;

@SpringBootApplication
/*@ConfigurationPropertiesScan("com.example.hellotemplate.model")*/
public class HelloTemplateApplication {

    public static void main(String[] args) {
        SpringApplication.run(HelloTemplateApplication.class, args);
    }

}
