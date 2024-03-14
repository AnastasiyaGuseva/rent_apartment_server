package com.example.rent_apartment_module.service;

import com.example.rent_apartment_module.model.dto.ApartmentInfoDto;
import com.example.rent_apartment_module.model.dto.BookingInfoDto;
import com.example.rent_apartment_module.model.dto.BookingResponseDto;
import com.example.rent_apartment_module.model.dto.LocationInfoDto;

import java.util.List;

public interface ApartmentService {

    String saveApartmentEntity(ApartmentInfoDto apartmentInfoDto);

    Double getAverageRating(Long id);

    BookingResponseDto showApartment(Long id);

    List<ApartmentInfoDto> apartmentByLocation(LocationInfoDto infoDto);

    String bookingApartment(BookingInfoDto bookingInfoDto, Long apartmentId, String token);
}
