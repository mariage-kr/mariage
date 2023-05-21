package com.multi.mariage.like.service;

import com.multi.mariage.auth.vo.AuthMember;
import com.multi.mariage.common.annotation.ServiceTest;
import com.multi.mariage.common.fixture.MemberFixture;
import com.multi.mariage.common.fixture.ProductFixture;
import com.multi.mariage.common.fixture.ReviewFixture;
import com.multi.mariage.member.domain.Member;
import com.multi.mariage.product.domain.Product;
import com.multi.mariage.review.domain.Review;
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
    private Member user1;
    private Member user2;
    private Member user3;
    private ReviewSaveResponse review;
    private Product product;
    private ReviewFixture reviewFixture;

    @BeforeEach
    void setUp() {
        Image image1 = new Image(ProductFixture.참이슬.getImageName());
        Image image2 = new Image(ProductFixture.간바레오또상.getImageName()); // foodImage값을 ProductFixture에서 대체

        Image productImage = storageRepository.save(image1);
        Image foodImage = storageRepository.save(image2);

        member = signup(MemberFixture.MARI);    // 리뷰를 작성한 사용자
        user1 = signup(MemberFixture.SURI);     // 일반 사용자1
        user2 = signup(MemberFixture.HARI);     // 일반 사용자2
        user3 = signup(MemberFixture.DORI);     // 일반 사용자3
        product = saveProduct(ProductFixture.참이슬, productImage.getId());    // 리뷰가 작성된 제품
        review = saveReview(ReviewFixture.참이슬_치킨, member.getId(), product.getId(), foodImage.getId());  // 제품에 대한 리뷰
    }

    @DisplayName("리뷰의 좋아요를 누른다.")
    @Test
    void 리뷰의_좋아요를_누른다() {

        Long memberId = user1.getId();
        Long reviewId = review.getReviewId();
        reviewFixture = ReviewFixture.참이슬_치킨;

        likeService.save(new AuthMember(memberId), reviewFixture.toSaveLike(reviewId));

        boolean expected = likeRepository.existsByMemberIdAndReviewId(memberId, reviewId);

        Assertions.assertThat(expected).isTrue();
    }

    @DisplayName("리뷰의 좋아요를 취소한다.")
    @Test
    void 리뷰의_좋아요를_취소한다() {

        Long memberId = user1.getId();
        Long reviewId = review.getReviewId();
        reviewFixture = ReviewFixture.참이슬_치킨;

        likeService.save(new AuthMember(memberId), reviewFixture.toSaveLike(reviewId));
        likeService.remove(new AuthMember(memberId), reviewFixture.toRemoveLike(reviewId));

        boolean expected = likeRepository.existsByMemberIdAndReviewId(memberId, reviewId);

        Assertions.assertThat(expected).isFalse();
    }

    @DisplayName("사용자가 리뷰의 좋아요를 취소할 때 사용자의 리스트에서도 삭제되는지 확인한다.")
    @Test
    void 사용자가_리뷰의_좋아요를_취소할_때_사용자의_리스트에서도_삭제되는지_확인한다() {

        Long userId1 = user1.getId();
        Long userId2 = user2.getId();
        Long reviewId = review.getReviewId();
        reviewFixture = ReviewFixture.참이슬_치킨;

        likeService.save(new AuthMember(userId1), reviewFixture.toSaveLike(reviewId));
        likeService.save(new AuthMember(userId2), reviewFixture.toSaveLike(reviewId));
        likeService.remove(new AuthMember(userId1), reviewFixture.toRemoveLike(reviewId));

        int expected = user2.getLikes().size();
        Assertions.assertThat(expected).isEqualTo(1);

    }

    @DisplayName("사용자가 리뷰의 좋아요를 취소할 때 리뷰가 받은 좋아요도 삭제되는지 확인한다.")
    @Test
    void 사용자가_리뷰의_좋아요를_취소할_때_리뷰가_받은_좋아요도_삭제되는지_확인한다() {

        Long userId1 = user1.getId();
        Long userId2 = user2.getId();
        Long userId3 = user3.getId();
        Long reviewId = review.getReviewId();
        reviewFixture = ReviewFixture.참이슬_치킨;

        likeService.save(new AuthMember(userId1), reviewFixture.toSaveLike(reviewId));
        likeService.save(new AuthMember(userId2), reviewFixture.toSaveLike(reviewId));
        likeService.save(new AuthMember(userId3), reviewFixture.toSaveLike(reviewId));
        likeService.remove(new AuthMember(userId1), reviewFixture.toRemoveLike(reviewId));

        Review review = reviewRepository.findById(reviewId).orElseThrow();

        int reviewLike = findReviewLike(reviewId);
        int expected = review.getLikes().size();

        Assertions.assertThat(reviewLike).isEqualTo(2);
        Assertions.assertThat(expected).isEqualTo(2);
    }
}