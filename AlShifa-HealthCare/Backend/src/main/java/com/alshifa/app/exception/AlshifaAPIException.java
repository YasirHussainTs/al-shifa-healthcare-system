package com.alshifa.app.exception;

import lombok.AllArgsConstructor;
import lombok.Getter;
import org.springframework.http.HttpStatus;

@Getter
@AllArgsConstructor
public class AlshifaAPIException extends Exception {
    private HttpStatus status;
    private String message;
}
