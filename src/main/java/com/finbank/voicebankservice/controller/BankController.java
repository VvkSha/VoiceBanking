package com.finbank.voicebankservice.controller;


import com.finbank.voicebankservice.service.BankService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/bank")
public class BankController {

    @Autowired
    private BankService bankService;

    @PostMapping("/credit")
    public ResponseEntity<String> credit(@RequestParam String accountNumber, @RequestParam Double amount){
        String creditDtls = bankService.credit(accountNumber,amount);

        return ResponseEntity.ok(creditDtls);
    }

    @PostMapping("/withDraw")
    public ResponseEntity<String> withDraw(@RequestParam String accountNumber, @RequestParam Double amount){
        System.out.println("get withDraw:: "+accountNumber);
        String withDrawDtls = bankService.transfer(accountNumber,amount);

        return ResponseEntity.ok(withDrawDtls);
    }

    @GetMapping("/getStatement")
    public ResponseEntity<List<String>> getStatement(@RequestParam String accountNumber){
        System.out.println("get statement:: "+accountNumber);
        List<String> statements = bankService.statement(accountNumber);

        return ResponseEntity.ok(statements);
    }

}
