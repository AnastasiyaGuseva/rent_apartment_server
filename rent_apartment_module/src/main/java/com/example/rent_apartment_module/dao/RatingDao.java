package com.example.rent_apartment_module.dao;

import com.example.rent_apartment_module.model.entity.ApartmentEntityRent;
import com.example.rent_apartment_module.model.entity.RatingEntityRent;

import java.util.List;

public interface RatingDao {
    List<RatingEntityRent> findRatingEntitiesByApartmentEntity(ApartmentEntityRent apartmentEntityRent);

    Double findRatingEntitiesByApartmentEntityByQueryDSL(ApartmentEntityRent apartmentEntityRent);
}
