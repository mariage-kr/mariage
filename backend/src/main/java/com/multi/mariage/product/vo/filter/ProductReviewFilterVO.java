package com.multi.mariage.product.vo.filter;

import lombok.AccessLevel;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Data
public class ProductReviewFilterVO {
    private double reviewRate;
    private double reviewCount;

    @Builder
    public ProductReviewFilterVO(double reviewRate, double reviewCount) {
        this.reviewRate = reviewRate;
        this.reviewCount = reviewCount;
    }
}
