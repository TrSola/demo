package com.example.demo.exception;

public class AccountDisableException extends RuntimeException {
    public AccountDisableException(String message) {
        super(message);
    }
}