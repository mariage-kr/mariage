package com.multi.mariage.review.domain.query;

import com.multi.mariage.category.domain.Food;
import com.multi.mariage.common.annotation.RepositoryTest;
import com.multi.mariage.common.fixture.*;
import com.multi.mariage.member.domain.Member;
import com.multi.mariage.product.domain.Product;
import com.multi.mariage.review.domain.Review;
import com.multi.mariage.review.domain.Sort;
import com.multi.mariage.review.dto.cond.MemberReviewsPagingCond;
import com.multi.mariage.review.dto.cond.ReviewsPagingCond;
import com.multi.mariage.storage.domain.Image;
import com.multi.mariage.weather.domain.Weather;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

class ReviewRepositoryQueryTest extends RepositoryTest {
    private Product product;
    private Member member;
    private Review review1;
    private Review review2;

    @BeforeEach
    void setUp() {
        member = saveMember(MemberFixture.MARI);
        product = saveProduct(ProductFixture.참이슬);
        Food food1 = saveFood(ReviewFixture.참이슬_치킨, product);
        Food food2 = saveFood(ReviewFixture.참이슬_과자, product);
        Image image = saveImage(ImageFixture.JPEG_IMAGE);
        Weather weather = saveWeather(WeatherFixture.맑음_현재);
        review1 = saveReview(ReviewFixture.참이슬_치킨, member, product, food1, image, weather);
        review2 = saveReview(ReviewFixture.참이슬_과자, member, product, food2, image, weather);
    }

    @DisplayName("제품 리뷰를 조회한다.")
    @ParameterizedTest
    @ValueSource(ints = {1, 2})
    void 제품_리뷰를_조회한다(int size) {
        /* Given */
        ReviewsPagingCond cond = ReviewsPagingCond.builder()
                .productId(product.getId())
                .pageSize(size)
                .pageNumber(1)
                .sort(Sort.LIKE.name())
                .rate(0)
                .build();

        /* When */
        List<Review> actual = reviewRepository.findReviewsByProductId(cond);

        /* Then */
        assertThat(actual).hasSize(size);
    }

    @DisplayName("제품의 리뷰 개수를 조회한다.")
    @Test
    void 제품의_리뷰_개수를_조회한다() {
        /* Given */
        /* When */
        Long actual = reviewRepository.findReviewsCountByProductId(product.getId(), null, 0);

        /* Then */
        assertThat(actual).isEqualTo(2);
    }

    @DisplayName("사용자가 작성한 리뷰를 조회한다.")
    @ParameterizedTest
    @ValueSource(ints = {1, 2})
    void 사용자가_작성한_리뷰를_조회한다(int size) {

        MemberReviewsPagingCond cond = MemberReviewsPagingCond.builder()
                .memberId(member.getId())
                .pageSize(size)
                .pageNumber(1)
                .sort(Sort.NEWEST.name())
                .build();

        List<Review> actual = reviewRepository.findRatedReviewsByMemberId(cond);

        assertThat(actual).hasSize(size);
    }

    @DisplayName("사용자가 작성한 리뷰 개수를 조회한다.")
    @Test
    void 사용자가_작성한_리뷰_개수를_조회한다() {
        Long actual = reviewRepository.findReviewsCountByRatings(member.getId());

        assertThat(actual).isEqualTo(2);
    }

    @DisplayName("사용자가 좋아요한 리뷰를 조회한다.")
    @ParameterizedTest
    @ValueSource(ints = {1, 2})
    void 사용자가_좋아요한_리뷰를_조회한다(int size) {

        saveLike(member, review1);
        saveLike(member, review2);

        MemberReviewsPagingCond cond = MemberReviewsPagingCond.builder()
                .memberId(member.getId())
                .pageSize(size)
                .pageNumber(1)
                .sort(Sort.NEWEST.name())
                .build();

        List<Review> actual = reviewRepository.findLikedReviewsByMemberId(cond);

        assertThat(actual).hasSize(size);
    }

    @DisplayName("사용자가 좋아요한 리뷰 개수를 조회한다.")
    @Test
    void 사용자가_좋아요한_리뷰_개수를_조회한다() {
        saveLike(member, review1);
        saveLike(member, review2);

        Long actual = reviewRepository.findReviewsCountByLikes(member.getId());

        assertThat(actual).isEqualTo(2);
    }
}
