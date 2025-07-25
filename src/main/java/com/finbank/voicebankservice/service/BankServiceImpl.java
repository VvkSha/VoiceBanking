package com.finbank.voicebankservice.service;

import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;


@Service
public class BankServiceImpl implements BankService {
    @Override
    public String credit(String accountNumber, Double amount) {
        return null;
    }

    @Override
    public String transfer(String fromAccount, String toAccount, Double amount) {
        System.out.println("Transferring ₹" + amount + " from " + fromAccount + " to " + toAccount);

        return "Successfully transferred ₹" + amount + " from " + fromAccount + " to " + toAccount;
    }

    @Override
    public List<String> statement(String accountNumber) {
        List<String> res = new ArrayList<>();
        res.add("Bank account have 100 rs.");
        return res;
    }
}
