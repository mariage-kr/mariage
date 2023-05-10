package com.multi.mariage.category.service;

import com.multi.mariage.category.domain.DrinkUpperCategory;
import com.multi.mariage.category.domain.FoodCategory;
import com.multi.mariage.category.domain.Region;
import com.multi.mariage.category.dto.response.DrinkUpperCategoryResponse;
import com.multi.mariage.category.dto.response.FoodCategoryResponse;
import com.multi.mariage.category.vo.drinkupper.DrinkUpperCategoriesVO;
import com.multi.mariage.category.vo.drinkupper.DrinkUpperCategoryValuesVO;
import com.multi.mariage.category.vo.food.FoodCategoriesVO;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class FoodCategoryService {
    public FoodCategoryResponse findCategories() {

        List<FoodCategory> categories = Arrays.asList(FoodCategory.values());

        List<FoodCategoriesVO> categoryList = categories.stream()
                .map(category -> FoodCategoriesVO.builder()
                        .id(category.getId())
                        .name(category.getName())
                        .build())
                .toList();

        FoodCategoryResponse response = FoodCategoryResponse.builder()
                .category(categoryList)
                .length(categoryList.size())
                .build();

        return response;
    }


}
