package com.multi.mariage.review.vo.product;

import lombok.AccessLevel;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Data
public class ProductReviewLikeVO {
    private boolean isLiked;
    private int count;

    @Builder
    public ProductReviewLikeVO(boolean isLiked, int count) {
        this.isLiked = isLiked;
        this.count = count;
    }
}
