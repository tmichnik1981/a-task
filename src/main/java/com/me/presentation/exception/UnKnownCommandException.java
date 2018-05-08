package com.me.presentation.exception;

public class UnKnownCommandException  extends RuntimeException  {

    public UnKnownCommandException(String message) {
        super(message);
    }
}
