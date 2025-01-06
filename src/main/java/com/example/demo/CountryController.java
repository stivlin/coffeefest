package com.example.demo;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1")
@RequiredArgsConstructor
class CountryController {

    private final CountryService countryService;

    @GetMapping("/countries")
    List<CountryItem> getAll() {
        return countryService.getAll();
    }

    @GetMapping("/countries/{countryId}")
    CountryItem getById(@PathVariable Long countryId) {
        return countryService.getById(countryId);
    }

    @PostMapping("/countries")
    Long createCountry(@RequestBody CreateCountryCommand createCountryCommand) {
        return countryService.createCountry(createCountryCommand); // = id
    }

    @PutMapping("/countries/{countryId}")
    String updateZhopa(@PathVariable Long countryId, @RequestBody UpdateCountryCommand upc) {
        return countryService.updateCountry(upc, countryId);
    }

//    @GetMapping("/countries/{countryName}")
//    CountryItem getByName(@PathVariable String countryName) {
//        return countryService.getByName(countryName);
//    }


}

