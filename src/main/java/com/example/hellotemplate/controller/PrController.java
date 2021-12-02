package com.example.hellotemplate.controller;

import com.example.hellotemplate.dto.PullRequestDto;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("api")
@Slf4j
@RequiredArgsConstructor
public class PrController {


    @PostMapping("pull-request-processing")
    @ResponseStatus(value = HttpStatus.OK)
    public String process_pr(@RequestBody PullRequestDto pullRequest) {
        return pullRequest.toString();
    }

}
