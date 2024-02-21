package com.example.rent_apartment_module.controller;

import com.example.rent_apartment_module.model.dto.AuthorisationUserInfoDto;
import com.example.rent_apartment_module.model.dto.RegistrationUserInfoDto;
import com.example.rent_apartment_module.service.UserRentService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import static com.example.rent_apartment_module.constant.RentApartmentConstant.AUTH;
import static com.example.rent_apartment_module.constant.RentApartmentConstant.REG;

@RestController
@RequiredArgsConstructor
public class AuthController {

    private final UserRentService userRentService;

    @PostMapping(REG)
    public String registrationNewUser(@RequestBody RegistrationUserInfoDto userInfoDto) {
        return userRentService.saveUserRentEntity(userInfoDto);
    }

    @PostMapping(AUTH)
    public String authorisationUser(@RequestBody AuthorisationUserInfoDto userInfoDto) {
        return userRentService.authUserRentEntity(userInfoDto);
    }
}
