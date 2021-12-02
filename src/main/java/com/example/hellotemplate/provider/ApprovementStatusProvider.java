package com.example.hellotemplate.provider;

import com.example.hellotemplate.dto.ParticipantDto;
import lombok.AllArgsConstructor;
import lombok.Getter;

import java.util.List;

@Getter
@AllArgsConstructor
public class ApprovementStatusProvider implements ValidationProvider {

    private List<ParticipantDto> participants;

}
