package com.example.hellotemplate.processor;

import com.example.hellotemplate.dto.ParticipantDto;
import com.example.hellotemplate.provider.ApprovementStatusProvider;
import com.example.hellotemplate.provider.ValidationProvider;
import lombok.Getter;

import java.util.List;
import java.util.stream.Collectors;


@Getter
public class ApprovementsStatusProcessor extends ValidationProcessor {

    public ApprovementsStatusProcessor(ValidationProcessor nextProcessor) {
        super(nextProcessor);
    }

    @Override
    public boolean isValidated(ValidationProvider provider) {
        if (provider instanceof ApprovementStatusProvider) {
            List<ParticipantDto> approvers = ((ApprovementStatusProvider) provider).getParticipants();
            List<ParticipantDto> approvedList = approvers.stream()
                    .filter(ParticipantDto::isApproved)
                    .collect(Collectors.toList());
            return approvedList.size() == approvers.size();
        }
        return false;
    }
}
