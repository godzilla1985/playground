package com.example.hellotemplate;

import com.example.hellotemplate.dto.ParticipantDto;
import com.example.hellotemplate.dto.PullRequestDto;

import java.util.Arrays;
import java.util.List;

public class TestUtil {

    static PullRequestDto getPullRequestDtoWithRolesYamlAndTwoApprovedParticipants(){
        PullRequestDto pullRequestDto = new PullRequestDto();
        pullRequestDto.setRepoName("enrich");
        pullRequestDto.setProjectKey("QWERTY");
        pullRequestDto.setAction("open-pull-request");
        pullRequestDto.setFromBranch("dev");
        pullRequestDto.setToBranch("master");
        pullRequestDto.setDescription("Changed the file roles.yaml");
        List<ParticipantDto> participants = getListOfParticipants();
        pullRequestDto.setApprovers(participants);
        return pullRequestDto;
    }

    static PullRequestDto getPullRequestDtoWithRolesYamlAndOneApprovedParticipant(){
        PullRequestDto pullRequestDto = getPullRequestDtoWithRolesYamlAndTwoApprovedParticipants();
        List<ParticipantDto> list = pullRequestDto.getApprovers();
        ParticipantDto participantDto = list.get(0);
        participantDto.setApproved(false);
        list.set(0,participantDto);
        return pullRequestDto;
    }

    static PullRequestDto getPullRequestDtoWithRolesYamlAndOneApprovedParticipantAndBranchDev(){
        PullRequestDto pullRequestDto = getPullRequestDtoWithRolesYamlAndOneApprovedParticipant();
        pullRequestDto.setToBranch("dev");
        return pullRequestDto;
    }

    static List<ParticipantDto> getListOfParticipants(){
        ParticipantDto participantDtoFirst = new ParticipantDto();
        participantDtoFirst.setUser("Eli");
        participantDtoFirst.setApproved(true);
        ParticipantDto participantDtoSecond = new ParticipantDto();
        participantDtoSecond.setUser("Maya");
        participantDtoSecond.setApproved(true);
        return Arrays.asList(participantDtoFirst,participantDtoSecond);
    }

}
