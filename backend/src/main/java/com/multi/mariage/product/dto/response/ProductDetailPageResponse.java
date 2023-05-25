package com.multi.mariage.product.dto.response;

import lombok.AccessLevel;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Data
public class ProductDetailPageResponse {
    private Long productId;
    private ProductContentResponse content;
    private ProductReviewStatsResponse rating;
    private ProductReviewRankRateResponse foodRateRanking;
    private ProductReviewRankCountResponse foodCountRanking;

    @Builder
    private ProductDetailPageResponse(Long productId, ProductContentResponse content, ProductReviewStatsResponse rating, ProductReviewRankRateResponse foodRateRanking, ProductReviewRankCountResponse foodCountRanking) {
        this.productId = productId;
        this.content = content;
        this.rating = rating;
        this.foodRateRanking = foodRateRanking;
        this.foodCountRanking = foodCountRanking;
    }

    public static ProductDetailPageResponse from(Long productId, ProductContentResponse content, ProductReviewStatsResponse rating, ProductReviewRankRateResponse foodRateRanking, ProductReviewRankCountResponse foodCountRanking) {
        return new ProductDetailPageResponse(productId, content, rating, foodRateRanking, foodCountRanking);
    }
}
