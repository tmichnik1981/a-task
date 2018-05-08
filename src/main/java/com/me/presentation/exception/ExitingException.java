package com.me.presentation.exception;

public class ExitingException extends RuntimeException {
    public ExitingException(String exiting) {
        super(exiting);
    }
}
