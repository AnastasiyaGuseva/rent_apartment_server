package com.example.rent_apartment_module.model.dto;

import com.example.rent_apartment_module.validator.StrongPassword;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.Data;
import lombok.NonNull;
import org.springframework.format.annotation.DateTimeFormat;

import java.time.LocalDateTime;

@Data
public class RegistrationUserInfoDto {

    @Email
    @NotNull
    private String login;

    @NotBlank
    @Size(min = 2, max = 15)
    private String nickName;

    @NotNull
    @StrongPassword
    private String password;

    @NotNull
    private String cityOfLiving;

    @NotNull
    private LocalDateTime birthDate;

}
