package com.multi.mariage.review.vo.member.write;

import lombok.AccessLevel;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Data
public class MemberReviewVO {
    private ProductInfoVO productInfo;
    private ReviewInfoVO reviewInfo;

    @Builder
    private MemberReviewVO(ProductInfoVO productInfo, ReviewInfoVO reviewInfo) {
        this.productInfo = productInfo;
        this.reviewInfo = reviewInfo;
    }

    public static MemberReviewVO from(ProductInfoVO productInfo, ReviewInfoVO reviewInfo) {
        return MemberReviewVO.builder()
                .productInfo(productInfo)
                .reviewInfo(reviewInfo)
                .build();
    }
}
