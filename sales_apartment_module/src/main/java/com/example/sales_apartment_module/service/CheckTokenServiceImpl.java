package com.example.sales_apartment_module.service;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

@Service
public class CheckTokenServiceImpl implements CheckTokenService {

    @Value("${spring.service.key}")
    private String sourceToken;

    public void checkToken(String token) {

        if (!token.equals(sourceToken)) {
            throw new RuntimeException();
        }
    }
}
