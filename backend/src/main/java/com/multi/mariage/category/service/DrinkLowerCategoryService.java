package com.multi.mariage.category.service;

import com.multi.mariage.category.domain.DrinkLowerCategory;
import com.multi.mariage.category.domain.DrinkUpperCategory;
import com.multi.mariage.category.domain.Region;
import com.multi.mariage.category.dto.response.DrinkLowerCategoryResponse;
import com.multi.mariage.category.vo.drinkLower.DrinkLowerCategoriesVO;
import com.multi.mariage.category.vo.drinkLower.DrinkLowerCategoryValuesVO;
import com.multi.mariage.category.vo.drinkLower.DrinkLowerSubCategoriesVO;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Service
public class DrinkLowerCategoryService {

    public DrinkLowerCategoryResponse findCategories() {
        List<DrinkLowerCategoryValuesVO> responseList = getDrinkLowerCategoryValues();
        return new DrinkLowerCategoryResponse(responseList);
    }

    private List<DrinkLowerCategoryValuesVO> getDrinkLowerCategoryValues() {
        List<DrinkLowerCategoryValuesVO> responseList = new ArrayList<>();
        Arrays.stream(Region.values()).forEach(region -> {
            List<DrinkLowerCategoriesVO> categories = getDrinkUpperCategory(region);
            DrinkLowerCategoryValuesVO response = DrinkLowerCategoryValuesVO.from(region, categories);
            responseList.add(response);
        });
        return responseList;
    }

    private List<DrinkLowerCategoriesVO> getDrinkUpperCategory(Region region) {
        List<DrinkLowerCategoriesVO> categoryList = new ArrayList<>();
        Arrays.stream(DrinkUpperCategory.values()).forEach(upperCategory -> {
            List<DrinkLowerSubCategoriesVO> subCategoryList = getDrinkLowerCategory(region, upperCategory);
            if (subCategoryList.isEmpty()) {
                return;
            }
            categoryList.add(DrinkLowerCategoriesVO.from(upperCategory, subCategoryList));
        });
        return categoryList;
    }

    private List<DrinkLowerSubCategoriesVO> getDrinkLowerCategory(Region region, DrinkUpperCategory upperCategory) {
        return Arrays.stream(DrinkLowerCategory.values())
                .filter(category -> isEqualsUpperCategory(upperCategory, category) && hasCategoryByRegionName(region, category))
                .map(DrinkLowerSubCategoriesVO::from)
                .toList();
    }

    private boolean hasCategoryByRegionName(Region region, DrinkLowerCategory category) {
        return category.getUpperType().name().contains(region.name());
    }

    private boolean isEqualsUpperCategory(DrinkUpperCategory upperCategory, DrinkLowerCategory category) {
        return category.getUpperType().equals(upperCategory);
    }
}
