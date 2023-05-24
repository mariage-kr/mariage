package com.multi.mariage.category.domain;

import com.multi.mariage.common.annotation.RepositoryTest;
import com.multi.mariage.common.fixture.*;
import com.multi.mariage.member.domain.Member;
import com.multi.mariage.product.domain.Product;
import com.multi.mariage.review.domain.Review;
import com.multi.mariage.storage.domain.Image;
import com.multi.mariage.weather.domain.Weather;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;
import java.util.Optional;

import static org.assertj.core.api.Assertions.assertThat;

class FoodRepositoryTest extends RepositoryTest {

    private Product product;
    private Review review;

    @BeforeEach
    void setUp() {
        product = saveProduct(ProductFixture.참이슬);
        Member member = saveMember(MemberFixture.MARI);
        Image image = saveImage(ImageFixture.JPEG_IMAGE);
        Weather weather = saveWeather(WeatherFixture.맑음_현재);
        Food food = saveFood(ReviewFixture.참이슬_치킨, product);
        review = saveReview(ReviewFixture.참이슬_치킨, member, product, food, image, weather);
    }

    @DisplayName("음식 카테고리와 제품으로 조회한다.")
    @Test
    void 음식_카테고리와_제품으로_조회한다() {
        Optional<Food> actual = foodRepository.findByCategoryAndProduct(
                review.getFoodCategory().getCategory(),
                product);

        assertThat(actual).isNotEmpty();
    }

    @DisplayName("제품 식별 번호로 조회한다.")
    @Test
    void 제품_식별_번호로_조회한다() {
        List<Food> foods = foodRepository.findByProductId(product.getId(), 3);

        /* 리뷰를 1개만 등록하여 1개의 결과만 조회 */
        assertThat(foods).hasSize(1);
    }
}