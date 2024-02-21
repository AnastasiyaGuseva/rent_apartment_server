package com.example.rent_apartment_module.model.dto.geoDto;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

@Data
@JsonIgnoreProperties(ignoreUnknown = true)
public class Components {

    @JsonProperty("_normalized_city")
    private String normalizedCity;

    private String city;

    private String town;

    private String continent;

    private String country;

    private String county;

    @JsonProperty("house_number")
    private String houseNumber;

    private String road;

    private String state;
}
