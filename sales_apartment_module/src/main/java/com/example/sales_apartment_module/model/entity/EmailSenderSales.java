package com.example.sales_apartment_module.model.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;

@Entity
@Data
@Table(name = "email_sender_info")
public class EmailSenderSales {

    @Id
    private String id;

    @Column(name = "host")
    private String host;

    @Column(name = "password")
    private String password;

    @Column(name = "protocol")
    private String protocol;

    @Column(name = "port")
    private int port;

    @Column(name = "username")
    private String username;
}
