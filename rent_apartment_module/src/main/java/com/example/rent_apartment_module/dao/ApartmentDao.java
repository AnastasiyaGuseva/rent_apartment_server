package com.example.rent_apartment_module.dao;

import com.example.rent_apartment_module.model.entity.ApartmentEntityRent;

import java.util.List;

public interface ApartmentDao {
    ApartmentEntityRent findApartmentByCriteria(Long id);

    ApartmentEntityRent findApartmentByQueryDsl(Long id);

    List<ApartmentEntityRent> findApartmentByCriteria(String city);

    List<ApartmentEntityRent> findApartmentByQueryDsl(String city);
}
