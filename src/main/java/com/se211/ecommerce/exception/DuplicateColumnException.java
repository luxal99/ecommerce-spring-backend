package com.se211.ecommerce.exception;

public class DuplicateColumnException extends Exception {

    private String message;

    public DuplicateColumnException() {
        this.message = "Username already in use";
    }

    public DuplicateColumnException(String s) {
        super(s);
    }

    @Override
    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

}
