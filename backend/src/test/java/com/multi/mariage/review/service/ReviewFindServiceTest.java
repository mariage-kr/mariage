package com.multi.mariage.review.service;

import com.multi.mariage.auth.vo.AuthMember;
import com.multi.mariage.common.annotation.ServiceTest;
import com.multi.mariage.common.fixture.ImageFixture;
import com.multi.mariage.common.fixture.MemberFixture;
import com.multi.mariage.common.fixture.ProductFixture;
import com.multi.mariage.common.fixture.ReviewFixture;
import com.multi.mariage.member.domain.Member;
import com.multi.mariage.product.domain.Product;
import com.multi.mariage.review.domain.Review;
import com.multi.mariage.review.domain.Sort;
import com.multi.mariage.review.dto.request.ReviewDetailRequest;
import com.multi.mariage.review.dto.request.ReviewFindRequest;
import com.multi.mariage.review.dto.response.MemberProfileResponse;
import com.multi.mariage.review.dto.response.MemberReviewInfoResponse;
import com.multi.mariage.review.dto.response.ProductReviewsResponse;
import com.multi.mariage.review.dto.response.ReviewSaveResponse;
import com.multi.mariage.review.vo.member.MemberReviewVO;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertEquals;

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
                ReviewDetailRequest.builder()
                        .memberId(member.getId())
                        .pageNumber(1)
                        .pageSize(10)
                        .sort(Sort.NEWEST.name())
                        .build());

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
                ReviewDetailRequest.builder()
                        .memberId(member.getId())
                        .pageNumber(1)
                        .pageSize(10)
                        .sort(Sort.NEWEST.name())
                        .build());

        /* Then */
        assertThat(actual.isFirstPage()).isTrue();
    }

    @DisplayName("마지막 페이지인지 확인한다.")
    @Test
    void 마지막_페이지인지_확인한다() {
        /* Given */
        /* When */
        ProductReviewsResponse actual = reviewFindService.findReviewsByProductId(
                product.getId(),
                ReviewDetailRequest.builder()
                        .memberId(member.getId())
                        .pageNumber(1)
                        .pageSize(2)
                        .sort(Sort.NEWEST.name())
                        .build());

        /* Then */
        assertThat(actual.isLastPage()).isTrue();
    }

    @DisplayName("제품의 전체 페이지의 개수를 확인한다.")
    @Test
    void 제품의_전체_페이지_개수를_확인한다() {
        /* Given */
        /* When */
        ProductReviewsResponse actual = reviewFindService.findReviewsByProductId(
                product.getId(),
                ReviewDetailRequest.builder()
                        .memberId(member.getId())
                        .pageNumber(1)
                        .pageSize(1)
                        .sort(Sort.NEWEST.name())
                        .build());

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
                ReviewDetailRequest.builder()
                        .memberId(member.getId())
                        .pageNumber(1)
                        .pageSize(2)
                        .sort(Sort.NEWEST.name())
                        .build());

        /* Then */
        assertThat(actual.getTotalCount()).isEqualTo(2);
    }

    @DisplayName("사용자의 리뷰를 조회한다.")
    @Test
    void 사용자의_리뷰를_조회한다() {
        Member member2 = signup(MemberFixture.SURI);
        Long imageId = saveImage(ImageFixture.JPEG_IMAGE3).getImageId();
        Product product2 = saveProduct(ProductFixture.산토리_위스키, imageId);
        saveReview(ReviewFixture.참이슬_과자, member2.getId(), product.getId(), imageId);
        saveReview(ReviewFixture.산토리위스키_치즈, member2.getId(), product2.getId(), imageId);
        saveReview(ReviewFixture.산토리위스키_해산물, member2.getId(), product2.getId(), imageId);
        saveReview(ReviewFixture.산토리위스키_과자, member2.getId(), product2.getId(), imageId);
        ReviewFindRequest cond = ReviewFindRequest.builder()
                .pageNumber(1)
                .pageSize(4)
                .build();

        MemberReviewInfoResponse actual = reviewFindService.findProductsAndRatedReviewsByMemberId(member2.getId(), cond);

        assertThat(actual).isNotNull();
        assertThat(actual.getContents()).hasSize(4);

        List<MemberReviewVO> memberReviews = actual.getContents();

        MemberReviewVO productInfo = memberReviews.stream()
                .filter(r -> product.getName().equals(r.getProductInfo().getName()))
                .findFirst()
                .orElse(null);

        MemberReviewVO reviewInfo = memberReviews.stream()
                .filter(r -> member2.getNickname().equals(r.getReviewInfo().getMember().getNickname()))
                .findFirst()
                .orElse(null);

        assertEquals("참이슬", productInfo.getProductInfo().getName());
        assertEquals("수리", reviewInfo.getReviewInfo().getMember().getNickname());
    }

    @DisplayName("사용자가 좋아요한 리뷰를 조회한다.")
    @Test
    void 사용자가_좋아요한_리뷰를_조회한다() {
        Member member2 = signup(MemberFixture.SURI);
        Long imageId = saveImage(ImageFixture.JPEG_IMAGE3).getImageId();
        Product product2 = saveProduct(ProductFixture.산토리_위스키, imageId);
        ReviewSaveResponse review1 = saveReview(ReviewFixture.참이슬_과자, member.getId(), product.getId(), imageId);
        ReviewSaveResponse review2 = saveReview(ReviewFixture.산토리위스키_치즈, member.getId(), product2.getId(), imageId);
        ReviewSaveResponse review3 = saveReview(ReviewFixture.산토리위스키_해산물, member.getId(), product2.getId(), imageId);

        likeService.save(new AuthMember(member2.getId()), ReviewFixture.참이슬_과자.toSaveLike(review1.getReviewId()));
        likeService.save(new AuthMember(member2.getId()), ReviewFixture.산토리위스키_치즈.toSaveLike(review2.getReviewId()));
        likeService.save(new AuthMember(member2.getId()), ReviewFixture.산토리위스키_해산물.toSaveLike(review3.getReviewId()));
        ReviewFindRequest cond = ReviewFindRequest.builder()
                .pageNumber(1)
                .pageSize(3)
                .build();

        MemberReviewInfoResponse actual = reviewFindService.findProductsAndLikedReviewsByMemberId(member2.getId(), cond);

        assertThat(actual).isNotNull();
        assertThat(actual.getContents()).hasSize(3);

        List<MemberReviewVO> memberLikedReviews = actual.getContents();

        MemberReviewVO reviewInfo = memberLikedReviews.stream()
                .filter(r -> member.getNickname().equals(r.getReviewInfo().getMember().getNickname()))
                .findFirst()
                .orElse(null);

        assertEquals("마리", reviewInfo.getReviewInfo().getMember().getNickname());   // 리뷰를 작성한 사용자의 닉네임 확인
        assertEquals(1, reviewInfo.getReviewInfo().getLike().getCount());            // 해당 리뷰가 받은 좋아요 개수 정보 확인
    }

    @DisplayName("사용자의 프로필을 조회한다.")
    @Test
    void 사용자의_프로필을_조회한다() {
        Member member2 = signup(MemberFixture.SURI);
        Long imageId = saveImage(ImageFixture.JPEG_IMAGE3).getImageId();
        ReviewSaveResponse review1 = saveReview(ReviewFixture.참이슬_과자, member2.getId(), product.getId(), imageId);
        likeService.save(new AuthMember(member2.getId()), ReviewFixture.산토리위스키_치즈.toSaveLike(review1.getReviewId()));

        MemberProfileResponse actual = reviewFindService.findMemberProfile(member2.getId());

        assertThat(actual).isNotNull();
        assertThat(actual.getEmail()).isEqualTo("suri2");
        assertThat(actual.getNickname()).isEqualTo("수리");
        assertThat(actual.getReviews()).isEqualTo(1);
        assertThat(actual.getLikes()).isEqualTo(1);
    }
}