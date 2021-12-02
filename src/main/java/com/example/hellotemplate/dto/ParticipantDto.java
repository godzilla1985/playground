package com.example.hellotemplate.dto;

import lombok.Data;

import java.io.Serializable;

@Data
public class ParticipantDto implements Serializable {

    private String user;
    private boolean approved;

}
