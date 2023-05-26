package com.multi.mariage.review.service;

import com.multi.mariage.common.annotation.ServiceTest;
import com.multi.mariage.common.fixture.ImageFixture;
import com.multi.mariage.common.fixture.MemberFixture;
import com.multi.mariage.common.fixture.ProductFixture;
import com.multi.mariage.common.fixture.ReviewFixture;
import com.multi.mariage.member.domain.Member;
import com.multi.mariage.product.domain.Product;
import com.multi.mariage.review.domain.Review;
import com.multi.mariage.review.domain.Sort;
import com.multi.mariage.review.dto.response.MyReviewInfoResponse;
import com.multi.mariage.review.dto.response.ProductReviewsResponse;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class ReviewFindServiceTest extends ServiceTest {
    private Product product;
    private Member member;
    private Long reviewId;

    @BeforeEach
    void setUp() {
        member = signup(MemberFixture.MARI);
        Long imageId1 = saveImage(ImageFixture.JPEG_IMAGE).getImageId();
        Long imageId2 = saveImage(ImageFixture.JPEG_IMAGE2).getImageId();
        Long imageId3 = saveImage(ImageFixture.JPEG_IMAGE3).getImageId();
        product = saveProduct(ProductFixture.참이슬, imageId1);
        reviewId = saveReview(ReviewFixture.참이슬_치킨, member.getId(), product.getId(), imageId2).getReviewId();
        saveReview(ReviewFixture.참이슬_과자, member.getId(), product.getId(), imageId3);
    }

    @DisplayName("식별 번호로 조회한다.")
    @Test
    void 식별_번호로_조회한다() {
        /* Given */
        /* When */
        Review review = reviewFindService.findById(reviewId);

        /* Then */
        assertThat(review).isNotNull();
    }

    @DisplayName("제품 식별 번호로 조회한다.")
    @Test
    void 제품_식별_번호로_조회한다() {
        /* Given */
        /* When */
        ProductReviewsResponse actual = reviewFindService.findReviewsByProductId(
                product.getId(),
                member.getId(),
                1,
                10,
                Sort.NEWEST.name());

        /* Then */
        assertThat(actual.getContents()).hasSize(2);
    }

    @DisplayName("첫번째 페이지인지 확인한다.")
    @Test
    void 첫번째_페이지인지_확인한다() {
        /* Given */
        /* When */
        ProductReviewsResponse actual = reviewFindService.findReviewsByProductId(
                product.getId(),
                member.getId(),
                1,
                1,
                Sort.NEWEST.name());

        /* Then */
        assertThat(actual.isFirstPage()).isTrue();
        assertThat(actual.isLastPage()).isFalse();
    }

    @DisplayName("마지막 페이지인지 확인한다.")
    @Test
    void 마지막_페이지인지_확인한다() {
        /* Given */
        /* When */
        ProductReviewsResponse actual = reviewFindService.findReviewsByProductId(
                product.getId(),
                member.getId(),
                2,
                1,
                Sort.NEWEST.name());

        /* Then */
        assertThat(actual.isFirstPage()).isFalse();
        assertThat(actual.isLastPage()).isTrue();
    }

    @DisplayName("제품의 전체 페이지의 개수를 확인한다.")
    @Test
    void 제품의_전체_페이지_개수를_확인한다() {
        /* Given */
        /* When */
        ProductReviewsResponse actual = reviewFindService.findReviewsByProductId(
                product.getId(),
                member.getId(),
                1,
                1,
                Sort.NEWEST.name());

        /* Then */
        assertThat(actual.getTotalPages()).isEqualTo(2);
    }

    @DisplayName("해당 제품의 전체 리뷰수를 확인한다.")
    @Test
    void 해당_제품의_전체_리뷰수를_확인한다() {
        /* Given */
        /* When */
        ProductReviewsResponse actual = reviewFindService.findReviewsByProductId(
                product.getId(),
                member.getId(),
                2,
                1,
                Sort.NEWEST.name());

        /* Then */
        assertThat(actual.getTotalCount()).isEqualTo(2);
    }

    @DisplayName("회원이 본인의 리뷰를 조회한다.")
    @Test
    void 회원이_본인의_리뷰를_조회한다() {
        Member member2 = signup(MemberFixture.SURI);
        Long imageId = saveImage(ImageFixture.JPEG_IMAGE3).getImageId();
        saveReview(ReviewFixture.참이슬_과자, member2.getId(), product.getId(), imageId);
        saveReview(ReviewFixture.산토리위스키_치즈, member.getId(), product.getId(), imageId);
        saveReview(ReviewFixture.산토리위스키_해산물, member.getId(), product.getId(), imageId);
        saveReview(ReviewFixture.산토리위스키_과자, member.getId(), product.getId(), imageId);

        MyReviewInfoResponse actual = reviewFindService.findProductsAndReviewsByMemberId(
                member.getId(),
                1,
                1,
                Sort.NEWEST.name());

        assertThat(actual.getContents()).hasSize(5);
    }
}