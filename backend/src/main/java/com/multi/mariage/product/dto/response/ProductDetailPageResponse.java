package com.multi.mariage.product.dto.response;

import com.multi.mariage.product.vo.ProductContentVO;
import com.multi.mariage.product.vo.ProductReviewRankCountVO;
import com.multi.mariage.product.vo.ProductReviewRankRateVO;
import com.multi.mariage.product.vo.ProductReviewStatsVO;
import lombok.AccessLevel;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Data
public class ProductDetailPageResponse {
    private Long productId;
    private ProductContentVO content;
    private ProductReviewStatsVO rating;
    private ProductReviewRankRateVO foodRateRanking;
    private ProductReviewRankCountVO foodCountRanking;

    @Builder
    private ProductDetailPageResponse(Long productId, ProductContentVO content, ProductReviewStatsVO rating, ProductReviewRankRateVO foodRateRanking, ProductReviewRankCountVO foodCountRanking) {
        this.productId = productId;
        this.content = content;
        this.rating = rating;
        this.foodRateRanking = foodRateRanking;
        this.foodCountRanking = foodCountRanking;
    }

    public static ProductDetailPageResponse from(Long productId, ProductContentVO content, ProductReviewStatsVO rating, ProductReviewRankRateVO foodRateRanking, ProductReviewRankCountVO foodCountRanking) {
        return new ProductDetailPageResponse(productId, content, rating, foodRateRanking, foodCountRanking);
    }
}
