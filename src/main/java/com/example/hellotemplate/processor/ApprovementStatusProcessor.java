package com.example.hellotemplate.processor;

import com.example.hellotemplate.dto.ParticipantDto;
import com.example.hellotemplate.provider.ApprovementStatusProvider;
import com.example.hellotemplate.provider.ValidationProvider;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;


@Component("status")
@Slf4j
public class ApprovementStatusProcessor implements ValidationProcessor {

    @Override
    public boolean isValidated(ValidationProvider provider) {
        log.info("In {} into the method {}", this.getClass().getName(), "isValidated");
        if (provider instanceof ApprovementStatusProvider) {
            List<ParticipantDto> approvers = ((ApprovementStatusProvider) provider).getParticipants();
            String toBranch = ((ApprovementStatusProvider) provider).getToBranch();
            List<ParticipantDto> approvedList = approvers.stream()
                    .filter(ParticipantDto::isApproved)
                    .collect(Collectors.toList());
            Integer minimalApprovers = getMinimalApprovers(toBranch);
            return approvedList.size() == minimalApprovers;
        }
        return false;
    }

    private Integer getMinimalApprovers(String toBranch){
        if(toBranch.equalsIgnoreCase("master")){
            return 2;
        }
        return 1;
    }
}
