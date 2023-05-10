package com.multi.mariage.category.service;

import com.multi.mariage.category.dto.response.DrinkLowerCategoryResponse;
import com.multi.mariage.category.vo.DrinkLowerCategoriesVo;
import com.multi.mariage.category.vo.DrinkLowerCategoryValuesVo;
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
        List<DrinkLowerCategoryValuesVo> actual = response.getCategory();

        for (DrinkLowerCategoryValuesVo categoryValue : actual) {
            assertThat(categoryValue.getCategories()).isNotEmpty();
        }
    }

    @DisplayName("특정한 하위 카테고리를 조회한다.")
    @ParameterizedTest
    @ValueSource(strings = {"소주", "맥주", "전통주", "기타"})
    void 특정한_하위_카테고리를_조회한다(String lowerCategory) {

        String region = "국내";

        DrinkLowerCategoryResponse response = drinkLowerCategoryService.findCategories();
        assertThat(response).isNotNull();

        List<DrinkLowerCategoryValuesVo> categoryValues = response.getCategory();
        assertThat(categoryValues).isNotEmpty();

        DrinkLowerCategoryValuesVo categoryValue = categoryValues.stream()
                .filter(cv -> region.equals(cv.getRegion()))
                .findFirst()
                .orElse(null);
        assertThat(categoryValue).isNotNull();

        List<DrinkLowerCategoriesVo> subCategoryValues = categoryValue.getCategories();
        assertThat(subCategoryValues).isNotEmpty();

        DrinkLowerCategoriesVo subCategoryValue = subCategoryValues.stream()
                .filter(cv -> lowerCategory.equals(cv.getValue()))
                .findFirst()
                .orElse(null);

        assertThat(subCategoryValue).isNotNull();
        assertThat(subCategoryValue.getValue()).isEqualTo(lowerCategory);
    }
}