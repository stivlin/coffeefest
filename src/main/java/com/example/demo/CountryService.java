package com.example.demo;

import java.util.List;
import java.util.Optional;

public interface CountryService {

    List<CountryItem> getAll();

    CountryItem getById(Long id);

    Long createCountry(CreateCountryCommand createCountryCommand);

    String updateCountry(UpdateCountryCommand updateCountryCommand, Long countryId);

    String deleteCountry(Long countryId);

//    CountryItem getByName(String name);

//    List<CityItem> getCitiesByCountry(Long countryId);

}
