package com.sts.services.survey.exception;

public class AuthenticationException extends RuntimeException{

    public AuthenticationException(String message, Throwable e){
        super(message, e);
    }
}
