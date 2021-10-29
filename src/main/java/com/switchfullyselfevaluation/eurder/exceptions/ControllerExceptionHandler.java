package com.switchfullyselfevaluation.eurder.exceptions;

import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

import static org.springframework.http.HttpStatus.FORBIDDEN;

@ControllerAdvice
public class ControllerExceptionHandler extends ResponseEntityExceptionHandler {

    @ExceptionHandler(UserDoesNotExistException.class)
        protected void userDoesNotExistException(UserDoesNotExistException ex, HttpServletResponse response) throws IOException {
            response.sendError(FORBIDDEN.value(), ex.getMessage());
        }

    @ExceptionHandler(NoAuthorizationException.class)
    protected void noAuthorizationException(NoAuthorizationException ex, HttpServletResponse response) throws IOException {
        response.sendError(FORBIDDEN.value(), ex.getMessage());
    }

    @ExceptionHandler(NotACustomerException.class)
    protected void notACustomerException(NotACustomerException ex, HttpServletResponse response) throws IOException {
        response.sendError(FORBIDDEN.value(), ex.getMessage());
    }
}

