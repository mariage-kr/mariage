package com.multi.mariage.category.service;

import com.multi.mariage.category.domain.DrinkUpperCategory;
import com.multi.mariage.category.domain.Region;
import com.multi.mariage.category.vo.DrinkUpperCategoriesVo;
import com.multi.mariage.category.dto.response.DrinkUpperCategoryResponse;
import com.multi.mariage.category.vo.DrinkUpperCategoryValuesVo;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Service
public class DrinkUpperCategoryService {
    public DrinkUpperCategoryResponse findCategories() {
        List<DrinkUpperCategory> categories = Arrays.asList(DrinkUpperCategory.values());
        List<DrinkUpperCategoryValuesVo> responseList = new ArrayList<>();

        List<Region> regionList = Arrays.asList(Region.values());

        generateDrinkUpperCategoryValues(categories, responseList, regionList);
        DrinkUpperCategoryResponse drinkUpperCategoryResponse = new DrinkUpperCategoryResponse(responseList);
        return drinkUpperCategoryResponse;
    }
    private static void generateDrinkUpperCategoryValues(List<DrinkUpperCategory> categories, List<DrinkUpperCategoryValuesVo> responseList, List<Region> regionList) {

        for (Region region : regionList) {
            List<DrinkUpperCategoriesVo> categoryList = filterAndMapToUpperCategories(categories, region);

            DrinkUpperCategoryValuesVo response = DrinkUpperCategoryValuesVo.builder()
                    .region(region.getValue())
                    .regionValue(region.name())
                    .categories(categoryList)
                    .build();
            responseList.add(response);
        }
    }
    private static List<DrinkUpperCategoriesVo> filterAndMapToUpperCategories(List<DrinkUpperCategory> categories, Region region) {
        List<DrinkUpperCategoriesVo> categoryList = categories.stream()
                .filter(category -> category.name().contains(region.name()))
                .map(category -> DrinkUpperCategoriesVo.builder()
                        .name(category.name())
                        .value(category.getName())
                        .build())
                .toList();
        return categoryList;
    }
}
