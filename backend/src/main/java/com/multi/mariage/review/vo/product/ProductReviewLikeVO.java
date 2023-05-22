package com.multi.mariage.review.vo.product;

import lombok.AccessLevel;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Data
public class ProductReviewLikeVO {
    private boolean isLiked;
    private int count;
}
