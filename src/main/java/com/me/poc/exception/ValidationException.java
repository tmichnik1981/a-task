package com.me.poc.exception;

public class ValidationException extends RuntimeException  {

    public ValidationException(String message) {
        super(message);
    }
}
