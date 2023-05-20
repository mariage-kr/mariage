package com.multi.mariage.like.domain;

import com.multi.mariage.common.annotation.RepositoryTest;
import com.multi.mariage.common.fixture.*;
import com.multi.mariage.member.domain.Member;
import com.multi.mariage.product.domain.Product;
import com.multi.mariage.review.domain.Review;
import com.multi.mariage.storage.domain.Image;
import com.multi.mariage.weather.domain.Weather;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Optional;

import static org.assertj.core.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.assertAll;

class LikeRepositoryTest extends RepositoryTest {

    private Member member;
    private Product product;
    private Image image;
    private Review review;
    private Weather weather;

    @BeforeEach
    void setUp() {
        image = saveImage(ImageFixture.JPEG_IMAGE);
        member = saveMember(MemberFixture.MARI);
        product = saveProduct(ProductFixture.일품진로);
        weather = saveWeather(WeatherFixture.맑음_현재);
        review = saveReview(ReviewFixture.참이슬_치킨, member, product, image, weather);
    }

    @DisplayName("좋아요를 저장한다")
    @Test
    void 좋아요를_저장한다() {
        Like actual = saveLike(member, review);

        Assertions.assertThat(actual).isNotNull();
    }

    @DisplayName("좋아요를 누른 상태인지 확인한다")
    @Test
    void 좋아요를_누른_상태인지_확인한다() {
        saveLike(member, review);
        boolean expected = likeRepository.existsByMemberIdAndReviewId(member.getId(), review.getId());

        Assertions.assertThat(expected).isTrue();
    }

    @DisplayName("좋아요를 조회한다")
    @Test
    void 좋아요를_조회한다() {
        saveLike(member, review);
        Optional<Like> expected = likeRepository.findByMemberIdAndReviewId(member.getId(), review.getId());

        assertThat(expected).isPresent();
    }
}