package com.example.rent_apartment_module.exception;

import lombok.Getter;

@Getter
public class RestTemplateException extends RuntimeException {

    private int errorCode;

    public RestTemplateException(String message, int errorCode) {
        super(message);
        this.errorCode = errorCode;
    }
}
