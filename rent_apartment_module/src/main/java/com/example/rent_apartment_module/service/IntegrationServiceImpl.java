package com.example.rent_apartment_module.service;

import com.example.rent_apartment_module.model.dto.LocationInfoDto;
import com.example.rent_apartment_module.model.dto.geoDto.OpenCageData;
import com.example.rent_apartment_module.model.entity.IntegrationEntityRent;
import com.example.rent_apartment_module.repository.IntegrationRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpMethod;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.nio.charset.StandardCharsets;
import java.util.Base64;

import static com.example.rent_apartment_module.constant.RentApartmentConstant.GEO;
import static com.example.rent_apartment_module.constant.RentApartmentConstant.PRODUCT;


@Service
@RequiredArgsConstructor

public class IntegrationServiceImpl implements IntegrationService {

    private final IntegrationRepository repository;
    private final RestTemplate restTemplate;


    @Override
    public OpenCageData getInfoByLocation(LocationInfoDto infoDto) {
        String url = formUrlGeo(infoDto, decodeKey(GEO));

        return restTemplate.exchange(
                url,
                HttpMethod.GET,
                null,
                OpenCageData.class).getBody();

    }

    public void getInfoByBookingId(Long id) {
        String url = formUrlProduct(id, decodeKey(PRODUCT));

        restTemplate.exchange(
                url,
                HttpMethod.GET,
                null,
                Void.class,
                id
        ).getBody();

    }

    private String formUrlGeo(LocationInfoDto infoDto, String key) {
        //
        IntegrationEntityRent config = repository.findById(GEO).get();
        return String.format(config.getPathInfo(),
                infoDto.getLongitude(), infoDto.getWidth(), key);
    }

    private String formUrlProduct(Long id, String key) {
        //
        IntegrationEntityRent config = repository.findById(PRODUCT).get();
        return String.format(config.getPathInfo(),
                id, key);
    }

    private String decodeKey(String serviceId) {
        IntegrationEntityRent config = repository.findById(serviceId).get();
        byte[] decoded = Base64.getDecoder().decode(config.getKeyInfo());
        String decodedStr = new String(decoded, StandardCharsets.UTF_8);
        return decodedStr;
    }
}
