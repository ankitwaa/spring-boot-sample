package com.example.demo.exception;

public class ServiceException extends Exception {

    private String message;

    public ServiceException(String message, Throwable exception){
        super(exception);
        this.message = message;
    }
}
