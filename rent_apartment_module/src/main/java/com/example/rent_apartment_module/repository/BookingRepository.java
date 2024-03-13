package com.example.rent_apartment_module.repository;

import com.example.rent_apartment_module.model.entity.BookingEntityRent;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BookingRepository extends JpaRepository<BookingEntityRent, Long> {
}
