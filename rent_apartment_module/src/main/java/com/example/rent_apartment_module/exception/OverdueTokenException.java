package com.example.rent_apartment_module.exception;

import lombok.Getter;

@Getter
public class OverdueTokenException extends RuntimeException {

    private int errorCode;

    public OverdueTokenException(String message, int errorCode) {
        super(message);
        this.errorCode = errorCode;
    }
}
