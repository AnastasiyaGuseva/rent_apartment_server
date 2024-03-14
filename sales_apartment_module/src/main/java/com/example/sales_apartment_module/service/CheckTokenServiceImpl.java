package com.example.sales_apartment_module.service;

import com.example.sales_apartment_module.exception.IncorrectTokenException;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import static com.example.sales_apartment_module.exception.ExceptionConstant.TOKEN_EXCEPTION;
import static com.example.sales_apartment_module.exception.ExceptionConstant.TOKEN_EXCEPTION_CODE;

@Service
public class CheckTokenServiceImpl implements CheckTokenService {

    @Value("${spring.service.key}")
    private String sourceToken;

    public void checkToken(String token) {

        if (!token.equals(sourceToken)) {
            throw new IncorrectTokenException(TOKEN_EXCEPTION, TOKEN_EXCEPTION_CODE);
        }
    }
}
