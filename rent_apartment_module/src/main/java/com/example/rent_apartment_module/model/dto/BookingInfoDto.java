package com.example.rent_apartment_module.model.dto;

import lombok.*;

import java.time.LocalDateTime;

@Data
@Builder
public class BookingInfoDto {

    private LocalDateTime startDate;

    private LocalDateTime endDate;

    private Integer peopleAmount;
}
