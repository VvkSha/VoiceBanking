package com.finbank.voicebankservice.controller;

import com.finbank.voicebankservice.dto.UserDetailsDTO;
import com.finbank.voicebankservice.service.AuthService;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
//@Log4j2
@RequestMapping("api/v1/auth")
public class AuthController {

    @Autowired
    private AuthService authService;
    @GetMapping(value = "/validateUser", produces = "application/json")
    public ResponseEntity<UserDetailsDTO> validateUser(@RequestParam Long accountNumber, @RequestParam String password){
        //log.info("validating user:: "+ accountNumber + " "+password);
        System.out.println("validating user:: "+ accountNumber + " "+password);
        UserDetailsDTO userDetailsDTO = authService.validateUser(accountNumber,password);
        if(userDetailsDTO!=null){
            return ResponseEntity.ok(userDetailsDTO);
        }

        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }
}
