package com.example.rent_apartment_module.exception;

import lombok.Getter;

@Getter
public class IncorrectLoginException extends RuntimeException {

    private int errorCode;

    public IncorrectLoginException(String message, int errorCode) {
        super(message);
        this.errorCode = errorCode;
    }
}
