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
}
