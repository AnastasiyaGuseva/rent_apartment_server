package com.example.rent_apartment_module.model.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;

@Entity
@Data
@Table(name = "integration_info")
public class IntegrationEntityRent {

    @Id
    private String id;

    @Column(name = "path_info")
    private String pathInfo;

    @Column(name = "key_info")
    private String keyInfo;

    @Column(name = "description")
    private String description;

}
