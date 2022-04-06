package com.cabbookingapplication.controller;

import com.cabbookingapplication.models.Error;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class CabSystemErrorHandler {

    @ExceptionHandler(value=IllegalArgumentException.class)
    public ResponseEntity<Error> handleIllegalArgumentException(IllegalArgumentException exception) {
        Error error = createErrorResponse(exception.getMessage(), HttpStatus.BAD_REQUEST);
        return new ResponseEntity<>(error, HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(value=NullPointerException.class)
    public ResponseEntity<Error> handleIllegalArgumentException(NullPointerException exception) {
        Error error = createErrorResponse(exception.getMessage(), HttpStatus.NOT_FOUND);
        return new ResponseEntity<>(error, HttpStatus.NOT_FOUND);
    }

    private Error createErrorResponse(String message, HttpStatus httpStatus) {
        return new Error(message, httpStatus.value());
    }
}
