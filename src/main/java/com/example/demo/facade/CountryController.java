package com.example.demo.facade;

import com.example.demo.model.CountryItem;
import com.example.demo.service.CountryService;
import com.example.demo.model.CreateCountryCommand;
import com.example.demo.model.UpdateCountryCommand;
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
    String updateCountry(@PathVariable Long countryId, @RequestBody UpdateCountryCommand upc) {
        return countryService.updateCountry(upc, countryId);
    }

    @DeleteMapping("/countries/{countryId}")
    String deleteCountry(@PathVariable Long countryId) {
        return countryService.deleteCountry(countryId);
    }
}

