package com.finbank.voicebankservice.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Collections;
import java.util.Map;
import java.util.UUID;

@RestController
@RequestMapping("/api/v1/auth")
public class AuthController {

    @Autowired
    private SessionStore sessionStore;

    @PostMapping(value = "/login",produces = "application/json")
    public ResponseEntity<?> login(@RequestBody Map<String, String> body) {
        System.out.println("body:: "+body);
        String username = body.get("username");
        String password = body.get("password");

        // Simple hardcoded check (replace with DB check)
        if ("vivek".equals(username) && "pass123".equals(password)) {
            String sessionId = UUID.randomUUID().toString();
            sessionStore.createSession(sessionId, username);
            return ResponseEntity.ok(Collections.singletonMap("sessionId", sessionId));
        }
        return ResponseEntity.status(401).body("Invalid credentials");
    }
}

