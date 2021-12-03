package com.example.hellotemplate.controller;

import com.example.hellotemplate.dto.PullRequestDto;
import com.example.hellotemplate.provider.PolicyProvider;
import com.example.hellotemplate.service.PullRequestProcessor;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("api")
@Slf4j
@RequiredArgsConstructor
public class PrController {

    private final PullRequestProcessor pullRequestProcessor;


    @PostMapping("pull-request-processing")
    @ResponseStatus(value = HttpStatus.OK)
    public String process_pr(@RequestBody PullRequestDto pullRequest) {
        PolicyProvider policyProvider = new PolicyProvider(pullRequest);
        boolean result = pullRequestProcessor.processPullrequest(policyProvider);
        return "This is result of the Pull request : "+result;
    }

}
