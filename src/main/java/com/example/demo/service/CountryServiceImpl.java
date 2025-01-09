package com.example.demo.service;

import com.example.demo.model.CountryItem;
import com.example.demo.model.CreateCountryCommand;
import com.example.demo.model.UpdateCountryCommand;
import com.example.demo.repositoty.CountryRepository;
import com.example.demo.entities.CountryEntity;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.List;

@Service
@RequiredArgsConstructor
public class CountryServiceImpl implements CountryService {

    private final CountryRepository countryRepository;

    // method get all countries
    @Override
    public List<CountryItem> getAll() {

        return countryRepository.findAllByOrderByNameAsc()
                .stream()
                .map(this::fillCountryItem)
                .toList();
        // .stream().map(ce -> new CountryItem(ce.getName, ce.getId)).toList();
    }

    //  Create a method that gives you countries by Id.
    @Override
    public CountryItem getById(Long id) {
        var countryEntity = findCountryById(id);
        return fillCountryItem(countryEntity);
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

        return countryRepository.save(countryEntity).getId();
    }

    @Override
    public String updateCountry(UpdateCountryCommand updateCountryCommand, Long countryId) {
        var countryEntity = findCountryById(countryId);
        countryEntity.setArea(updateCountryCommand.getArea());
        countryEntity.setCapital(updateCountryCommand.getCapital());
        countryEntity.setIsSnowly(updateCountryCommand.getIsSnowly());
        countryEntity.setPopulation(updateCountryCommand.getPopulation());
        countryEntity.setReligion(updateCountryCommand.getReligion());
        countryEntity.setPresident(updateCountryCommand.getPresident());
        countryEntity.setCurrency(updateCountryCommand.getCurrency());
        countryRepository.save(countryEntity);

        return "OK, man";
    }

    @Override
    public String deleteCountry(Long countryId) {
        var countryEntity = findCountryById(countryId);
        countryRepository.delete(countryEntity);
        return "OK, man";

        // alter table countries add column is_deleted
        // add boolean isDeleted in Entity
        // countryEntity.setIsDeleted(true); soft delete - мягкое удаление
    }

    private CountryEntity findCountryById(Long countryId) {
        return countryRepository
                .findById(countryId)
                .orElseThrow();
    }

    private CountryItem fillCountryItem(CountryEntity countryEntity) {
        return new CountryItem(
                countryEntity.getName(),
                countryEntity.getId(),
                countryEntity.getPopulation(),
                countryEntity.getReligion(),
                countryEntity.getIsSnowly(),
                countryEntity.getArea(),
                countryEntity.getCapital(),
                countryEntity.getPresident(),
                countryEntity.getUTCTime(),
                countryEntity.getCurrency(),
                countryEntity.getYearFoundation()
        );
    }

    private void getStreamExamples() {
        List<String> names = Arrays.asList("Nina", "Steven", "Dina", "Alejandro");
        // 1.
        List<String> namesWithoutAlejo = names
                .stream()
                .filter(name -> name.contains("o"))
                .toList();

        // 2.
        List<String> upperNames = namesWithoutAlejo
                .stream()
                .map(String::toUpperCase)
                .toList();

        // 3.
        long count = upperNames.size();

        // 4.
        Optional<String> optional = Optional.of("Steven");
        optional.map(String::toUpperCase);

    }
}
