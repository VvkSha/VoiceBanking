package com.finbank.voicebankservice.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

@RestController
@RequestMapping("/api/v1/bank")
public class MenuController {
    @GetMapping("/menu")
    public ResponseEntity<Map<String, String>> getBankMenu() {
        String menu = """
                Hi 👋 Welcome to VoiceBank!

                Please choose an option:
                1️⃣ View Statement
                2️⃣ Transfer Amount
                3️⃣ Credit Amount
                4️⃣ Withdraw Amount

                Type "Stop" anytime to exit.
                """;

        return ResponseEntity.ok(Map.of("message", menu));
    }
}
