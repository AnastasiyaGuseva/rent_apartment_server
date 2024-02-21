package com.example.rent_apartment_server;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

@EnableEurekaServer
@SpringBootApplication
public class RentApartmentServerApplication {

    public static void main(String[] args) {
        SpringApplication.run(RentApartmentServerApplication.class, args);
    }

}
