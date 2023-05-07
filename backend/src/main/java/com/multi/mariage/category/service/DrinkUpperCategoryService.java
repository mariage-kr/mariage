package com.multi.mariage.category.service;

import com.multi.mariage.category.domain.DrinkUpperCategory;
import com.multi.mariage.category.dto.DrinkUpperCategoriesResponse;
import com.multi.mariage.category.dto.DrinkUpperCategoryResponse;
import com.multi.mariage.category.dto.DrinkUpperCategoryValuesResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

@RequiredArgsConstructor
@Transactional(readOnly = true)
@Service
public class DrinkUpperCategoryService {
    @Transactional
    public DrinkUpperCategoryResponse findCategories() {
        List<DrinkUpperCategory> categories = Arrays.asList(DrinkUpperCategory.values());
        List<DrinkUpperCategoryValuesResponse> responseList = new ArrayList<>();

        List<String> regionList = categories.stream()
                .map(DrinkUpperCategory::getRegion)
                .distinct()
                .toList();

        for (String region : regionList) {
            List<DrinkUpperCategoriesResponse> categoryList = categories.stream()
                    .filter(category -> category.getRegion().equals(region))
                    .map(category -> DrinkUpperCategoriesResponse.builder()
                            .name(category.name())
                            .value(category.getName())
                            .build())
                    .collect(Collectors.toList());

            DrinkUpperCategoryValuesResponse response = DrinkUpperCategoryValuesResponse.builder()
                    .region(region)
                    .categories(categoryList)
                    .build();
            responseList.add(response);
        }
        DrinkUpperCategoryResponse drinkUpperCategoryResponse = DrinkUpperCategoryResponse.builder()
                .category(responseList)
                .build();

        return drinkUpperCategoryResponse;
    }
}
