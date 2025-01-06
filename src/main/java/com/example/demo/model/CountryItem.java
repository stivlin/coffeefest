package com.example.demo.model;

import lombok.Value;

@Value
// difference with @Data & @Value
public class CountryItem {

    String name;
    Long id;
    Integer population;
    String religion;
    Boolean isSnowly;
    Integer area;
    String capital;
    String president;
    String UTCTime;
    String currency;
    Integer yearFoundation;

}
