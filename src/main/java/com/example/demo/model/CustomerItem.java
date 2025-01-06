package com.example.demo.model;

import lombok.Value;

@Value
public class CustomerItem {

    String firstName;
    String lastName;
    String email;
    String phone;
    Integer age;
    Long id;
}
