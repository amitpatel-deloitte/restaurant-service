package com.hashedin.restaurant_service.exceptionHandler;

public class AlreadyExistsException extends RuntimeException{
    public AlreadyExistsException(String message){
        super(message);
    }
}
