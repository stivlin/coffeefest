package com.example.demo;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class CoffeeSortEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    @Enumerated(EnumType.STRING)

    private CoffeeCategory category;
    // text

    //<dependency>
              //  <groupId>io.hypersistence</groupId>
              //  <artifactId>hypersistence-utils-hibernate-62</artifactId>
               // <version>3.5.2</version>
//            </dependency>

    private String name;
}
