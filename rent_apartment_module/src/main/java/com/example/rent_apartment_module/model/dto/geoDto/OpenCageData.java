package com.example.rent_apartment_module.model.dto.geoDto;


import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Data;

import java.util.List;

@Data
@JsonIgnoreProperties(ignoreUnknown = true)
public class OpenCageData {

    private List<Result> results;

    private Status status;
}


