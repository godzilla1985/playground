package com.example.hellotemplate.config;

import com.example.hellotemplate.model.ConfigurationMailProperties;
import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.HashMap;
import java.util.Map;

@Configuration
@RequiredArgsConstructor
public class Cooking {

    private final ConfigurationMailProperties configurationMailProperties;

    @Bean
    TestBean testBean() {
        TestBean testBean = new TestBean();
        testBean.setMap(getMapOfObjects(configurationMailProperties));
        return testBean;
    }

    private Map<String, ConfigurationMailProperties> getMapOfObjects(ConfigurationMailProperties configurationMailProperties) {
        Map<String, ConfigurationMailProperties> result = new HashMap<>();
        result.put("KeyValue", configurationMailProperties);
        return result;
    }

}
