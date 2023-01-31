package com.example.springbootday7.Exception;

public class ApiException extends RuntimeException {
    public ApiException(String message){
        super(message);
    }
}
