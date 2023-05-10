package com.multi.mariage.category.service;

import com.multi.mariage.category.domain.DrinkLowerCategory;
import com.multi.mariage.category.domain.DrinkUpperCategory;
import com.multi.mariage.category.domain.Region;
import com.multi.mariage.category.vo.lowercategory.DrinkLowerCategoriesVO;
import com.multi.mariage.category.vo.lowercategory.DrinkLowerSubCategoriesVO;
import com.multi.mariage.category.dto.response.DrinkLowerCategoryResponse;
import com.multi.mariage.category.vo.lowercategory.DrinkLowerCategoryValuesVO;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Service
public class DrinkLowerCategoryService {

    public DrinkLowerCategoryResponse findCategories() {
        List<DrinkLowerCategory> lowerCategories = Arrays.asList(DrinkLowerCategory.values());

        List<DrinkLowerCategoryValuesVO> responseList = new ArrayList<>();

        List<Region> regionList = Arrays.asList(Region.values());   // 국내, 해외
        List<DrinkUpperCategory> upperCategoryList = Arrays.asList(DrinkUpperCategory.values());    // LOCAL_SOJU, LOCAL_BEER 등

        for (Region region : regionList) {
            List<DrinkLowerCategoriesVO> categoryList = new ArrayList<>();

            getCategories(lowerCategories, upperCategoryList, region, categoryList);
            DrinkLowerCategoryValuesVO response = DrinkLowerCategoryValuesVO.from(region.getValue(), region.name(), categoryList);    // "region": "국내","regionValue": "LOCAL","categories": []

            responseList.add(response);
        }

        return new DrinkLowerCategoryResponse(responseList);
    }

    private static void getCategories(List<DrinkLowerCategory> lowerCategories, List<DrinkUpperCategory> upperCategoryList, Region region, List<DrinkLowerCategoriesVO> categoryList) {
        for (DrinkUpperCategory upperCategory : upperCategoryList) {
            List<DrinkLowerSubCategoriesVO> subCategoryList = getSubCategories(lowerCategories, region, upperCategory);

            if (!subCategoryList.isEmpty()) {
                DrinkLowerCategoriesVO category = DrinkLowerCategoriesVO.from(upperCategory.name(), upperCategory.getName(), subCategoryList);  // "name": "LOCAL_SOJU", "value": "소주", "subCategories": []...
                categoryList.add(category);
            }
        }
    }

    private static List<DrinkLowerSubCategoriesVO> getSubCategories(List<DrinkLowerCategory> lowerCategories, Region region, DrinkUpperCategory upperCategory) {
        List<DrinkLowerSubCategoriesVO> subCategoryList = lowerCategories.stream()
                .filter(category -> category.getUpperType().equals(upperCategory) && category.getUpperType().name().contains(region.name()))
                .map(category -> DrinkLowerSubCategoriesVO.from(category.name(), category.getName()))
                .toList();      //"subCategories": [{"name": "NORMAL_SOJU","value": "희석식 소주"}...
        return subCategoryList;
    }

}