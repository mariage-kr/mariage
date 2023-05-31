package com.multi.mariage.product.vo.filter;

import com.multi.mariage.product.domain.Product;
import lombok.AccessLevel;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Slf4j
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
        log.info("[{}] Review Size : [{}]", product.getName(), product.getReviews().size());
        return ProductReviewFilterVO.builder()
                .reviewRate(product.getAvgReviewRate())
                .reviewCount(product.getReviews().size())
                .build();
    }
}
