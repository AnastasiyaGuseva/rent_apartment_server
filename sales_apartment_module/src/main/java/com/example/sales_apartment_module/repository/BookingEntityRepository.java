package com.example.sales_apartment_module.repository;

import com.example.sales_apartment_module.entity.BookingEntitySales;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BookingEntityRepository extends JpaRepository<BookingEntitySales,Long> {
}
