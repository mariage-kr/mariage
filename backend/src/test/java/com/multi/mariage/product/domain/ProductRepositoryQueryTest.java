package com.multi.mariage.product.domain;


import com.multi.mariage.common.annotation.RepositoryTest;
import com.multi.mariage.common.fixture.*;
import com.multi.mariage.member.domain.Member;
import com.multi.mariage.storage.domain.Image;
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

    @BeforeEach
    void setUp() {
        참이슬 = saveProduct(ProductFixture.참이슬);
        처음처럼 = saveProduct(ProductFixture.처음처럼);
        간바레오또상 = saveProduct(ProductFixture.간바레오또상);
        일품진로 = saveProduct(ProductFixture.일품진로);
        산토리_위스키 = saveProduct(ProductFixture.산토리_위스키);
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
    void 전체기간_동안_가장_많은_리뷰가_달린_제품들을_조회한다(int pageSize) {
        Member member = saveMember(MemberFixture.MARI);
        Image image1 = saveImage(ImageFixture.JPEG_IMAGE);
        Image image2 = saveImage(ImageFixture.JPEG_IMAGE2);
        Weather weather = saveWeather(WeatherFixture.맑음);
        saveReview(ReviewFixture.참이슬_과자, member, 참이슬, image1, weather);
        saveReview(ReviewFixture.산토리위스키_해산물, member, 산토리_위스키, image2, weather);

        List<Product> actual = productRepository.findTotal(pageSize);

        assertThat(actual).hasSize(pageSize);
    }

    @DisplayName("전체기간 동안 가장 많은 리뷰가 달린 제품만 조회한다.")
    @ParameterizedTest
    @ValueSource(ints = {2})
    void 전체기간_동안_리뷰가_달린_제품만_조회한다(int pageSize) {
        Member member = saveMember(MemberFixture.MARI);
        Image image1 = saveImage(ImageFixture.JPEG_IMAGE);
        Image image2 = saveImage(ImageFixture.JPEG_IMAGE2);
        Weather weather = saveWeather(WeatherFixture.맑음);
        saveReview(ReviewFixture.참이슬_과자, member, 참이슬, image1, weather);
        saveReview(ReviewFixture.참이슬_치킨, member, 참이슬, image2, weather);

        List<Product> actual = productRepository.findTotal(pageSize);

        assertThat(actual).hasSize(1);
    }
}