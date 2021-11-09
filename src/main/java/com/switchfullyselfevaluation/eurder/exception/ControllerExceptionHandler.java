package com.switchfullyselfevaluation.eurder.exception;

import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

import static org.springframework.http.HttpStatus.FORBIDDEN;

@ControllerAdvice
public class ControllerExceptionHandler extends ResponseEntityExceptionHandler {

    @ExceptionHandler(InvalidUserException.class)
    protected void invalidUserException(InvalidUserException ex, HttpServletResponse response) throws IOException {
        response.sendError(FORBIDDEN.value(), ex.getMessage());
    }

    @ExceptionHandler(NoAuthorizationException.class)
    protected void noAuthorizationException(NoAuthorizationException ex, HttpServletResponse response) throws IOException {
        response.sendError(FORBIDDEN.value(), ex.getMessage());
    }

    @ExceptionHandler(InvalidItemException.class)
    protected void notACustomerException(InvalidItemException ex, HttpServletResponse response) throws IOException {
        response.sendError(FORBIDDEN.value(), ex.getMessage());
    }
}

