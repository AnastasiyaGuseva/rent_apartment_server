package com.example.sales_apartment_module.exception;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class ApplicationExceptionHandler {
    @ExceptionHandler(IncorrectTokenException.class)
    public ResponseEntity<?> catchException(IncorrectTokenException e) {
        return ResponseEntity.status(e.getErrorCode()).body(e.getMessage());
    }

}
