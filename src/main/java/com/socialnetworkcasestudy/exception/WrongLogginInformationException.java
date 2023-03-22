package com.socialnetworkcasestudy.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.CONFLICT)
public class WrongLogginInformationException extends RuntimeException{
    public WrongLogginInformationException() {
    }

    public WrongLogginInformationException(String message) {
        super(message);
    }

    public WrongLogginInformationException(String message, Throwable cause) {
        super(message, cause);
    }

    public WrongLogginInformationException(Throwable cause) {
        super(cause);
    }

    public WrongLogginInformationException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
