package com.switchfullyselfevaluation.eurder.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.FORBIDDEN)
public class NotACustomerException extends RuntimeException{
    public NotACustomerException(String message) {
        super(message);
    }
}
