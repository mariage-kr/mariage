package com.multi.mariage.category.service;

import com.multi.mariage.category.dto.response.FoodCategoryResponse;
import com.multi.mariage.category.vo.food.FoodCategoriesVO;
import com.multi.mariage.common.annotation.ServiceTest;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

class FoodCategoryServiceTest extends ServiceTest {

    FoodCategoryService foodCategoryService = new FoodCategoryService();

    @DisplayName("카테고리를 조회한다.")
    @Test
    void 카테고리를_조회한다() {

        FoodCategoryResponse response = foodCategoryService.findFoodCategories();

        assertThat(response).isNotNull();
        List<FoodCategoriesVO> vo = response.getCategory();

        for (FoodCategoriesVO actual : vo) {
            assertThat(actual.getId()).isNotNull();
            assertThat(actual.getName()).isNotEmpty();
        }
    }

    @DisplayName("특정한 음식을 조회한다.")
    @ParameterizedTest
    @ValueSource(strings = {"해산물", "고기/구이", "족발/보쌈", "피자", "치킨"})
    void 특정한_음식을_조회한다(String food) {

        FoodCategoryResponse response = foodCategoryService.findFoodCategories();

        List<FoodCategoriesVO> categories = response.getCategory();

        FoodCategoriesVO category = categories.stream()
                .filter(cv -> food.equals(cv.getName()))
                .findFirst()
                .orElse(null);

        assertThat(category.getName()).isEqualTo(food);
        assertThat(response.getLength()).isNotNull();
        assertThat(response.getLength()).isEqualTo(categories.size());
    }
}