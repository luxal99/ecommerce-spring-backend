package com.se211.ecommerce.exception;

public class MaximumCharacterException extends Exception {

    private String message;

    @Override
    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public MaximumCharacterException() {
    }

    public MaximumCharacterException(String s) {

        super(s);
    }
}
