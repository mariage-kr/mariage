package com.multi.mariage.category.service;

import com.multi.mariage.category.domain.Region;
import com.multi.mariage.category.dto.DrinkUpperCategoriesResponse;
import com.multi.mariage.category.dto.DrinkUpperCategoryResponse;
import com.multi.mariage.category.dto.DrinkUpperCategoryValuesResponse;
import com.multi.mariage.common.annotation.ServiceTest;
import org.junit.jupiter.api.*;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class DrinkUpperCategoryServiceTest {

    DrinkUpperCategoryService drinkUpperCategoryService = new DrinkUpperCategoryService();

    @DisplayName("모든 지역에 대한 상위 카테고리 조회 테스트")
    @Test
    void 상위카테고리_조회() {

        DrinkUpperCategoryResponse response = drinkUpperCategoryService.findCategories();

        assertNotNull(response);
        List<DrinkUpperCategoryValuesResponse> actual = response.getCategory();

        assertNotNull(actual);
        assertEquals(Region.values().length, actual.size());

        for (DrinkUpperCategoryValuesResponse categoryValue : actual) {
            assertNotNull(categoryValue.getRegion());
            assertNotNull(categoryValue.getCategories());
            assertFalse(categoryValue.getCategories().isEmpty());
        }
    }
    @DisplayName("특정 지역에 대한 상위 카테고리 조회 테스트")
    @Test
    void 특정_지역_필터링_상위카테고리_조회() {

        DrinkUpperCategoryResponse response = drinkUpperCategoryService.findCategories();
        String region = "국내";

        assertNotNull(response);
        List<DrinkUpperCategoryValuesResponse> categoryValues = response.getCategory();
        assertNotNull(categoryValues);

        DrinkUpperCategoryValuesResponse categoryValue = categoryValues.stream()
                .filter(cv -> region.equals(cv.getRegion()))
                .findFirst()
                .orElse(null);

        assertNotNull(categoryValue);
        assertEquals(region, categoryValue.getRegion());

        List<DrinkUpperCategoriesResponse> actual = categoryValue.getCategories();
        assertFalse(actual.isEmpty());

        for (DrinkUpperCategoriesResponse category : actual) {
            assertNotNull(category.getValue());
            assertTrue(category.getValue().contains(region));
        }
    }
}