package com.example.rent_apartment_module.model.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class BookingResponseDto {

    private String message;

    private ApartmentInfoDto apartmentFoolInfoDto;
}
