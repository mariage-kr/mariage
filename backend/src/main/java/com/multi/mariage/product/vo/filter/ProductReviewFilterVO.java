package com.multi.mariage.product.vo.filter;

import com.multi.mariage.product.domain.Product;
import lombok.AccessLevel;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Data
public class ProductReviewFilterVO {
    private double reviewRate;
    private int reviewCount;

    @Builder
    private ProductReviewFilterVO(double reviewRate, int reviewCount) {
        this.reviewRate = reviewRate;
        this.reviewCount = reviewCount;
    }

    public static ProductReviewFilterVO from(Product product) {
        return ProductReviewFilterVO.builder()
                .reviewRate(product.getAvgReviewRate())
                .reviewCount(product.getReviews().size())
                .build();
    }
}
