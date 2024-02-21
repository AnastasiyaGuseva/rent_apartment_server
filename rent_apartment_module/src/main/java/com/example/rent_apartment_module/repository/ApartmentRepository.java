package com.example.rent_apartment_module.repository;

import com.example.rent_apartment_module.model.entity.ApartmentEntityRent;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface ApartmentRepository extends JpaRepository<ApartmentEntityRent, Long> {
    @Query(nativeQuery = true, value = "SELECT AVG(rating_info.overall_rating)\n" +
            "FROM apartment_info\n" +
            "         JOIN address_info ON apartment_info.apartment_address = address_info.apartment_id\n" +
            "         JOIN rating_info ON apartment_info.apartment_rating = rating_info.apartment_entity_id\n" +
            "WHERE address_info.street = :street AND address_info.city = :city AND address_info.home_number = :homeNumber")
    Integer getAverageRating(String street, String city, String homeNumber);

}

