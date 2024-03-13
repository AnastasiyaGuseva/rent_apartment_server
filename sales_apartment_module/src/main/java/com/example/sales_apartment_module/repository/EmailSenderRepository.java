package com.example.sales_apartment_module.repository;

import com.example.sales_apartment_module.model.entity.EmailSenderSales;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EmailSenderRepository extends JpaRepository<EmailSenderSales, String> {
}
