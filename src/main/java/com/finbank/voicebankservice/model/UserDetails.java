package com.finbank.voicebankservice.model;


import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import lombok.Builder;
import lombok.Data;

@Entity
@Data
@Builder
public class UserDetails {

    @Id
    @GeneratedValue
    private int id;
    private Long accountNumber;
    private String password;
    private String name;
}
