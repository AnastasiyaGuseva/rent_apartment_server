package com.example.rent_apartment_module.mapper;

import com.example.rent_apartment_module.model.dto.ApartmentInfoDto;
import com.example.rent_apartment_module.model.entity.AddressEntityRent;
import com.example.rent_apartment_module.model.entity.ApartmentEntityRent;
import org.mapstruct.Mapper;
import org.mapstruct.MappingConstants;

import java.util.List;
import java.util.stream.Collectors;

@Mapper(componentModel = MappingConstants.ComponentModel.SPRING)
public interface RentMapper {

    ApartmentInfoDto toApartmentDto(ApartmentEntityRent apartment, AddressEntityRent address);

    default List<ApartmentInfoDto> toApartmentInfoListDto( List<ApartmentEntityRent> apartments){
        return apartments.stream().map(apartment -> toApartmentInfoDto(apartment, apartment.getAddress())).collect(Collectors.toList());
    }

   // @Mapping(target = "roomNumber", source = "address.homeNumber")
    ApartmentInfoDto toApartmentInfoDto (ApartmentEntityRent apartment, AddressEntityRent address);

}
