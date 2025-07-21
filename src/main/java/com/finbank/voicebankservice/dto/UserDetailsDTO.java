package com.finbank.voicebankservice.dto;


import lombok.Builder;
import lombok.Data;


@Builder
@Data
public class UserDetailsDTO {

    private Long accountNumber;
    private String name;
    private boolean valid;

}
