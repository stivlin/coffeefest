package com.example.demo.repositoty;

import com.example.demo.entities.CountryEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface CountryRepository extends JpaRepository<CountryEntity, Long> {
    // Select * from countries order by name Asc;
    List<CountryEntity> findAllByOrderByNameAsc();

    Optional<CountryEntity> findById(Long id);
    //    Optional<CountryEntity> findByName(String name);

}
