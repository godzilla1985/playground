package com.example.hellotemplate.provider;

import com.example.hellotemplate.dto.ParticipantDto;
import lombok.AllArgsConstructor;
import lombok.Getter;

import java.util.List;

@Getter
@AllArgsConstructor
public class ApproversDescriptionProvider implements ValidationProvider {

    private String toBranch;
    private String description;
    private List<ParticipantDto> participants;


}
