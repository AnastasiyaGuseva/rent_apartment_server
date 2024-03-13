package com.example.rent_apartment_module;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.web.client.RestTemplate;

@SpringBootApplication
public class RentApartmentModuleApplication {

    public static void main(String[] args) {
        SpringApplication.run(RentApartmentModuleApplication.class, args);
    }

    @Bean
    public RestTemplate restTemplate() {
        return new RestTemplate();
    }
    //Настройка timeout
//    @Bean
//    public RestTemplate restTemplate(RestTemplateBuilder restTemplateBuilder) {
//        return restTemplateBuilder
//                .setReadTimeout(Duration.ofHours(2L))
//                .setConnectTimeout(Duration.ofHours(2L))
//                .build();
//    }

}
