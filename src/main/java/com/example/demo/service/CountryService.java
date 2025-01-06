package com.example.demo.service;

import com.example.demo.model.CountryItem;
import com.example.demo.model.CreateCountryCommand;
import com.example.demo.model.UpdateCountryCommand;

import java.util.List;

public interface CountryService {

    List<CountryItem> getAll();

    CountryItem getById(Long id);

    Long createCountry(CreateCountryCommand createCountryCommand);

    String updateCountry(UpdateCountryCommand updateCountryCommand, Long countryId);

    String deleteCountry(Long countryId);

//    CountryItem getByName(String name);

//    List<CityItem> getCitiesByCountry(Long countryId);

}
