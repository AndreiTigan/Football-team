package com.example.demo.handler;

public class PlayerNotFoundException extends RuntimeException {

    public PlayerNotFoundException(String s) {
        super(s);
    }
}
