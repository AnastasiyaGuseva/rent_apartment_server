package com.example.sales_apartment_module.repository;

import com.example.sales_apartment_module.model.entity.BookingEntitySales;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface BookingEntityRepository extends JpaRepository<BookingEntitySales, Long> {
    @Query(value = "SELECT b FROM BookingEntitySales b WHERE b.id = :id")
    BookingEntitySales findByIdJPQL(Long id);//todo: JPQL query
}
