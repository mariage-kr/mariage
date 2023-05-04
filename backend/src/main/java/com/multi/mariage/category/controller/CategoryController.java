package com.multi.mariage.category.controller;

import com.multi.mariage.category.dto.DrinkUpperCategoryResponse;
import com.multi.mariage.category.service.DrinkUpperCategoryService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RequiredArgsConstructor
@RequestMapping("/api")
@RestController
public class CategoryController {
    private final DrinkUpperCategoryService drinkUpperCategoryService;

    @GetMapping("/categories/{origin}")
    public ResponseEntity<List<DrinkUpperCategoryResponse>> findCategoriesByOrigin(@PathVariable String origin) {
        List<DrinkUpperCategoryResponse> categories = drinkUpperCategoryService.findCategoriesByOrigin(origin);
        return ResponseEntity.ok(categories);
    }
}
