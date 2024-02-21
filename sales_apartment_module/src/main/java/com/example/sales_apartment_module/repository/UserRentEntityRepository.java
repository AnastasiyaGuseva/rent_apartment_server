package com.example.sales_apartment_module.repository;

import com.example.sales_apartment_module.entity.UserRentEntitySales;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRentEntityRepository extends JpaRepository<UserRentEntitySales,Long> {
}
