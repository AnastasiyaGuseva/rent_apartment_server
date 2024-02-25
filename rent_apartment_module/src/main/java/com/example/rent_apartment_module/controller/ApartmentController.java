package com.example.rent_apartment_module.controller;

import com.example.rent_apartment_module.model.dto.ApartmentInfoDto;
import com.example.rent_apartment_module.model.dto.BookingResponseDto;
import com.example.rent_apartment_module.model.dto.LocationInfoDto;
import com.example.rent_apartment_module.service.ApartmentService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

import static com.example.rent_apartment_module.constant.RentApartmentConstant.*;
import static java.util.Objects.isNull;


@RestController
@RequiredArgsConstructor
public class ApartmentController {

    private final ApartmentService apartmentService;

    @PostMapping(REG_APARTMENT)
    public String registrationNewApartment(@RequestBody ApartmentInfoDto apartmentDto) {
        return apartmentService.saveApartmentEntity(apartmentDto);
    }

    @GetMapping(GET_RATING)
    public Double countAverageRating(@PathVariable Long id) {
        return apartmentService.getAverageRating(id);
    }

    @PostMapping(BOOKING)
    public BookingResponseDto showApartmentForBooking(@PathVariable Long id) {
            return apartmentService.showApartment(id);
    }
    // если дто не пусто, проверить токен на валиность(, если пустой - зарегестрируйтесь, если с
// токеном всё норм

    @PostMapping(APARTMENTS_BY_GEO)
    public List<ApartmentInfoDto> showApartmentByLocation(@RequestBody LocationInfoDto locationInfoDto) {
        return apartmentService.apartmentByLocation(locationInfoDto);
    }
}
