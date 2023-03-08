package com.socialnetworkcasestudy.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.CONFLICT)
public class UserAlreadyExistException extends RuntimeException {
    private String message="User already exist";
    public UserAlreadyExistException(String message) {
        super(message);
    }
}
