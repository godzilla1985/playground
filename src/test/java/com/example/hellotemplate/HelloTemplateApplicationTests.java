package com.example.hellotemplate;

import com.example.hellotemplate.controller.HelloWorldController;
import com.example.hellotemplate.dto.RequestDto;
import com.example.hellotemplate.service.HelloWorldInterface;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.extern.slf4j.Slf4j;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.message.BasicNameValuePair;
import org.apache.http.util.EntityUtils;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.mock.web.MockHttpServletResponse;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.web.servlet.MockMvc;

import java.util.Arrays;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@ExtendWith(SpringExtension.class)
@WebMvcTest(HelloWorldController.class)
@Slf4j
class HelloTemplateApplicationTests {

    @Autowired
    private MockMvc mockMvc;

    @Autowired
    private ObjectMapper objectMapper;

    @MockBean
    private HelloWorldInterface helloWorldInterface;


    @Test
    @DisplayName(value = "http:localhost:8080/api/handling end point testing on succesfully handling the request")
    void postFormatDataHandlingMethodTest() throws Exception {
        RequestDto expectedValue = new RequestDto("test", "hello");
        MockHttpServletResponse result = mockMvc.perform(post("/api/handling")
                        .contentType(MediaType.APPLICATION_FORM_URLENCODED_VALUE)
                        .content(EntityUtils.toString(new UrlEncodedFormEntity(Arrays.asList(
                                new BasicNameValuePair("name", "test"),
                                new BasicNameValuePair("message", "hello"))))))
                .andExpect(status().isOk())
                .andReturn().getResponse();
        log.info("This is result payload value {}", result.getContentAsString());
        Assertions.assertEquals(expectedValue.toString(), result.getContentAsString());
    }

}
