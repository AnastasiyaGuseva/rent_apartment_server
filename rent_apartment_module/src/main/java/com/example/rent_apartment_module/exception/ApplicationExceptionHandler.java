package com.example.rent_apartment_module.exception;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class ApplicationExceptionHandler {

    @ExceptionHandler(UserAuthException.class)
    public ResponseEntity<?> catchException(UserAuthException e) {
        return ResponseEntity.status(e.getErrorCode()).body(e.getMessage());
    }

}
