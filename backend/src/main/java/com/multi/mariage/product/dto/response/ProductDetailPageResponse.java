package com.multi.mariage.product.dto.response;

import com.multi.mariage.product.domain.Product;
import com.multi.mariage.product.vo.filter.FoodCountVO;
import lombok.AccessLevel;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Data
public class ProductDetailPageResponse {
    private Long id;
    private ProductContentResponse content;
    private ProductReviewStatsResponse rating;
    private ProductReviewRankRateResponse foodRateRanking;
    private ProductReviewRankCountResponse foodCountRanking;

    @Builder
    private ProductDetailPageResponse(Long id, ProductContentResponse content, ProductReviewStatsResponse rating, ProductReviewRankRateResponse foodRateRanking, ProductReviewRankCountResponse foodCountRanking) {
        this.id = id;
        this.content = content;
        this.rating = rating;
        this.foodRateRanking = foodRateRanking;
        this.foodCountRanking = foodCountRanking;
    }

    public static ProductDetailPageResponse from(Long id, ProductContentResponse content, ProductReviewStatsResponse rating, ProductReviewRankRateResponse foodRateRanking, ProductReviewRankCountResponse foodCountRanking) {
        return new ProductDetailPageResponse(id, content, rating, foodRateRanking, foodCountRanking);
    }
}
