package com.example.demo.handler;

public class TeamNotFoundException extends RuntimeException{
    public TeamNotFoundException(String s) {
        super(s);
    }
}
