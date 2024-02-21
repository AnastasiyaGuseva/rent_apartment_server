package com.example.rent_apartment_module.service;

import com.example.rent_apartment_module.model.dto.LocationInfoDto;
import com.example.rent_apartment_module.model.dto.geoDto.OpenCageData;

public interface IntegrationService {
    OpenCageData getInfoByLocation(LocationInfoDto infoDto);

}
