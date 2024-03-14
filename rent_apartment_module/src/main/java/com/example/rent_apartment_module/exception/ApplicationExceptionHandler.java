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

    @ExceptionHandler(RestTemplateException.class)
    public ResponseEntity<?> catchException(RestTemplateException e) {
        return ResponseEntity.status(e.getErrorCode()).body(e.getMessage());
    }

    @ExceptionHandler(IncorrectLoginException.class)
    public ResponseEntity<?> catchException(IncorrectLoginException e) {
        return ResponseEntity.status(e.getErrorCode()).body(e.getMessage());
    }

    @ExceptionHandler(UserUnauthorisedException.class)
    public ResponseEntity<?> catchException(UserUnauthorisedException e) {
        return ResponseEntity.status(e.getErrorCode()).body(e.getMessage());
    }

    @ExceptionHandler(IncorrectPasswordException.class)
    public ResponseEntity<?> catchException(IncorrectPasswordException e) {
        return ResponseEntity.status(e.getErrorCode()).body(e.getMessage());
    }

    @ExceptionHandler(OverdueTokenException.class)
    public ResponseEntity<?> catchException(OverdueTokenException e) {
        return ResponseEntity.status(e.getErrorCode()).body(e.getMessage());
    }

}
