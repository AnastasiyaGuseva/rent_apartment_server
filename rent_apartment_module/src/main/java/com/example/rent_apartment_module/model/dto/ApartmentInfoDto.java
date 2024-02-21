package com.example.rent_apartment_module.model.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class ApartmentInfoDto {

    private String city;

    private String street;

    private String homeNumber;

    private Integer price;

    private Integer roomsCount;

}
