package com.multi.mariage.category.controller;

import com.multi.mariage.category.dto.DrinkUpperCategoryResponse;
import com.multi.mariage.category.service.DrinkUpperCategoryService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RequiredArgsConstructor
@RequestMapping("/api")
@RestController
public class CategoryController {
    private final DrinkUpperCategoryService drinkUpperCategoryService;

    @GetMapping("/categories")
    public ResponseEntity<DrinkUpperCategoryResponse> findUpperCategories() {
        DrinkUpperCategoryResponse response = drinkUpperCategoryService.findCategories();
        return ResponseEntity.ok(response);
    }
}
