package com.multi.mariage.category.service;

import com.multi.mariage.category.domain.DrinkUpperCategory;
import com.multi.mariage.category.domain.Region;
import com.multi.mariage.category.vo.uppercategory.DrinkUpperCategoriesVO;
import com.multi.mariage.category.dto.response.DrinkUpperCategoryResponse;
import com.multi.mariage.category.vo.uppercategory.DrinkUpperCategoryValuesVO;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Service
public class DrinkUpperCategoryService {
    public DrinkUpperCategoryResponse findCategories() {
        List<DrinkUpperCategory> categories = Arrays.asList(DrinkUpperCategory.values());
        List<DrinkUpperCategoryValuesVO> responseList = new ArrayList<>();

        List<Region> regionList = Arrays.asList(Region.values());

        getCategories(categories, responseList, regionList);
        DrinkUpperCategoryResponse drinkUpperCategoryResponse = new DrinkUpperCategoryResponse(responseList);
        return drinkUpperCategoryResponse;
    }
    private static void getCategories(List<DrinkUpperCategory> categories, List<DrinkUpperCategoryValuesVO> responseList, List<Region> regionList) {

        for (Region region : regionList) {
            List<DrinkUpperCategoriesVO> categoryList = filterAndMapToCategories(categories, region);

            DrinkUpperCategoryValuesVO response = DrinkUpperCategoryValuesVO.from(region.getValue(), region.name(), categoryList);
            responseList.add(response);
        }
    }
    private static List<DrinkUpperCategoriesVO> filterAndMapToCategories(List<DrinkUpperCategory> categories, Region region) {
        List<DrinkUpperCategoriesVO> categoryList = categories.stream()
                .filter(category -> category.name().contains(region.name()))
                .map(category -> DrinkUpperCategoriesVO.from(category.name(), category.getName()))
                .toList();
        return categoryList;
    }
}
