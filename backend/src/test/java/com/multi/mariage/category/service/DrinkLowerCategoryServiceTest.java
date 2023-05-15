package com.multi.mariage.category.service;

import com.multi.mariage.category.dto.response.DrinkLowerCategoryResponse;
import com.multi.mariage.category.vo.drink_lower.DrinkLowerCategoriesVO;
import com.multi.mariage.category.vo.drink_lower.DrinkLowerCategoryValuesVO;
import com.multi.mariage.common.annotation.ServiceTest;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

class DrinkLowerCategoryServiceTest extends ServiceTest {
    DrinkLowerCategoryService drinkLowerCategoryService = new DrinkLowerCategoryService();

    @DisplayName("하위 카테고리를 조회한다.")
    @Test
    void 하위_카테고리를_조회한다() {
        DrinkLowerCategoryResponse response = drinkLowerCategoryService.findCategories();

        assertThat(response).isNotNull();
        List<DrinkLowerCategoryValuesVO> actual = response.getCategory();

        for (DrinkLowerCategoryValuesVO categoryValue : actual) {
            assertThat(categoryValue.getCategories()).isNotEmpty();
        }
    }

    @DisplayName("특정한 하위 카테고리를 조회한다.")
    @ParameterizedTest
    @ValueSource(strings = {"소주", "맥주", "전통주", "기타"})
    void 특정한_하위_카테고리를_조회한다(String lowerCategory) {

        String region = "국내";

        DrinkLowerCategoryResponse response = drinkLowerCategoryService.findCategories();
        List<DrinkLowerCategoryValuesVO> categoryValues = response.getCategory();

        DrinkLowerCategoryValuesVO categoryValue = categoryValues.stream()
                .filter(cv -> region.equals(cv.getRegion()))
                .findFirst()
                .orElseThrow(RuntimeException::new);

        List<DrinkLowerCategoriesVO> subCategoryValues = categoryValue.getCategories();

        DrinkLowerCategoriesVO subCategoryValue = subCategoryValues.stream()
                .filter(cv -> lowerCategory.equals(cv.getName()))
                .findFirst()
                .orElse(null);

        assertThat(subCategoryValue).isNotNull();
        assertThat(subCategoryValue.getName()).isEqualTo(lowerCategory);
    }
}