package com.multi.mariage.review.domain;

import com.multi.mariage.common.annotation.RepositoryTest;
import com.multi.mariage.common.fixture.*;
import com.multi.mariage.member.domain.Member;
import com.multi.mariage.product.domain.Product;
import com.multi.mariage.storage.domain.Image;
import com.multi.mariage.weather.domain.Weather;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class ReviewRepositoryTest extends RepositoryTest {

    private Member member;
    private Product product;
    private Image image;
    private Weather weather;

    @BeforeEach
    void setUp() {
        image = saveImage(ImageFixture.JPEG_IMAGE);
        member = saveMember(MemberFixture.MARI);
        product = saveProduct(ProductFixture.참이슬);
        weather = saveWeather(WeatherFixture.맑음);
    }

    @DisplayName("리뷰를 저장한다.")
    @Test
    void 리뷰를_저장한다() {
        Review actual = saveReview(ReviewFixture.참이슬_과자, member, product, image, weather);

        Assertions.assertThat(actual).isNotNull();
    }
}