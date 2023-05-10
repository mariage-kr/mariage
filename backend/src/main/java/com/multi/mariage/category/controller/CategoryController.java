package com.multi.mariage.category.controller;

import com.multi.mariage.category.dto.response.DrinkLowerCategoryResponse;
import com.multi.mariage.category.dto.response.DrinkUpperCategoryResponse;
import com.multi.mariage.category.dto.response.FoodCategoryResponse;
import com.multi.mariage.category.service.DrinkLowerCategoryService;
import com.multi.mariage.category.service.DrinkUpperCategoryService;
import com.multi.mariage.category.service.FoodCategoryService;
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
    private final DrinkLowerCategoryService drinkLowerCategoryService;
    private final FoodCategoryService foodCategoryService;

    @GetMapping("/categories/upper")
    public ResponseEntity<DrinkUpperCategoryResponse> findUpperCategories() {
        DrinkUpperCategoryResponse response = drinkUpperCategoryService.findCategories();
        return ResponseEntity.ok(response);
    }

    @GetMapping("/categories/lower")
    public ResponseEntity<DrinkLowerCategoryResponse> findLowerCategories() {
        DrinkLowerCategoryResponse response = drinkLowerCategoryService.findCategories();
        return ResponseEntity.ok(response);
    }

    @GetMapping("/categories/food")
    public ResponseEntity<FoodCategoryResponse> findFoodCategories() {
        FoodCategoryResponse response = foodCategoryService.findCategories();
        return ResponseEntity.ok(response);
    }
}
