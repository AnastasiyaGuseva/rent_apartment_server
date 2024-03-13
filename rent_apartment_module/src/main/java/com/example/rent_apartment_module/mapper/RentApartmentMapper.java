package com.example.rent_apartment_module.mapper;

import com.example.rent_apartment_module.model.dto.ApartmentInfoDto;
import com.example.rent_apartment_module.model.dto.BookingInfoDto;
import com.example.rent_apartment_module.model.dto.RegistrationUserInfoDto;
import com.example.rent_apartment_module.model.entity.AddressEntityRent;
import com.example.rent_apartment_module.model.entity.ApartmentEntityRent;
import com.example.rent_apartment_module.model.entity.BookingEntityRent;
import com.example.rent_apartment_module.model.entity.UserRentEntityRent;
import org.springframework.stereotype.Component;


@Component
public class RentApartmentMapper {
    public UserRentEntityRent toUserRentEntity(RegistrationUserInfoDto regInfo) {
        UserRentEntityRent userRentEntityRent = UserRentEntityRent.builder()
                .nickName(regInfo.getNickName())
                .password(regInfo.getPassword())
                .login(regInfo.getLogin())
                .cityOfLiving(regInfo.getCityOfLiving())
                .birthDate(regInfo.getBirthDate())
                .build();
        return userRentEntityRent;
    }

    public AddressEntityRent toAddressEntity(ApartmentInfoDto apartmentInfoDto) {
        AddressEntityRent addressEntityRent = AddressEntityRent.builder()
                .city(apartmentInfoDto.getCity())
                .street(apartmentInfoDto.getStreet())
                .homeNumber(apartmentInfoDto.getHomeNumber())
                .build();
        return addressEntityRent;
    }

    public ApartmentEntityRent toApartmentEntity(ApartmentInfoDto apartmentDto) {
        ApartmentEntityRent apartmentEntityRent = ApartmentEntityRent.builder()
                .roomsCount(apartmentDto.getRoomsCount())
                .price(apartmentDto.getPrice())
                .freeFlag(true)
                .foolRating(0.0)
                .build();
        return apartmentEntityRent;
    }

    public ApartmentInfoDto toApartmentInfoDto(ApartmentEntityRent apartmentEntityRent) {
        ApartmentInfoDto apartmentInfoDto = ApartmentInfoDto.builder()
                .city(apartmentEntityRent.getAddress().getCity())
                .street(apartmentEntityRent.getAddress().getStreet())
                .homeNumber(apartmentEntityRent.getAddress().getHomeNumber())
                .price(apartmentEntityRent.getPrice())
                .roomsCount(apartmentEntityRent.getRoomsCount())
                .build();
        return apartmentInfoDto;
    }

    public BookingEntityRent toBookingInfoEntity(BookingInfoDto bookingInfoDto) {
        BookingEntityRent bookingEntityRent = BookingEntityRent.builder()
                .peopleAmount(bookingInfoDto.getPeopleAmount())
                .endDate(bookingInfoDto.getEndDate())
                .startDate(bookingInfoDto.getStartDate())
                .build();
        return bookingEntityRent;
    }
}
