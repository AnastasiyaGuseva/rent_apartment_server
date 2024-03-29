package com.example.rent_apartment_module.logger;

import com.example.rent_apartment_module.model.entity.UserRentEntityRent;
import com.example.rent_apartment_module.repository.UserRentRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class FunctionByLogger {

    private final UserRentRepository userRepository;

    public String getUserLogin(String token) {
        UserRentEntityRent byToken = userRepository.findByToken(token);
        return byToken.getLogin();
    }

}
