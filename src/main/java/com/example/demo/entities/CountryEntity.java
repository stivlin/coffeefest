package com.example.demo.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "countries")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class CountryEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String name;
// численность
    @Column
    private Integer population;
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
    private Integer area;
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
    private Integer yearFoundation;
    // int = 99999 == 0 db null = conflict
    // Integer = new Integer(99999); // == null
}
