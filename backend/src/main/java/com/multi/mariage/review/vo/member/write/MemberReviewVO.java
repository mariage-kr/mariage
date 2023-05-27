package com.multi.mariage.review.vo.member.write;

import lombok.AccessLevel;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Data
public class MemberReviewVO {
    private ProductInfoVO productContent;
    private ReviewInfoVO productReview;

    @Builder
    private MemberReviewVO(ProductInfoVO productContent, ReviewInfoVO productReview) {
        this.productContent = productContent;
        this.productReview = productReview;
    }

    public static MemberReviewVO from(ProductInfoVO productContent, ReviewInfoVO productReview) {
        return MemberReviewVO.builder()
                .productContent(productContent)
                .productReview(productReview)
                .build();
    }
}
