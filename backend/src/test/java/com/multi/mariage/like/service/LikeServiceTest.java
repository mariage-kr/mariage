package com.multi.mariage.like.service;

import com.multi.mariage.auth.vo.AuthMember;
import com.multi.mariage.common.annotation.ServiceTest;
import com.multi.mariage.common.fixture.MemberFixture;
import com.multi.mariage.common.fixture.ProductFixture;
import com.multi.mariage.common.fixture.ReviewFixture;
import com.multi.mariage.member.domain.Member;
import com.multi.mariage.product.domain.Product;
import com.multi.mariage.review.dto.resonse.ReviewSaveResponse;
import com.multi.mariage.storage.domain.Image;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.assertAll;

class LikeServiceTest extends ServiceTest {
    private Member member;
    private ReviewSaveResponse review;
    private Product product;
    private ReviewFixture reviewFixture;

    @BeforeEach
    void setUp() {
        Image image1 = new Image(ProductFixture.참이슬.getImageName());
        Image image2 = new Image(ProductFixture.간바레오또상.getImageName()); // foodImage값을 ProductFixture에서 대체

        Image productImage = storageRepository.save(image1);
        Image foodImage = storageRepository.save(image2);

        member = signup(MemberFixture.MARI);
        product = saveProduct(ProductFixture.참이슬, productImage.getId());
        review = saveReview(ReviewFixture.참이슬_치킨, member.getId(), product.getId(), foodImage.getId());
    }

    @DisplayName("리뷰의 좋아요를 누른다.")
    @Test
    void 리뷰의_좋아요를_누른다() {

        Long memberId = member.getId();
        Long reviewId = review.getReviewId();
        reviewFixture = ReviewFixture.참이슬_치킨;

        likeService.save(new AuthMember(memberId), reviewFixture.toSaveLike(reviewId));

        boolean expected = likeRepository.existsByMemberIdAndReviewId(memberId, reviewId);

        Assertions.assertThat(expected).isTrue();
    }
}