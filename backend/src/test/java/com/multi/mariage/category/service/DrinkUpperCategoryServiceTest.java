package com.multi.mariage.category.service;

import com.multi.mariage.category.domain.Region;
import com.multi.mariage.category.dto.DrinkUpperCategoriesResponse;
import com.multi.mariage.category.dto.DrinkUpperCategoryResponse;
import com.multi.mariage.category.dto.DrinkUpperCategoryValuesResponse;
import com.multi.mariage.common.annotation.ServiceTest;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

class DrinkUpperCategoryServiceTest extends ServiceTest {

    DrinkUpperCategoryService drinkUpperCategoryService = new DrinkUpperCategoryService();

    @DisplayName("모든 지역에 대한 상위 카테고리 조회 테스트")
    @Test
    void 상위카테고리_조회() {

        DrinkUpperCategoryResponse response = drinkUpperCategoryService.findCategories();

        Assertions.assertThat(response).isNotNull();
        Assertions.assertThat(response.getCategory()).isNotNull().hasSize(Region.values().length);
        List<DrinkUpperCategoryValuesResponse> actual = response.getCategory();

        for (DrinkUpperCategoryValuesResponse categoryValue : actual) {
            Assertions.assertThat(categoryValue.getRegion()).isNotNull();
            Assertions.assertThat(categoryValue.getCategories()).isNotNull().isNotEmpty();
        }
    }

    @DisplayName("특정 지역에 대한 상위 카테고리 조회 테스트")
    @Test
    void 특정_지역_필터링_상위카테고리_조회() {

        DrinkUpperCategoryResponse response = drinkUpperCategoryService.findCategories();
        String region = "국내";

        Assertions.assertThat(response).isNotNull();
        List<DrinkUpperCategoryValuesResponse> categoryValues = response.getCategory();
        Assertions.assertThat(categoryValues).isNotNull();

        DrinkUpperCategoryValuesResponse categoryValue = categoryValues.stream()
                .filter(cv -> region.equals(cv.getRegion()))
                .findFirst()
                .orElse(null);

        Assertions.assertThat(categoryValue).isNotNull();
        Assertions.assertThat(categoryValue.getRegion()).isEqualTo(region);

        List<DrinkUpperCategoriesResponse> actual = categoryValue.getCategories();
        Assertions.assertThat(actual).isNotEmpty();

        for (DrinkUpperCategoriesResponse category : actual) {
            Assertions.assertThat(category.getValue()).isNotNull();
            Assertions.assertThat(category.getValue()).contains(region);
        }
    }
}