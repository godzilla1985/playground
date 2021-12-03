package com.example.hellotemplate.processor;

import com.example.hellotemplate.provider.ApproversBranchProvider;
import com.example.hellotemplate.provider.ApproversDescriptionProvider;
import com.example.hellotemplate.provider.ValidationProvider;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;


@Component("description")
@Slf4j
public class ApproverDescriptionProcessor implements ValidationProcessor {

    @Autowired
    @Qualifier("branch")
    private ValidationProcessor nextProcessor;


    @Override
    public boolean isValidated(ValidationProvider provider) {
        log.info("In {} into the method {}", this.getClass().getName(), "isValidated");
        if (provider instanceof ApproversDescriptionProvider) {
            ApproversDescriptionProvider approversProvider = (ApproversDescriptionProvider) provider;
            if (isHaveRolesYaml(approversProvider)) {
                ApproversBranchProvider approversBranchProvider =
                        new ApproversBranchProvider(approversProvider.getToBranch(), approversProvider.getParticipants());
                return nextProcessor.isValidated(approversBranchProvider);
            }
        }
        return true;
    }

    private boolean isHaveRolesYaml(ApproversDescriptionProvider provider) {
        return provider.getDescription().contains("roles.yaml");
    }
}
