package com.multi.mariage.product.domain.query;


import com.multi.mariage.category.domain.DrinkLowerCategory;
import com.multi.mariage.category.domain.DrinkUpperCategory;
import com.multi.mariage.common.annotation.RepositoryTest;
import com.multi.mariage.common.fixture.*;
import com.multi.mariage.member.domain.Member;
import com.multi.mariage.product.domain.Product;
import com.multi.mariage.product.dto.condition.RecommendCond;
import com.multi.mariage.product.dto.request.ProductFindByFilterRequest;
import com.multi.mariage.weather.domain.Weather;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

@DataJpaTest
class ProductRepositoryQueryTest extends RepositoryTest {
    private Product 참이슬;
    private Product 처음처럼;
    private Product 간바레오또상;
    private Product 일품진로;
    private Product 산토리_위스키;
    private Member 마리;

    @BeforeEach
    void setUp() {
        참이슬 = saveProduct(ProductFixture.참이슬);
        처음처럼 = saveProduct(ProductFixture.처음처럼);
        간바레오또상 = saveProduct(ProductFixture.간바레오또상);
        일품진로 = saveProduct(ProductFixture.일품진로);
        산토리_위스키 = saveProduct(ProductFixture.산토리_위스키);

        마리 = saveMember(MemberFixture.MARI);
    }

    @DisplayName("제품을 검색한다.")
    @Test
    void 제품을_검색한다() {
        List<Product> actual = productRepository.searchProductByName("진로");

        assertThat(actual).contains(일품진로);
    }

    @DisplayName("전체기간 동안 가장 많은 리뷰가 달린 제품들을 조회한다.")
    @ParameterizedTest
    @ValueSource(ints = {2})
    void 전체기간_동안_가장_많은_리뷰가_달린_제품들을_조회한다(int size) {
        /* Given */
        Weather weather = saveWeather(WeatherFixture.맑음_현재);
        saveReview(ReviewFixture.참이슬_과자, 마리, 참이슬,
                saveFood(ReviewFixture.참이슬_치킨, 참이슬),
                saveImage(ImageFixture.JPEG_IMAGE), weather);
        saveReview(ReviewFixture.산토리위스키_해산물, 마리, 산토리_위스키,
                saveFood(ReviewFixture.산토리위스키_해산물, 산토리_위스키),
                saveImage(ImageFixture.JPEG_IMAGE2), weather);

        RecommendCond cond = RecommendCond.builder()
                .size(size)
                .option("total")
                .build();

        /* When */
        List<Product> actual = productRepository.findRecommendProductsByDate(cond);

        /* Then */
        assertThat(actual).hasSize(size);
    }

    @DisplayName("전체기간 동안 가장 많은 리뷰가 달린 제품만 조회한다.")
    @ParameterizedTest
    @ValueSource(ints = {2})
    void 전체기간_동안_리뷰가_달린_제품만_조회한다(int size) {
        /* Given */
        Weather weather = saveWeather(WeatherFixture.맑음_현재);

        saveReview(ReviewFixture.참이슬_과자, 마리, 참이슬,
                saveFood(ReviewFixture.참이슬_과자, 참이슬),
                saveImage(ImageFixture.JPEG_IMAGE), weather);
        saveReview(ReviewFixture.참이슬_치킨, 마리, 참이슬,
                saveFood(ReviewFixture.참이슬_치킨, 참이슬),
                saveImage(ImageFixture.JPEG_IMAGE2), weather);

        RecommendCond cond = RecommendCond.builder()
                .size(size)
                .option("month")
                .build();

        /* When */
        List<Product> actual = productRepository.findRecommendProductsByDate(cond);

        /* Then */
        assertThat(actual).hasSize(1);
    }

    @DisplayName("일주일 동안 가장 많은 리뷰가 달린 제품을 조회한다.")
    @ParameterizedTest
    @ValueSource(ints = {2})
    void 일주일_동안_가장_많은_리뷰가_달린_제품을_조회한다(int size) {
        /* Given */
        saveReview(ReviewFixture.참이슬_과자, 마리, 참이슬,
                saveFood(ReviewFixture.참이슬_과자, 참이슬),
                saveImage(ImageFixture.JPEG_IMAGE),
                saveWeather(WeatherFixture.맑음_현재));
        saveReview(ReviewFixture.산토리위스키_해산물, 마리, 산토리_위스키,
                saveFood(ReviewFixture.산토리위스키_해산물, 산토리_위스키),
                saveImage(ImageFixture.JPEG_IMAGE2),
                saveWeather(WeatherFixture.맑음_2주전));

        RecommendCond cond = RecommendCond.builder()
                .size(size)
                .option("week")
                .build();

        /* When */
        List<Product> actual = productRepository.findRecommendProductsByDate(cond);

        /* Then */
        assertThat(actual).hasSize(1);
    }

    @DisplayName("한달 동안 가장 많은 리뷰가 달린 제품을 조회한다.")
    @ParameterizedTest
    @ValueSource(ints = {2})
    void 한달_동안_가장_많은_리뷰가_달린_제품을_조회한다(int size) {
        /* Given */
        saveReview(ReviewFixture.참이슬_과자, 마리, 참이슬,
                saveFood(ReviewFixture.참이슬_과자, 참이슬),
                saveImage(ImageFixture.JPEG_IMAGE),
                saveWeather(WeatherFixture.맑음_현재));
        saveReview(ReviewFixture.산토리위스키_해산물, 마리, 산토리_위스키,
                saveFood(ReviewFixture.산토리위스키_해산물, 산토리_위스키),
                saveImage(ImageFixture.JPEG_IMAGE2),
                saveWeather(WeatherFixture.맑음_2달전));

        RecommendCond cond = RecommendCond.builder()
                .size(size)
                .option("month")
                .build();

        /* When */
        List<Product> actual = productRepository.findRecommendProductsByDate(cond);

        /* Then */
        assertThat(actual).hasSize(1);
    }

    @DisplayName("해당 날씨에 가장 많은 리뷰가 달린 제품을 조회한다.")
    @ParameterizedTest
    @ValueSource(ints = {2})
    void 해당_날씨에_가장_많은_리뷰가_달린_제품을_조회한다(int size) {
        /* Given */
        saveReview(ReviewFixture.참이슬_과자, 마리, 참이슬,
                saveFood(ReviewFixture.참이슬_과자, 참이슬),
                saveImage(ImageFixture.JPEG_IMAGE),
                saveWeather(WeatherFixture.맑음_현재));
        saveReview(ReviewFixture.산토리위스키_해산물, 마리, 산토리_위스키,
                saveFood(ReviewFixture.산토리위스키_해산물, 산토리_위스키),
                saveImage(ImageFixture.JPEG_IMAGE2),
                saveWeather(WeatherFixture.비_현재));

        /* When */
        List<Product> actual = productRepository.findRecommendProductsByWeather(size, WeatherFixture.맑음_현재.toWeather());

        /* Then */
        assertThat(actual).hasSize(1);
    }

    @DisplayName("필터링 조건으로 제품을 조회한다.")
    @Test
    void 필터링_조건으로_제품을_조회한다() {
        /* Given */
        ProductFindByFilterRequest cond = ProductFindByFilterRequest.builder()
                .pageNumber(1)
                .pageSize(2)
                .upperCategory(DrinkUpperCategory.LOCAL_SOJU)
                .lowerCategory(DrinkLowerCategory.NORMAL_SOJU)
                .sort("count")
                .minRate(0)
                .maxRate(5)
                .minLevel(15)
                .maxLevel(20)
                .build();

        /* when */
        List<Product> actual = productRepository.findProductsByFilter(cond);

        /* Then */
        assertThat(actual).hasSize(2);
        actual.forEach(product -> assertThat(product.getName())
                .containsAnyOf(참이슬.getName(), 처음처럼.getName()));
    }

    @DisplayName("필터링 조건에 해당하는 제품의 총 개수를 조회한다.")
    @Test
    void 필터링_조건에_해당하는_제품의_총_개수를_조회한다() {
        /* Given */
        ProductFindByFilterRequest cond = ProductFindByFilterRequest.builder()
                .pageNumber(1)
                .pageSize(2)
                .sort("count")
                .minRate(0)
                .maxRate(5)
                .minLevel(30)
                .maxLevel(70)
                .build();

        /* when - 산토리 위스키 */
        Long actual = productRepository.countProductWithFilter(cond);

        /* Then */
        assertThat(actual).isEqualTo(1);
    }
}