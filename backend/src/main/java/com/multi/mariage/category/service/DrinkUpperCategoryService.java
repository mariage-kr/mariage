package com.multi.mariage.category.service;

import com.multi.mariage.category.domain.DrinkUpperCategory;
import com.multi.mariage.category.domain.Region;
import com.multi.mariage.category.dto.response.DrinkUpperCategoryResponse;
import com.multi.mariage.category.vo.drinkUpper.DrinkUpperCategoriesVO;
import com.multi.mariage.category.vo.drinkUpper.DrinkUpperCategoryValuesVO;
import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.List;

@Service
public class DrinkUpperCategoryService {

    public DrinkUpperCategoryResponse findDrinkUpperCategory() {
        List<DrinkUpperCategoryValuesVO> response = getDrinkUpperCategory();
        return new DrinkUpperCategoryResponse(response);
    }

    private List<DrinkUpperCategoryValuesVO> getDrinkUpperCategory() {
        return Arrays.stream(Region.values())
                .map(region -> DrinkUpperCategoryValuesVO.from(region, getDrinkUpperCategoriesVOByRegion(region)))
                .toList();
    }

    private List<DrinkUpperCategoriesVO> getDrinkUpperCategoriesVOByRegion(Region region) {
        return Arrays.stream(DrinkUpperCategory.values())
                .filter(category -> category.name().contains(region.name()))
                .map(DrinkUpperCategoriesVO::from)
                .toList();
    }
}
