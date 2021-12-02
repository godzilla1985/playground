package com.example.hellotemplate.dto;

import lombok.Data;

import java.util.List;

@Data
public class PullRequestDto {

    private String repoName;
    private String projectKey;
    private String action;
    private String fromBranch;
    private String toBranch;
    private List<ParticipantDto> approvers;
    private String description;
}
