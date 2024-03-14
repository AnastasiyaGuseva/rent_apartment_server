package com.example.rent_apartment_module.exception;

import lombok.Getter;

@Getter
public class UserUnauthorisedException extends RuntimeException {

    private int errorCode;

    public UserUnauthorisedException(String message, int errorCode) {
        super(message);
        this.errorCode = errorCode;
    }
}
