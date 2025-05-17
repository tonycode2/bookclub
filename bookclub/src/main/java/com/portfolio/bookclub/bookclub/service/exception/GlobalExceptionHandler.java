package com.portfolio.bookclub.bookclub.service.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class GlobalExceptionHandler {
    
    @ExceptionHandler(UserNotFoundException.class)
    @ResponseStatus(HttpStatus.NOT_FOUND)
    public ApiError handleUserNotFound(UserNotFoundException ex){
        return new ApiError(ex.getMessage(), ex.getCode());
    }

    @ExceptionHandler(ClubNotFoundException.class)
    @ResponseStatus(HttpStatus.NOT_FOUND)
    public ApiError handleClubNotFound(ClubNotFoundException ex){
        return new ApiError(ex.getMessage(), ex.getCode());
    }
}
