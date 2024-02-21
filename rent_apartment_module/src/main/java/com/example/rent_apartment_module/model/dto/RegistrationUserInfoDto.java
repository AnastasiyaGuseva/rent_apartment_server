package com.example.rent_apartment_module.model.dto;

import lombok.Data;

import java.time.LocalDateTime;

@Data
public class RegistrationUserInfoDto {

    private String login;

    private String nickName;

    private String password;

    private String cityOfLiving;

    private LocalDateTime birthDate;

}
