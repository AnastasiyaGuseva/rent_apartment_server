package com.example.sales_apartment_module.exception;

import lombok.Getter;

@Getter
public class IncorrectTokenException extends RuntimeException {

    private int errorCode;

    public IncorrectTokenException(String message, int errorCode) {
        super(message);
        this.errorCode = errorCode;
    }
}
