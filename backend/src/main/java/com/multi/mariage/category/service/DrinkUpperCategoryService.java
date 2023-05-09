package com.multi.mariage.category.service;

import com.multi.mariage.category.domain.DrinkUpperCategory;
import com.multi.mariage.category.domain.Region;
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

@Service
public class DrinkUpperCategoryService {
    public DrinkUpperCategoryResponse findCategories() {
        List<DrinkUpperCategory> categories = Arrays.asList(DrinkUpperCategory.values());
        List<DrinkUpperCategoryValuesResponse> responseList = new ArrayList<>();

        List<Region> regionList = Arrays.asList(Region.values());

        for (Region region : regionList) {
            List<DrinkUpperCategoriesResponse> categoryList = categories.stream()
                    .filter(category -> category.name().contains(region.name()))
                    .map(category -> DrinkUpperCategoriesResponse.builder()
                            .name(category.name())
                            .value(category.getName())
                            .build())
                    .toList();

            DrinkUpperCategoryValuesResponse response = DrinkUpperCategoryValuesResponse.builder()
                    .region(region.getValue())
                    .regionValue(region.name())
                    .categories(categoryList)
                    .build();
            responseList.add(response);
        }
        DrinkUpperCategoryResponse drinkUpperCategoryResponse = new DrinkUpperCategoryResponse(responseList);
        return drinkUpperCategoryResponse;
    }
}
