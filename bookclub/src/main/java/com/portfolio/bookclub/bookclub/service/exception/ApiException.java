package com.portfolio.bookclub.bookclub.service.exception;

public abstract class ApiException extends RuntimeException{
    private final String code;

    public ApiException(String message, String code){
        super(message);
        this.code = code;
    } 
    public String getCode(){
        return code;
    }
}
