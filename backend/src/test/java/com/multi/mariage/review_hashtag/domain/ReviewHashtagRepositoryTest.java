package com.multi.mariage.review_hashtag.domain;

import com.multi.mariage.common.annotation.RepositoryTest;
import com.multi.mariage.common.fixture.*;
import com.multi.mariage.hashtag.domain.Hashtag;
import com.multi.mariage.member.domain.Member;
import com.multi.mariage.product.domain.Product;
import com.multi.mariage.review.domain.Review;
import com.multi.mariage.review.domain.ReviewHashtag;
import com.multi.mariage.storage.domain.Image;
import com.multi.mariage.weather.domain.Weather;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertAll;

class ReviewHashtagRepositoryTest extends RepositoryTest {

    private Member member;
    private Product product;
    private Image image;
    private Weather weather;
    private Review review;
    private Hashtag hashtag;

    @BeforeEach
    void setUp() {
        ReviewFixture 참이슬과자 = ReviewFixture.참이슬_과자;

        member = saveMember(MemberFixture.MARI);
        product = saveProduct(ProductFixture.참이슬);
        image = saveImage(ImageFixture.JPEG_IMAGE);
        weather = saveWeather(WeatherFixture.맑음_현재);
        review = saveReview(참이슬과자, member, product, saveFood(참이슬과자, product), image, weather);
        hashtag = saveHashtag(참이슬과자.getHashtags().get(0));
    }

    @DisplayName("해시태그와 리뷰의 연관관계를 저장한다")
    @Test
    void 해시태그와_리뷰의_연관관계를_저장한다() {
        ReviewHashtag reviewHashtag = new ReviewHashtag();
        reviewHashtag.setHashtag(hashtag);
        reviewHashtag.setReview(review);

        ReviewHashtag actual = reviewHashtagRepository.save(reviewHashtag);

        assertAll(
                () -> assertThat(actual).isNotNull(),
                () -> assertThat(actual.getHashtag()).isEqualTo(hashtag),
                () -> assertThat(actual.getReview()).isEqualTo(review)
        );
    }
}
