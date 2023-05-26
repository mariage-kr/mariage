package com.multi.mariage.review.vo.my.review;

import com.multi.mariage.product.vo.ProductContentVO;
import lombok.AccessLevel;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Data
public class MyReviewVO {
    private ProductContentVO productContent;
    private MyProductReviewVO productReview;

    @Builder
    private MyReviewVO(ProductContentVO productContent, MyProductReviewVO productReview) {
        this.productContent = productContent;
        this.productReview = productReview;
    }

    public static MyReviewVO from(ProductContentVO productContent, MyProductReviewVO productReview) {
        return MyReviewVO.builder()
                .productContent(productContent)
                .productReview(productReview)
                .build();
    }
}
