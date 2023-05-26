 package com.multi.mariage.review_hashtag.service;

 import com.multi.mariage.common.annotation.ServiceTest;
import com.multi.mariage.common.fixture.ImageFixture;
import com.multi.mariage.common.fixture.MemberFixture;
import com.multi.mariage.common.fixture.ProductFixture;
import com.multi.mariage.common.fixture.ReviewFixture;
import com.multi.mariage.member.domain.Member;
import com.multi.mariage.product.domain.Product;
 import com.multi.mariage.review.domain.Review;
 import com.multo.mariage.review_hashtag.service.ReviewHashtagService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

 import java.util.LinkedList;
 import java.util.List;

class ReviewHashtagServiceTest extends ServiceTest {

     private Long reviewId;
     private ReviewFixture reviewFixture;
     private ReviewHashtagService reviewHashtagService;
     private Review review;

    @BeforeEach
    void setUp() {
        reviewFixture = ReviewFixture.참이슬_과자;

        Member member = signup(MemberFixture.MARI);
        Long imageId = saveImage(ImageFixture.JPEG_IMAGE).getImageId();
        Product product = saveProduct(ProductFixture.참이슬, imageId);

         reviewFixture.addHashTag(new HashTag("태그1"));
         reviewFixture.addHashTag(new HashTag("태그2"));
         reviewId = saveReview(reviewFixture, member.getId(), product.getId(), imageId).getReviewId();

    }

    @DisplayName("해시태그와 리뷰의 연관관계를 저장한다.")
    @Test
    void 해시태그와_리뷰의_연관관계를_저장한다() {
        /* TODO: 2023/05/18 추후 FindService 로 수정 */
        Review review = reviewRepository.findById(reviewId)
                .orElseThrow(RuntimeException::new);

        reviewHashtagService.saveAll(reviewFixture.getHashtags(), review);
    }

    @DisplayName("해시태그와 리뷰의 연관관계를 삭제한다.")
    @Test
    void 해시태그와_리뷰의_연관관계를_삭제한다() {
        List<String> hashtagsToRemove = new LinkedList<>();
        hashtagsToRemove.add("태그1");

        reviewHashtagService.removeHashtags(hashtagsToRemove);
    }
    }
 }