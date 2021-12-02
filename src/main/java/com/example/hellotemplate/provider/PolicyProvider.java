package com.example.hellotemplate.provider;

import com.example.hellotemplate.dto.PullRequestDto;
import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class PolicyProvider implements ValidationProvider {

    private PullRequestDto pullRequestDto;

}
