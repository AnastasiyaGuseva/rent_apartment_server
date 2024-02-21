package com.example.rent_apartment_module.model.dto;

import lombok.Data;

import java.time.LocalDateTime;

@Data
public class BookingTimeDto {

    private LocalDateTime startBookingDate;

    private LocalDateTime endBookingDate;
}
