package com.portfolio.bookclub.bookclub.service.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.NOT_FOUND)
public class UserNotFoundException extends ApiException{
        
    public UserNotFoundException(Integer id){
        super("User Not found with the Id " + id, "USER_NOT_FOUND");
    }

}
