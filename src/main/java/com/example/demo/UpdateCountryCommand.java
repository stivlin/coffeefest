package com.example.demo;

import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Value;

@Value
public class UpdateCountryCommand {

    @Min(0)
    int population;
    String religion;
    @NotNull
    Boolean isSnowly;
    @Min(0)
    int area;
    String capital;
    String president;
    String currency; // = null

}

// PUT - обновляем всю сущность
// PATCH - несколько полей
