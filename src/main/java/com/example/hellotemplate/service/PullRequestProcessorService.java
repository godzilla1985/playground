package com.example.hellotemplate.service;

import com.example.hellotemplate.processor.ValidationProcessor;
import com.example.hellotemplate.provider.PolicyProvider;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

@Service
public class PullRequestProcessorService implements PullRequestProcessor {

    private final ValidationProcessor validationProcessor;

    public PullRequestProcessorService(@Qualifier("policy") ValidationProcessor validationProcessor) {
        this.validationProcessor = validationProcessor;
    }


    @Override
    public Boolean processPullrequest(PolicyProvider policyProvider) {
        return validationProcessor.isValidated(policyProvider);
    }
}
