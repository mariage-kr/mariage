package com.multi.mariage.category.service;

import com.multi.mariage.category.domain.DrinkUpperCategory;
import com.multi.mariage.category.domain.Region;
import com.multi.mariage.category.dto.response.DrinkUpperCategoryResponse;
import com.multi.mariage.category.vo.drinkupper.DrinkUpperCategoriesVO;
import com.multi.mariage.category.vo.drinkupper.DrinkUpperCategoryValuesVO;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Service
public class DrinkUpperCategoryService {

    public DrinkUpperCategoryResponse findDrinkUpperCategory() {
        List<DrinkUpperCategoryValuesVO> response = getDrinkUpperCategory(DrinkUpperCategory.values(), Region.values());
        return new DrinkUpperCategoryResponse(response);
    }

    private List<DrinkUpperCategoryValuesVO> getDrinkUpperCategory(DrinkUpperCategory[] categories,
                                                                   Region[] regionList) {
        List<DrinkUpperCategoryValuesVO> responseList = new ArrayList<>();
        Arrays.stream(regionList)
                .map(region -> DrinkUpperCategoryValuesVO.from(region.getValue(),
                        region.name(),
                        getDrinkUpperCategoriesVOByRegion(categories, region)))
                .forEach(responseList::add);
        return responseList;
    }

    private List<DrinkUpperCategoriesVO> getDrinkUpperCategoriesVOByRegion(DrinkUpperCategory[] categories,
                                                                           Region region) {
        return Arrays.stream(categories)
                .filter(category -> category.name().contains(region.name()))
                .map(category -> DrinkUpperCategoriesVO.from(category.name(), category.getName()))
                .toList();
    }
}
