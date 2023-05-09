package com.multi.mariage.category.service;

import com.multi.mariage.category.domain.DrinkLowerCategory;
import com.multi.mariage.category.domain.DrinkUpperCategory;
import com.multi.mariage.category.domain.Region;
import com.multi.mariage.category.dto.DrinkLowerCategoriesResponse;
import com.multi.mariage.category.dto.DrinkLowerCategoriesSubResponse;
import com.multi.mariage.category.dto.DrinkLowerCategoryResponse;
import com.multi.mariage.category.dto.DrinkLowerCategoryValuesResponse;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Service
public class DrinkLowerCategoryService {

    public DrinkLowerCategoryResponse findCategories() {
        List<DrinkLowerCategory> lowerCategories = Arrays.asList(DrinkLowerCategory.values());

        List<DrinkLowerCategoryValuesResponse> responseList = new ArrayList<>();

        List<Region> regionList = Arrays.asList(Region.values());   // 국내 해외
        List<DrinkUpperCategory> upperCategoryList = Arrays.asList(DrinkUpperCategory.values());    // LOCAL_SOJU, LOCAL_BEER 등

        for (Region region : regionList) {
            List<DrinkLowerCategoriesResponse> categoryList = new ArrayList<>();

            for (DrinkUpperCategory upperCategory : upperCategoryList) {
                List<DrinkLowerCategoriesSubResponse> subCategoryList = lowerCategories.stream()
                        .filter(category -> category.getUpperType().equals(upperCategory) && category.getUpperType().name().contains(region.name()))
                        .map(category -> DrinkLowerCategoriesSubResponse.builder()
                                .name(category.name())
                                .value(category.getName())
                                .build())
                        .toList();      //"subCategories": [{"name": "NORMAL_SOJU","value": "희석식 소주"}...

                if (!subCategoryList.isEmpty()) {
                    DrinkLowerCategoriesResponse category = DrinkLowerCategoriesResponse.builder()
                            .name(upperCategory.name())
                            .value(upperCategory.getName())
                            .subCategories(subCategoryList)
                            .build();       // "name": "LOCAL_SOJU", "value": "소주", "subCategories": []...

                    categoryList.add(category);
                }
            }
            DrinkLowerCategoryValuesResponse response = DrinkLowerCategoryValuesResponse.builder()
                    .region(region.getValue())
                    .regionValue(region.name())
                    .categories(categoryList)
                    .build();       // "region": "국내","regionValue": "LOCAL","categories": []

            responseList.add(response);
        }

        return new DrinkLowerCategoryResponse(responseList);
    }

}