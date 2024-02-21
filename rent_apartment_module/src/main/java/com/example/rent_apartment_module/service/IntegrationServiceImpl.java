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


@Service
@RequiredArgsConstructor

public class IntegrationServiceImpl implements IntegrationService {

    private final IntegrationRepository repository;
    private final RestTemplate restTemplate;


    @Override
    public OpenCageData getInfoByLocation(LocationInfoDto infoDto) {
        String url = formUrl(infoDto, decodeKey());

        return  restTemplate.exchange(
                url,
                HttpMethod.GET,
                null,
                OpenCageData.class).getBody();

    }

    private String formUrl(LocationInfoDto infoDto, String key) {
        IntegrationEntityRent config = repository.findById(GEO).get();
        return String.format(config.getPathInfo(),
                infoDto.getLongitude(), infoDto.getWidth(), key);
    }

    private String decodeKey() {
        IntegrationEntityRent config = repository.findById(GEO).get();
        byte[] decoded = Base64.getDecoder().decode(config.getKeyInfo());
        String decodedStr = new String(decoded, StandardCharsets.UTF_8);
        return decodedStr;
    }
}
