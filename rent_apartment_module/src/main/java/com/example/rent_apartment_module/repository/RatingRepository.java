package com.example.rent_apartment_module.repository;

import com.example.rent_apartment_module.model.entity.ApartmentEntityRent;
import com.example.rent_apartment_module.model.entity.RatingEntityRent;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface RatingRepository extends JpaRepository<RatingEntityRent, Long> {
  //  List<RatingEntityRent> findRatingEntityRentsByApartmentEntity(ApartmentEntityRent apartmentEntityRent);
}
