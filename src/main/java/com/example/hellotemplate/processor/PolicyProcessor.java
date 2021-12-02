package com.example.hellotemplate.processor;

import com.example.hellotemplate.dto.ParticipantDto;
import com.example.hellotemplate.dto.PullRequestDto;
import com.example.hellotemplate.provider.ApproversDescriptionProvider;
import com.example.hellotemplate.provider.ValidationProvider;
import lombok.Getter;

import java.util.List;


@Getter
public class PolicyProcessor extends ValidationProcessor {

    public PolicyProcessor(ValidationProcessor nextProcessor) {
        super(nextProcessor);
    }

    @Override
    public boolean isValidated(ValidationProvider provider) {
        if (provider instanceof PullRequestDto) {
            String projectKey = ((PullRequestDto) provider).getProjectKey();
            String repoName = ((PullRequestDto) provider).getRepoName();
            if (isMatchingForPolicy(projectKey, repoName)) {
                ApproversDescriptionProvider approversDescriptionProvider = (ApproversDescriptionProvider) getValidationProvider(provider);
                return getNextProcessor().isValidated(approversDescriptionProvider);
            }
        }
        return false;
    }

    private ValidationProvider getValidationProvider(ValidationProvider provider) {
        String toBranch = ((PullRequestDto) provider).getToBranch();
        String description = ((PullRequestDto) provider).getDescription();
        List<ParticipantDto> participants = ((PullRequestDto) provider).getApprovers();
        return new ApproversDescriptionProvider(toBranch, description, participants);
    }

    private boolean isMatchingForPolicy(String projectKey, String repoName) {
        return projectKey.equalsIgnoreCase("qwerty") && repoName.equalsIgnoreCase("enrich");
    }

}
