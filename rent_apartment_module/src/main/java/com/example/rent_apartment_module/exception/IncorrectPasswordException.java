package com.example.rent_apartment_module.exception;

import lombok.Getter;

@Getter
public class IncorrectPasswordException extends RuntimeException {

    private int errorCode;

    public IncorrectPasswordException(String message, int errorCode) {
        super(message);
        this.errorCode = errorCode;
    }
}
