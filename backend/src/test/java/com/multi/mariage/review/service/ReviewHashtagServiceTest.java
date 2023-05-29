package com.multi.mariage.review.service;

import com.multi.mariage.common.annotation.ServiceTest;
import com.multi.mariage.common.fixture.ImageFixture;
import com.multi.mariage.common.fixture.MemberFixture;
import com.multi.mariage.common.fixture.ProductFixture;
import com.multi.mariage.common.fixture.ReviewFixture;
import com.multi.mariage.member.domain.Member;
import com.multi.mariage.hashtag.domain.Hashtag;
import com.multi.mariage.product.domain.Product;
import com.multi.mariage.review.domain.Review;
import com.multi.mariage.review.domain.ReviewHashtagRepository;
import com.multi.mariage.review.service.ReviewHashtagService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import java.util.LinkedList;
import java.util.List;

@ExtendWith(SpringExtension.class)
@DataJpaTest
class ReviewHashtagServiceTest extends ServiceTest {

    private Long reviewId;
    private ReviewFixture reviewFixture;
    private Review review;
    private Hashtag hashtag;

    @Autowired
    private ReviewHashtagRepository reviewHashtagRepository;

    @Autowired
    private ReviewHashtagService reviewHashtagService;

    @BeforeEach
    void setUp() {
        reviewFixture = ReviewFixture.참이슬_과자;

        Member member = signup(MemberFixture.MARI);
        Long imageId = saveImage(ImageFixture.JPEG_IMAGE).getImageId();
        Product product = saveProduct(ProductFixture.참이슬, imageId);

        reviewFixture.addHashtag(new Hashtag("참이슬과자"));
        reviewFixture.addHashtag(new Hashtag("태그2"));
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
        hashtagsToRemove.add("참이슬과자");
        reviewHashtagService.removeHashtags(hashtagsToRemove);
    }

}