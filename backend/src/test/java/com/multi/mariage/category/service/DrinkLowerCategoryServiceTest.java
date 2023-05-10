package com.multi.mariage.category.service;

import com.multi.mariage.category.domain.Region;
import com.multi.mariage.category.dto.DrinkLowerCategoriesResponse;
import com.multi.mariage.category.dto.DrinkLowerCategoryResponse;
import com.multi.mariage.category.dto.DrinkLowerCategoryValuesResponse;
import com.multi.mariage.category.dto.DrinkUpperCategoryValuesResponse;
import com.multi.mariage.common.annotation.ServiceTest;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

class DrinkLowerCategoryServiceTest extends ServiceTest {
    DrinkLowerCategoryService drinkLowerCategoryService = new DrinkLowerCategoryService();

    @DisplayName("하위 카테고리를 조회한다.")
    @Test
    void 하위_카테고리를_조회한다() {
        DrinkLowerCategoryResponse response = drinkLowerCategoryService.findCategories();

        assertThat(response).isNotNull();
        List<DrinkLowerCategoryValuesResponse> actual = response.getCategory();

        for (DrinkLowerCategoryValuesResponse categoryValue : actual) {
            assertThat(categoryValue.getCategories()).isNotEmpty();
        }
    }
}