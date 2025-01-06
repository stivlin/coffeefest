package com.example.demo;

import lombok.Value;

@Value
// difference with @Data & @Value
public class CountryItem {

    String name;
    Long id;
    int population;
    String religion;
    Boolean isSnowly;
    int area;
    String capital;
    String president;
    String UTCTime;
    String currency;
    int yearFoundation;

}
