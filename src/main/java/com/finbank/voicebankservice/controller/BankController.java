package com.finbank.voicebankservice.controller;


import com.finbank.voicebankservice.service.BankService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/api/v1/bank")
public class BankController {

    @Autowired
    private BankService bankService;
    @Autowired
    private SessionStore sessionStore;

    @PostMapping("/credit")
    public ResponseEntity<String> credit(@RequestParam String accountNumber, @RequestParam Double amount){
        String creditDtls = bankService.credit(accountNumber,amount);

        return ResponseEntity.ok(creditDtls);
    }

    @PostMapping("/transfer")
    public ResponseEntity<Map<String, Object>> transfer(@RequestParam String fromAccount,
                                           @RequestParam String toAccount,
                                           @RequestParam Double amount){
        System.out.println("get withDraw:: "+fromAccount+" : "+toAccount+" : "+amount);
        String transferMessage = bankService.transfer(fromAccount,toAccount,amount);
        Map<String, Object> response = new HashMap<>();
        response.put("status", "success");
        response.put("message", transferMessage);
        response.put("fromAccount", fromAccount);
        response.put("toAccount", toAccount);
        response.put("amount", amount);
        return ResponseEntity.ok(response);
    }

    @GetMapping("/getStatement")
    public ResponseEntity<List<String>> getStatement(@RequestParam String accountNumber){
        System.out.println("get statement:: "+accountNumber+" "+sessionStore);
        List<String> statements = bankService.statement(accountNumber);

        return ResponseEntity.ok(statements);
    }

}
