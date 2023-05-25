package com.multi.mariage.product.dto.response;

import com.multi.mariage.product.vo.*;
import lombok.AccessLevel;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Data
public class ProductDetailPageResponse {
    private Long productId;
    private ProductContentVO content;
    private ProductReviewStatsVO rating;
    private List<FoodRateRankingVO> foodRateRanking;
    private List<FoodCountRankingVO> foodCountRanking;

    @Builder
    private ProductDetailPageResponse(Long productId, ProductContentVO content, ProductReviewStatsVO rating, List<FoodRateRankingVO> foodRateRanking, List<FoodCountRankingVO> foodCountRanking) {
        this.productId = productId;
        this.content = content;
        this.rating = rating;
        this.foodRateRanking = foodRateRanking;
        this.foodCountRanking = foodCountRanking;
    }

    public static ProductDetailPageResponse from(Long productId, ProductContentVO content, ProductReviewStatsVO rating, List<FoodRateRankingVO> foodRateRanking, List<FoodCountRankingVO> foodCountRanking) {
        return new ProductDetailPageResponse(productId, content, rating, foodRateRanking, foodCountRanking);
    }
}
