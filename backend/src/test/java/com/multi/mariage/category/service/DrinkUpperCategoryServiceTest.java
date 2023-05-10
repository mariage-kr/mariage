package com.multi.mariage.category.service;

import com.multi.mariage.category.domain.Region;
import com.multi.mariage.category.vo.drinkupper.DrinkUpperCategoriesVO;
import com.multi.mariage.category.dto.response.DrinkUpperCategoryResponse;
import com.multi.mariage.category.vo.drinkupper.DrinkUpperCategoryValuesVO;
import com.multi.mariage.common.annotation.ServiceTest;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import java.util.List;

import static org.assertj.core.api.Assertions.*;

class DrinkUpperCategoryServiceTest extends ServiceTest {

    DrinkUpperCategoryService drinkUpperCategoryService = new DrinkUpperCategoryService();

    @DisplayName("상위 카테고리를 조회한다.")
    @Test
    void 상위_카테고리를_조회한다() {

        DrinkUpperCategoryResponse response = drinkUpperCategoryService.findCategories();

        assertThat(response).isNotNull();
        assertThat(response.getCategory()).isNotNull().hasSize(Region.values().length);
        List<DrinkUpperCategoryValuesVO> actual = response.getCategory();

        for (DrinkUpperCategoryValuesVO categoryValue : actual) {
            assertThat(categoryValue.getRegion()).isNotNull();
            assertThat(categoryValue.getCategories()).isNotEmpty();
        }
    }

    @DisplayName("특정 지역의 상위 카테고리를 조회한다.")
    @ParameterizedTest
    @ValueSource(strings = {"LOCAL", "FOREIGN"})
    void 특정_지역의_상위_카테고리를_조회한다(String region) {

        DrinkUpperCategoryResponse response = drinkUpperCategoryService.findCategories();

        List<DrinkUpperCategoryValuesVO> categoryValues = response.getCategory();

        DrinkUpperCategoryValuesVO categoryValue = categoryValues.stream()
                .filter(cv -> region.equals(cv.getRegionValue()))
                .findFirst()
                .orElse(null);

        assertThat(categoryValue).isNotNull();
        assertThat(categoryValue.getRegionValue()).isEqualTo(region);

        for (DrinkUpperCategoriesVO category : categoryValue.getCategories()) {
            assertThat(category.getName()).contains(region);
        }
    }
}