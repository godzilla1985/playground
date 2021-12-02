package com.example.hellotemplate.processor;

import com.example.hellotemplate.provider.ApproversBranchProvider;
import com.example.hellotemplate.provider.ApproversDescriptionProvider;
import com.example.hellotemplate.provider.ValidationProvider;
import lombok.Getter;


@Getter
public class ApproversDescriptionProcessor extends ValidationProcessor {

    public ApproversDescriptionProcessor(ValidationProcessor nextProcessor) {
        super(nextProcessor);
    }


    @Override
    public boolean isValidated(ValidationProvider provider) {
        if (provider instanceof ApproversDescriptionProvider) {
            ApproversDescriptionProvider approversProvider = (ApproversDescriptionProvider) provider;
            if (isHaveRolesYaml(approversProvider)) {
                ApproversBranchProvider approversBranchProvider =
                        new ApproversBranchProvider(approversProvider.getToBranch(), approversProvider.getParticipants());
                return getNextProcessor().isValidated(approversBranchProvider);
            }
        }
        return true;
    }

    private boolean isHaveRolesYaml(ApproversDescriptionProvider provider) {
        return provider.getDescription().contains("roles.yaml");
    }
}
