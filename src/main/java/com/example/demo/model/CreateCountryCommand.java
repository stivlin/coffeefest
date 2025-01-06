package com.example.demo.model;

import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Value;

@Value
public class CreateCountryCommand {

    @NotBlank
    String name;
    @Min(0)
    Integer population;
    String religion;
    @NotNull
    Boolean isSnowly;
    @Min(0)
    Integer area;
    String capital;
    String president;
    String UTCTime;
    String currency;
    @Min(0)
    Integer yearFoundation;
}
