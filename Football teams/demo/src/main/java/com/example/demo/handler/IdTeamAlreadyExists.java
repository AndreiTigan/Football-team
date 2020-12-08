package com.example.demo.handler;

public class IdTeamAlreadyExists extends RuntimeException {
    public IdTeamAlreadyExists(String message) {
        super(message);
    }
}
