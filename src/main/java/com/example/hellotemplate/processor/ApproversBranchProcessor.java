package com.example.hellotemplate.processor;

import com.example.hellotemplate.dto.ParticipantDto;
import com.example.hellotemplate.provider.ApprovementStatusProvider;
import com.example.hellotemplate.provider.ApproversBranchProvider;
import com.example.hellotemplate.provider.ValidationProvider;
import lombok.Getter;

import java.util.List;


@Getter
public class ApproversBranchProcessor extends ValidationProcessor {

    public ApproversBranchProcessor(ValidationProcessor nextProcessor) {
        super(nextProcessor);
    }

    @Override
    public boolean isValidated(ValidationProvider provider) {
        if (provider instanceof ApproversBranchProvider) {
            String branchDistination = ((ApproversBranchProvider) provider).getToBranch();
            List<ParticipantDto> approvers = ((ApproversBranchProvider) provider).getParticipants();
            boolean isMatch = isMatchForBranch(branchDistination, approvers);
            if (isMatch) {
                ApprovementStatusProvider approvementStatusProvider = new ApprovementStatusProvider(approvers);
                return getNextProcessor().isValidated(approvementStatusProvider);
            }
            return false;
        }
        return false;
    }

    private boolean isMatchForBranch(String toBranch, List<ParticipantDto> participants) {
        if (toBranch.equalsIgnoreCase("master")) {
            return participants.size() == 2;
        }
        return participants.size() == 1;
    }

}
