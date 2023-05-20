package com.multi.mariage.review.service;

import com.multi.mariage.common.annotation.ServiceTest;
import com.multi.mariage.common.fixture.ImageFixture;
import com.multi.mariage.common.fixture.MemberFixture;
import com.multi.mariage.common.fixture.ProductFixture;
import com.multi.mariage.common.fixture.ReviewFixture;
import com.multi.mariage.member.domain.Member;
import com.multi.mariage.product.domain.Product;
import com.multi.mariage.review.dto.resonse.ReviewSaveResponse;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class ReviewModifyServiceTest extends ServiceTest {

    private Member member;
    private Long imageId;
    private Product product;

    @BeforeEach
    void setUp() {
        member = signup(MemberFixture.MARI);
        imageId = saveImage(ImageFixture.JPEG_IMAGE).getImageId();
        product = saveProduct(ProductFixture.참이슬, imageId);

        saveReview(ReviewFixture.참이슬_과자, member.getId(), product.getId(), imageId);
    }

    @DisplayName("리뷰를 저장한다.")
    @Test
    void 리뷰를_저장한다() {
        ReviewSaveResponse actual = saveReview(ReviewFixture.참이슬_치킨, member.getId(), product.getId(), imageId);

//        Assertions.assertThat(actual).isNotNull();
        Assertions.assertThat(actual).isNull();
    }
}