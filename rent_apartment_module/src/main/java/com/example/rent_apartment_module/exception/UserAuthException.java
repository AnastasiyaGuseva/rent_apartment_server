package com.example.rent_apartment_module.exception;

import lombok.Getter;

@Getter
public class UserAuthException extends RuntimeException {

    private int errorCode;

    public UserAuthException(String message, int errorCode) {
        super(message);
        this.errorCode = errorCode;
    }


}
