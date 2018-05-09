package com.me.poc.exception;

public class UnKnownCommandException  extends RuntimeException  {

    public UnKnownCommandException(String message) {
        super(message);
    }
}
