package com.example.rent_apartment_module.service;

import com.example.rent_apartment_module.model.dto.AuthorisationUserInfoDto;
import com.example.rent_apartment_module.model.dto.RegistrationUserInfoDto;

public interface UserRentService {
    String saveUserRentEntity(RegistrationUserInfoDto userInfoDto);

    String authUserRentEntity(AuthorisationUserInfoDto userInfoDto);
    Boolean findByToken(String token);
}
