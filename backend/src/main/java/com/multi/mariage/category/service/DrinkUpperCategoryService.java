package com.multi.mariage.category.service;

import com.multi.mariage.category.domain.DrinkUpperCategory;
import com.multi.mariage.category.dto.CategoriesResponse;
import com.multi.mariage.category.dto.DrinkUpperCategoryResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@RequiredArgsConstructor
@Transactional(readOnly = true)
@Service
public class DrinkUpperCategoryService {
    @Transactional
    public List<DrinkUpperCategoryResponse> findCategories() {
        List<DrinkUpperCategory> categories = Arrays.asList(DrinkUpperCategory.values());
        List<DrinkUpperCategoryResponse> responseList = new ArrayList<>();

        List<String> regionList = categories.stream()
                .map(DrinkUpperCategory::getRegion)
                .distinct()
                .toList();

        for (String region : regionList) {
            List<CategoriesResponse> categoryList = categories.stream()
                    .filter(category -> category.getRegion().equals(region))
                    .map(category -> CategoriesResponse.builder()
                            .name(category.name())
                            .value(category.getName())
                            .build())
                    .collect(Collectors.toList());

            DrinkUpperCategoryResponse response = DrinkUpperCategoryResponse.builder()
                    .region(region)
                    .categories(categoryList)
                    .build();
            responseList.add(response);
        }

        return responseList;
    }
}
