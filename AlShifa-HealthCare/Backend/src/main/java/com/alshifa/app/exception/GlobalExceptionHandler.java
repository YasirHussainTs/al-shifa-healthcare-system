package com.alshifa.app.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;

import java.time.LocalDateTime;

@ControllerAdvice
public class GlobalExceptionHandler {
    @ExceptionHandler(AlshifaAPIException.class)
    public ResponseEntity<ErrorDetails> handleAlshifaAPIException(AlshifaAPIException exception, WebRequest WebRequest) {
        ErrorDetails errorDetails = new ErrorDetails(
                LocalDateTime.now(),
                exception.getMessage(),
                WebRequest.getDescription(false)
        );

    return new ResponseEntity<>(errorDetails, HttpStatus.BAD_REQUEST);
    }
}
