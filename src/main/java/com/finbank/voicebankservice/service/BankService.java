package com.finbank.voicebankservice.service;

import java.util.List;

public interface BankService {

    public String credit(String accountNumber, Double amount);
    public String transfer(String fromAccount, String toAccount, Double amount);
    public List<String> statement(String accountNumber);
}
