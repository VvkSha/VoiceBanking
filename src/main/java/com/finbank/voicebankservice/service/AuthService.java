package com.finbank.voicebankservice.service;


import com.finbank.voicebankservice.dto.UserDetailsDTO;
import org.springframework.stereotype.Service;

@Service
public class AuthService {

    public UserDetailsDTO validateUser(Long accountNumber, String password){
            // Temporary fake validation logic
        if (accountNumber.equals(12345L) && password.equals("password")) {
            return UserDetailsDTO.builder()
                    .accountNumber(accountNumber)
                    .name("Vivek Sharma")
                    .valid(true)
                    .build();
        } else {
            return UserDetailsDTO.builder()
                    .accountNumber(accountNumber)
                    .name("Vivek Sharma")
                    .valid(false)
                    .build();
        }
    }
}
