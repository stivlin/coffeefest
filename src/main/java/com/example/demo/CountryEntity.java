package com.example.demo;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Entity
@Table(name = "countries")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class CountryEntity {

    @Id
    @GeneratedValue
    private Long id;

    @Column(nullable = false)
    private String name;
// численность
    @Column
    private int population;
    // язык
    @Column
    private String language;
    // религия
    @Column
    private String religion;
    // снежно ли?
    @Column(name = "is_snowly")
    private Boolean isSnowly;
    // площадь
    @Column
    private int area;
    // столица
    @Column
    private String capital;
    // президент
    @Column
    private String president;
    // UTC
    @Column
    private String UTCTime;
    // Currency
    @Column
    private String currency;
    // год основания
    @Column(name = "year_foundation")
    private int yearFoundation;
}
