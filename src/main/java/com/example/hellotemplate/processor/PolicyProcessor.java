package com.example.hellotemplate.processor;

import com.example.hellotemplate.dto.ParticipantDto;
import com.example.hellotemplate.dto.PullRequestDto;
import com.example.hellotemplate.provider.ApproversDescriptionProvider;
import com.example.hellotemplate.provider.PolicyProvider;
import com.example.hellotemplate.provider.ValidationProvider;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

import java.util.List;

@Component("policy")
@Slf4j
public class PolicyProcessor implements ValidationProcessor {

    private final ValidationProcessor nextProcessor;

    public PolicyProcessor(@Qualifier("description") ValidationProcessor nextProcessor) {
        this.nextProcessor = nextProcessor;
    }

    @Override
    public boolean isValidated(ValidationProvider provider) {
        log.info("In {} into the method {}", this.getClass().getName(), "isValidated");
        if (provider instanceof PolicyProvider) {
            PolicyProvider policyProvider = (PolicyProvider) provider;
            String projectKey = policyProvider.getPullRequestDto().getProjectKey();
            String repoName = policyProvider.getPullRequestDto().getRepoName();
            if (isMatchingForPolicy(projectKey, repoName)) {
                ApproversDescriptionProvider approversDescriptionProvider = getValidationProvider(provider);
                return nextProcessor.isValidated(approversDescriptionProvider);
            }
        }
        return false;
    }

    private ApproversDescriptionProvider getValidationProvider(ValidationProvider provider) {
        PullRequestDto pullRequestDto = ((PolicyProvider) provider).getPullRequestDto();
        String toBranch =pullRequestDto.getToBranch();
        String description = pullRequestDto.getDescription();
        List<ParticipantDto> participants = pullRequestDto.getApprovers();
        return new ApproversDescriptionProvider(toBranch, description, participants);
    }

    private boolean isMatchingForPolicy(String projectKey, String repoName) {
        return projectKey.equalsIgnoreCase("qwerty") && repoName.equalsIgnoreCase("enrich");
    }

}
