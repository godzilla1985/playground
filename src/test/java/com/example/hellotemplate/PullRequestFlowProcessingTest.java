package com.example.hellotemplate;

import com.example.hellotemplate.dto.PullRequestDto;
import com.example.hellotemplate.provider.PolicyProvider;
import com.example.hellotemplate.service.PullRequestProcessorService;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;


@SpringBootTest
@Slf4j
public class PullRequestFlowProcessingTest {

    @Autowired
    private PullRequestProcessorService pullRequestProcessorService;


    @Test
    public void ValidationProcessorWithRolesYamlAndTwoApprovedParticipantsTest() {
        PullRequestDto pullRequestDto = TestUtil.getPullRequestDtoWithRolesYamlAndTwoApprovedParticipants();
        PolicyProvider policyProvider = new PolicyProvider(pullRequestDto);
        boolean actualResult = pullRequestProcessorService.processPullrequest(policyProvider);
        Assertions.assertTrue(actualResult);
    }

    @Test
    public void ValidationProcessorWithRolesYamlAndOneApprovedParticipantTest() {
        PullRequestDto pullRequestDto = TestUtil.getPullRequestDtoWithRolesYamlAndOneApprovedParticipant();
        PolicyProvider policyProvider = new PolicyProvider(pullRequestDto);
        boolean actualResult = pullRequestProcessorService.processPullrequest(policyProvider);
        Assertions.assertFalse(actualResult);
    }

    @Test
    public void ValidationProcessorWithRolesYamlAndOneApprovedParticipantAndBranchToDev() {
        PullRequestDto pullRequestDto = TestUtil.getPullRequestDtoWithRolesYamlAndOneApprovedParticipantAndBranchDev();
        log.info("Pull request dto object : "+pullRequestDto);
        PolicyProvider policyProvider = new PolicyProvider(pullRequestDto);
        boolean actualResult = pullRequestProcessorService.processPullrequest(policyProvider);
        Assertions.assertTrue(actualResult);
    }

}
