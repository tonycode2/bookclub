package com.portfolio.bookclub.bookclub.service.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.NOT_FOUND)
public class ClubNotFoundException extends ApiException {

    public ClubNotFoundException(Long id){
        super("Club not located with the id " + id, "CLUB_NOT_LOCATED");
    }
}
