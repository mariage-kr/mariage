package com.multi.mariage.category.service;

import com.multi.mariage.category.domain.Food;
import com.multi.mariage.category.domain.FoodCategory;
import com.multi.mariage.category.dto.response.FoodCategoryResponse;
import com.multi.mariage.category.vo.food.FoodCategoriesVO;
import com.multi.mariage.common.annotation.ServiceTest;
import com.multi.mariage.common.fixture.ImageFixture;
import com.multi.mariage.common.fixture.ProductFixture;
import com.multi.mariage.product.domain.Product;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import java.util.List;
import java.util.Objects;

import static org.assertj.core.api.Assertions.assertThat;

class FoodCategoryServiceTest extends ServiceTest {

    private Product product;

    @BeforeEach
    void setUp() {
        product = saveProduct(ProductFixture.참이슬, saveImage(ImageFixture.JPEG_IMAGE).getImageId());
    }

    @DisplayName("카테고리를 조회한다.")
    @Test
    void 카테고리를_조회한다() {

        FoodCategoryResponse response = foodCategoryService.findFoodCategories();

        assertThat(response).isNotNull();
        List<FoodCategoriesVO> vo = response.getCategory();

        for (FoodCategoriesVO actual : vo) {
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

        assertThat(Objects.requireNonNull(category).getName()).isEqualTo(food);
        assertThat(response.getLength()).isEqualTo(categories.size());
    }

    @DisplayName("제품에 음식 카테고리 저장 및 조회한다.")
    @Test
    void 제품에_음식_카테고리를_저장_및_조회한다() {
        // given
        // when
        Food actual = foodCategoryService.findProductWithCategory(FoodCategory.ROAST, product);

        // then
        assertThat(actual.getCategory()).isEqualTo(FoodCategory.ROAST);
    }
}