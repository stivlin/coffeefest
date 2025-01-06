package com.example.demo.model;

import lombok.Value;

@Value
public class CoffeeItem {

    Long id;
    String name;
    String description;
    Double price;
    Integer harvest;

}
