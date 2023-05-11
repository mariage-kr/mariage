package com.multi.mariage.country.controller;

import com.multi.mariage.category.dto.response.DrinkLowerCategoryResponse;
import com.multi.mariage.category.dto.response.DrinkUpperCategoryResponse;
import com.multi.mariage.category.dto.response.FoodCategoryResponse;
import com.multi.mariage.category.service.DrinkLowerCategoryService;
import com.multi.mariage.category.service.DrinkUpperCategoryService;
import com.multi.mariage.category.service.FoodCategoryService;
import com.multi.mariage.country.dto.response.CountryResponse;
import com.multi.mariage.country.service.CountryService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RequiredArgsConstructor
@RequestMapping("/api")
@RestController
public class CountryController {
    private final CountryService countryService;

    @GetMapping("/country/find")
    public ResponseEntity<CountryResponse> findCountries() {
        CountryResponse response = countryService.findCountries();
        return ResponseEntity.ok(response);
    }
}
