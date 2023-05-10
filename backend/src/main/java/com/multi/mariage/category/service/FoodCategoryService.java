package com.multi.mariage.category.service;

import com.multi.mariage.category.domain.FoodCategory;
import com.multi.mariage.category.dto.response.FoodCategoryResponse;
import com.multi.mariage.category.vo.food.FoodCategoriesVO;
import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.List;

@Service
public class FoodCategoryService {
    public FoodCategoryResponse findFoodCategories() {
        List<FoodCategoriesVO> foodValues = getFoodValues();
        return FoodCategoryResponse.from(foodValues);
    }

    private List<FoodCategoriesVO> getFoodValues() {
        return Arrays.stream(FoodCategory.values())
                .map(FoodCategoriesVO::from)
                .toList();
    }
}
