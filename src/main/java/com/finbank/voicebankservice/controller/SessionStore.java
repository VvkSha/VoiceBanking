package com.finbank.voicebankservice.controller;

import org.springframework.stereotype.Component;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

@Component
public class SessionStore {
    private final Map<String, String> sessions = new ConcurrentHashMap<>();

    public void createSession(String sessionId, String username) {
        sessions.put(sessionId, username);
    }

    public boolean isValid(String sessionId) {
        return sessions.containsKey(sessionId);
    }

    public String getUsername(String sessionId) {
        return sessions.get(sessionId);
    }
}

