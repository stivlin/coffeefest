package com.example.demo.entities;

import jakarta.persistence.*;
import jakarta.validation.constraints.Min;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "coffee_sorts")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class CoffeeEntity {

    // TODO: 2. Добавить различные поля с enums - классы перечисления
    // сорт кофе
    // категория кофе
    // обработка кофе
    // страна
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String name;

    @Column(nullable = false)
    private String description;

    @Column(nullable = false)
    private Double price;

    @Min(value = 0)
    private Integer harvest; //уражай

    // TODO погуглить аннотации @ManyToOne и остальные

}
