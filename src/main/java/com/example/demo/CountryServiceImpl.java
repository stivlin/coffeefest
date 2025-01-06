package com.example.demo;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class CountryServiceImpl implements CountryService {

    private final CountryRepository countryRepository;

// method get all countries
    @Override
    public List<CountryItem> getAll() {

        List<CountryItem> countries = countryRepository.findAllByOrderByNameAsc()
                .stream()
                .map(ciudad -> new CountryItem(ciudad.getName(), ciudad.getId(),
                        ciudad.getPopulation(),ciudad.getReligion(),ciudad.getIsSnowly(), ciudad.getArea(),
                        ciudad.getCapital(), ciudad.getPresident(), ciudad.getUTCTime(),
                        ciudad.getCurrency(), ciudad.getYearFoundation()))
                .toList();
        // .stream().map(ce -> new CountryItem(ce.getName, ce.getId)).toList();
        return countries;
    }
//  Create a method that gives you countries by Id.
    @Override
    public CountryItem getById(Long id) {
        Optional<CountryEntity> optionalCountryEntity = countryRepository.findById(id);
        if (optionalCountryEntity.isPresent()) {
            CountryEntity countryEntity = optionalCountryEntity.get();
            return new CountryItem(countryEntity.getName(), countryEntity.getId(),
                    countryEntity.getPopulation(), countryEntity.getReligion(), countryEntity.getIsSnowly(),
                    countryEntity.getArea(), countryEntity.getCapital(), countryEntity.getPresident(),
                    countryEntity.getUTCTime(), countryEntity.getCurrency(), countryEntity.getYearFoundation());
        }
        return null;
    }

    @Override
    public Long createCountry(CreateCountryCommand createCountryCommand) {
        CountryEntity countryEntity = new CountryEntity();
        countryEntity.setName(createCountryCommand.getName());
        countryEntity.setPopulation(createCountryCommand.getPopulation());
        countryEntity.setReligion(createCountryCommand.getReligion());
        countryEntity.setIsSnowly(createCountryCommand.getIsSnowly());
        countryEntity.setArea(createCountryCommand.getArea());
        countryEntity.setCapital(createCountryCommand.getCapital());
        countryEntity.setPresident(createCountryCommand.getPresident());
        countryEntity.setUTCTime(createCountryCommand.getUTCTime());
        countryEntity.setCurrency(createCountryCommand.getCurrency());
        countryEntity.setYearFoundation(createCountryCommand.getYearFoundation());
        countryRepository.save(countryEntity);

        return countryEntity.getId();
    }

//    @Override
//    public CountryItem getByName(String name) {
//        Optional<CountryEntity> optionalCountryEntity = countryRepository.findByName(name);
//        if (optionalCountryEntity.isPresent()) {
//            CountryEntity countryEntity = optionalCountryEntity.get();
//            return new CountryItem(countryEntity.getName(), countryEntity.getId());
//        }
//
//        return null;
//    }

//    @Override
//    public List<CityItem> getCitiesByCountry(Long countryId) {
//        Optional<CountryEntity> optionalCountryEntity = countryRepository.findById(countryId);
//        if (optionalCountryEntity.isPresent()) {
//            CountryEntity countryEntity = optionalCountryEntity.get();
//            List<CityEntity> cities = countryEntity.getCities();
//            return cities
//                    .stream()
//                    .map(c -> new CityItem(c.getName(), c.getId()))
//                    .filter(c -> !c.getName().contains("Col"))
//                    .toList();
//        }
//        return null;
//    }


}
