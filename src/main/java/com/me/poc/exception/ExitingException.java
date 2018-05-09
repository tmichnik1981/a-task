package com.me.poc.exception;

public class ExitingException extends RuntimeException {
    public ExitingException(String exiting) {
        super(exiting);
    }
}
