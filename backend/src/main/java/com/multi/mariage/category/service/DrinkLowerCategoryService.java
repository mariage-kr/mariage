package com.multi.mariage.category.service;

import com.multi.mariage.category.domain.DrinkLowerCategory;
import com.multi.mariage.category.domain.DrinkUpperCategory;
import com.multi.mariage.category.domain.Region;
import com.multi.mariage.category.vo.DrinkLowerCategoriesVo;
import com.multi.mariage.category.vo.DrinkLowerCategoriesSubCategoriesVo;
import com.multi.mariage.category.dto.response.DrinkLowerCategoryResponse;
import com.multi.mariage.category.vo.DrinkLowerCategoryValuesVo;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Service
public class DrinkLowerCategoryService {

    public DrinkLowerCategoryResponse findCategories() {
        List<DrinkLowerCategory> lowerCategories = Arrays.asList(DrinkLowerCategory.values());

        List<DrinkLowerCategoryValuesVo> responseList = new ArrayList<>();

        List<Region> regionList = Arrays.asList(Region.values());   // 국내 해외
        List<DrinkUpperCategory> upperCategoryList = Arrays.asList(DrinkUpperCategory.values());    // LOCAL_SOJU, LOCAL_BEER 등

        for (Region region : regionList) {
            List<DrinkLowerCategoriesVo> categoryList = new ArrayList<>();

            getCategories(lowerCategories, upperCategoryList, region, categoryList);
            DrinkLowerCategoryValuesVo response = DrinkLowerCategoryValuesVo.from(region.getValue(), region.name(), categoryList);    // "region": "국내","regionValue": "LOCAL","categories": []

            responseList.add(response);
        }

        return new DrinkLowerCategoryResponse(responseList);
    }

    private static void getCategories(List<DrinkLowerCategory> lowerCategories, List<DrinkUpperCategory> upperCategoryList, Region region, List<DrinkLowerCategoriesVo> categoryList) {
        for (DrinkUpperCategory upperCategory : upperCategoryList) {
            List<DrinkLowerCategoriesSubCategoriesVo> subCategoryList = getSubCategories(lowerCategories, region, upperCategory);

            if (!subCategoryList.isEmpty()) {
                DrinkLowerCategoriesVo category = DrinkLowerCategoriesVo.from(upperCategory.name(), upperCategory.getName(), subCategoryList);  // "name": "LOCAL_SOJU", "value": "소주", "subCategories": []...
                categoryList.add(category);
            }
        }
    }

    private static List<DrinkLowerCategoriesSubCategoriesVo> getSubCategories(List<DrinkLowerCategory> lowerCategories, Region region, DrinkUpperCategory upperCategory) {
        List<DrinkLowerCategoriesSubCategoriesVo> subCategoryList = lowerCategories.stream()
                .filter(category -> category.getUpperType().equals(upperCategory) && category.getUpperType().name().contains(region.name()))
                .map(category -> DrinkLowerCategoriesSubCategoriesVo.from(category.name(), category.getName()))
                .toList();      //"subCategories": [{"name": "NORMAL_SOJU","value": "희석식 소주"}...
        return subCategoryList;
    }

}