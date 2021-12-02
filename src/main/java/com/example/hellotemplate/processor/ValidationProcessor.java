package com.example.hellotemplate.processor;

import com.example.hellotemplate.provider.ValidationProvider;
import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public abstract class ValidationProcessor {

    private ValidationProcessor nextProcessor;

    public abstract boolean isValidated(ValidationProvider provider);

}
