package com.example.hellotemplate.processor;

import com.example.hellotemplate.dto.ParticipantDto;
import com.example.hellotemplate.provider.ApprovementStatusProvider;
import com.example.hellotemplate.provider.ApproversBranchProvider;
import com.example.hellotemplate.provider.ValidationProvider;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

import java.util.List;


@Component("branch")
@Slf4j
public class ApproverBranchProcessor implements ValidationProcessor {

    @Autowired
    @Qualifier("status")
    private ValidationProcessor nextProcessor;

    @Override
    public boolean isValidated(ValidationProvider provider) {

        log.info("In {} into the method {}", this.getClass().getName(), "isValidated");
        if (provider instanceof ApproversBranchProvider) {
            String branchDistination = ((ApproversBranchProvider) provider).getToBranch();
            List<ParticipantDto> approvers = ((ApproversBranchProvider) provider).getParticipants();
            String toBranch = ((ApproversBranchProvider) provider).getToBranch();
            boolean isMatch = isMatchForBranch(branchDistination, approvers);
            if (isMatch) {
                ApprovementStatusProvider approvementStatusProvider = new ApprovementStatusProvider(approvers,toBranch);
                return nextProcessor.isValidated(approvementStatusProvider);
            }
            return false;
        }
        return false;
    }

    private boolean isMatchForBranch(String toBranch, List<ParticipantDto> participants) {
        if (toBranch.equalsIgnoreCase("master")) {
            return participants.size() >= 2;
        }
        return participants.size() >= 1;
    }

}
